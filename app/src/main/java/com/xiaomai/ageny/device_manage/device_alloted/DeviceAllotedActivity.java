package com.xiaomai.ageny.device_manage.device_alloted;

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
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.DeviceManageBean;
import com.xiaomai.ageny.details.device_alloted_details.DeviceAllotedDetailsActivity;
import com.xiaomai.ageny.device_manage.device_alloted.contract.DeviceAllotedContract;
import com.xiaomai.ageny.device_manage.device_alloted.presenter.DeviceAllotedPresenter;
import com.xiaomai.ageny.filter.device_alloted_filter.DeviceAllotedFilterActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotedActivity extends BaseMvpActivity<DeviceAllotedPresenter> implements DeviceAllotedContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.device_all_num)
    TextView deviceAllNum;
    @BindView(R.id.device_noallot)
    TextView deviceNoallot;
    @BindView(R.id.device_allot)
    TextView deviceAllot;
    @BindView(R.id.otherview1)
    OtherView otherview1;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    private List<AllotDeviceBean.DataBean.ListBean> list = new ArrayList<>();
    private Adapter adapter;
    private String strAll, strAllot, strNoallot;
    private String strTel, strId, msgId;
    private Bundle mBundle = new Bundle();
    private int page = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_alloted;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        if (intent != null) {
            msgId = intent.getStringExtra("msgId");
        }
        Logger.d("msgId-------" + msgId);
        OtherViewHolder holder = new OtherViewHolder(this);
        otherview.setHolder(mHolder);
        otherview1.setHolder(holder);
        mPresenter = new DeviceAllotedPresenter();
        mPresenter.attachView(this);
        mPresenter.getCount();
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strId, strTel, "1", App.pageSize,msgId);
            }
        });
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                mPresenter.getDataFresh(strId, strTel, "1", App.pageSize,msgId);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getDataLoadMore(strId, strTel, page + "", App.pageSize,msgId);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData(strId, strTel, "1", App.pageSize,msgId);
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
        otherview.showRetryView();
        refreshLayout.finishLoadMore();
        refreshLayout.finishRefresh();
    }

    @Override
    public void onSuccess(AllotDeviceBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess(DeviceManageBean bean) {
        if (bean.getCode() == 1) {
            strAll = bean.getData().getCountBox();
            strAllot = bean.getData().getFenpeiBox();
            strNoallot = bean.getData().getWeifenpeiBox();
            deviceAllNum.setText(strAll);
            deviceAllot.setText(strAllot);
            deviceNoallot.setText(strNoallot);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessFresh(AllotDeviceBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(AllotDeviceBean bean) {
        refreshLayout.finishLoadMore();
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

    private void initData(AllotDeviceBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            Logger.d("listSize-----" + list.size());
            if (list.size() == 0) {
                otherview1.showEmptyView();
                refreshLayout.setCanLoadMore(false);
            } else {
                otherview1.showContentView();
                refreshLayout.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.device_alloted_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    Intent intent = new Intent(view.getContext(), DeviceAllotedDetailsActivity.class);
                    intent.putExtra("id", list.get(position).getDeviceId());
                    view.getContext().startActivity(intent);
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
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
                mBundle.putString("tel", strTel);
                mBundle.putString("id", strId);
                toClass(this, DeviceAllotedFilterActivity.class, mBundle, 1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strId = data.getStringExtra("id");
            strTel = data.getStringExtra("tel");
        }
    }
}
