package com.xiaomai.ageny.task.direct_task;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.task.direct_task.contract.TaskDirectContract;
import com.xiaomai.ageny.task.direct_task.presenter.TaskDirectPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TaskDirectFragment extends BaseMvpFragment<TaskDirectPresenter> implements TaskDirectContract.View {

    @BindView(R.id.offline_num)
    TextView offlineNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.refresh)
    PullToRefreshLayout finishRefresh;

    private Adapter adapter;
    private List<OffDirectDeviceBean.DataBean.ListBeanX.ListBean> list=new ArrayList<>();
    private int page=1;

    @Override
    protected void initView(View view) {
        otherview.setHolder(mHolder);
        mPresenter = new TaskDirectPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "1","1",App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", "", "", "1","1",App.pageSize);
            }
        });

        finishRefresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page=1;
                mPresenter.getDataFresh("", "", "", "1","",App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getDataLoadMore("","","","1",page+"",App.pageSize);
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.task_direct_fragment;
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
        Logger.d("throwable----"+throwable.getMessage());
        finishRefresh.finishRefresh();
        finishRefresh.finishLoadMore();
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(OffDirectDeviceBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(OffDirectDeviceBean bean) {
        finishRefresh.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(OffDirectDeviceBean bean) {
        finishRefresh.finishLoadMore();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList().get(0).getList());
            //延迟更新数据，避免卡顿
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
                }
            }, 500);
            if (bean.getData().getList().get(0).getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    private void initData(OffDirectDeviceBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().getList().get(0).getCountlinxianbox());
            list.addAll(bean.getData().getList().get(0).getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
                finishRefresh.setCanLoadMore(false);
            }else {
                finishRefresh.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.task_direct_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

}
