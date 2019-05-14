package com.xiaomai.ageny.task.indirect_task;

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
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.task.indirect_task.contract.TaskIndirectContract;
import com.xiaomai.ageny.task.indirect_task.presenter.TaskIndirectPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TaskIndirectFragment extends BaseMvpFragment<TaskIndirectPresenter> implements TaskIndirectContract.View {
    @BindView(R.id.offline_num)
    TextView offlineNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.refresh)
    PullToRefreshLayout finishRefresh;
    private Adapter adapter;
    private List<OffIndirectDeivceBean.DataBean.ListBean> list;

    @Override
    protected void initView(View view) {
        otherview.setHolder(mHolder);
        mPresenter = new TaskIndirectPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "1");
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", "", "", "1");
            }
        });
        finishRefresh.setCanLoadMore(false);
        finishRefresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getDataFresh("", "", "", "1");
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.task_indirect_fragment;
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
        finishRefresh.finishRefresh();
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(OffIndirectDeivceBean bean) {
        initData(bean);

    }

    @Override
    public void onSuccessFresh(OffIndirectDeivceBean bean) {
        finishRefresh.finishRefresh();
        initData(bean);
    }

    private void initData(OffIndirectDeivceBean bean) {
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().get(0).getCountlinxianbox());
            list = bean.getData().get(0).getList();
            if (list.size() == 0) {
                otherview.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.task_indirect_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }
}
