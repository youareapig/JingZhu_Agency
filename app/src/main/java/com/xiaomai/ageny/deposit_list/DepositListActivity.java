package com.xiaomai.ageny.deposit_list;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.DepositListBean;
import com.xiaomai.ageny.deposit_list.contract.DepositListContract;
import com.xiaomai.ageny.deposit_list.presenter.DepositListPresenter;
import com.xiaomai.ageny.filter.deposit_list_filter.DepositListFilterActivity;
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

public class DepositListActivity extends BaseMvpActivity<DepositListPresenter> implements DepositListContract.View {

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
    private List<DepositListBean.DataBean.ListBean> list = new ArrayList<>();
    private int page = 1;
    private String strState;

    //0 未处理 1 已成功 -1未通过
    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit_list;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mPresenter = new DepositListPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("1", App.pageSize, strState, "", "", "");
            }
        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        mPresenter.getData("1", App.pageSize, strState, "", "", "");
                        refresh.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        mPresenter.getData_Fresh(page + "", App.pageSize, strState, "", "", "");
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        strState = SharedPreferencesUtil.getInstance(this).getSP("deposit_state");
        Logger.d("strate---" + strState);
        switch (strState) {
            case "申请中":
                strState = "0";
                break;
            case "已通过":
                strState = "1";
                break;
            case "未通过":
                strState = "-1";
                break;
        }
        mPresenter.getData("1", App.pageSize, strState, "", "", "");
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
    }

    @Override
    public void onSuccess(DepositListBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
                refresh.setCanLoadMore(false);
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.deposit_list_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        }else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }


    }

    @Override
    public void onSuccess_Fresh(DepositListBean bean) {
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
            if (bean.getData().getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }else {
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
                toClass(this, DepositListFilterActivity.class);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtil.getInstance(this).putSP("deposit_state", "");
    }
}
