package com.xiaomai.ageny.task_earn;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.DeviceEarnListBean;
import com.xiaomai.ageny.task_earn.contract.EarnTaskContract;
import com.xiaomai.ageny.task_earn.presenter.EarnTaskPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EarnTaskActivity extends BaseMvpActivity<EarnTaskPresenter> implements EarnTaskContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.device_num)
    TextView deviceNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    @BindView(R.id.otherview)
    OtherView otherview;
    private int page = 1;
    private List<DeviceEarnListBean.DataBean.ListBean> list = new ArrayList<>();
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_earn_task;
    }

    @Override
    public void initView() {
        //task_earn_item
        otherview.setHolder(mHolder);
        mPresenter = new EarnTaskPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("1", App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("1", App.pageSize);
            }
        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                mPresenter.getDataFresh("1", App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getDataLoadMore(page + "", App.pageSize);
            }
        });
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
        refresh.finishRefresh();
        refresh.finishLoadMore();
    }

    @Override
    public void onSuccess(DeviceEarnListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(DeviceEarnListBean bean) {
        refresh.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(DeviceEarnListBean bean) {
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
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    private void initData(DeviceEarnListBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            deviceNum.setText(bean.getData().getTotal());
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
                refresh.setCanLoadMore(false);
            } else {
                refresh.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.direct_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
