package com.xiaomai.ageny.power_manager.power_alloted;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.details.device_alloted_details.DeviceAllotedDetailsActivity;
import com.xiaomai.ageny.details.power_alloted_details.PowerAllotedDetailsActivity;
import com.xiaomai.ageny.filter.power_alloted_filter.PowerAllotedFilterActivity;
import com.xiaomai.ageny.power_manager.power_alloted.contract.PowerAllotedContract;
import com.xiaomai.ageny.power_manager.power_alloted.presenter.PowerAllotedPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerAllotedActivity extends BaseMvpActivity<PowerAllotedPresenter> implements PowerAllotedContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    @BindView(R.id.otherview)
    OtherView otherview;
    private Adapter adapter;
    private List<PowerAllotedBean.DataBean.ListBean> list=new ArrayList<>();
    private String strId, strStartTime, strEndTime;
    private Bundle bundle = new Bundle();
    private int page=1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_alloted;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mPresenter = new PowerAllotedPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strId, strStartTime, strEndTime,"1",App.pageSize);
            }
        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page=1;
                mPresenter.getDataFresh(strId, strStartTime, strEndTime,"1",App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getDataLoadMore(strId,strStartTime,strEndTime,page+"",App.pageSize);
            }
        });

    }

    private void initData(PowerAllotedBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.device_alloted_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(view.getContext(), PowerAllotedDetailsActivity.class);
                    intent.putExtra("id", list.get(position).getDeviceId());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData(strId, strStartTime, strEndTime,"1",App.pageSize);
    }

    @Override
    public void showLoading() {
        otherview.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherview.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        refresh.finishRefresh();
        refresh.finishLoadMore();
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(PowerAllotedBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(PowerAllotedBean bean) {
        refresh.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(PowerAllotedBean bean) {
        refresh.finishLoadMore();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            //延迟更新数据，避免卡顿
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
                }
            }, 500);
            if (bean.getData().getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                bundle.putString("id", strId);
                bundle.putString("start", strStartTime);
                bundle.putString("end", strEndTime);
                toClass1(this, PowerAllotedFilterActivity.class, bundle, 1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strId = data.getStringExtra("id");
            strStartTime = data.getStringExtra("start");
            strEndTime = data.getStringExtra("end");
        }
    }
}
