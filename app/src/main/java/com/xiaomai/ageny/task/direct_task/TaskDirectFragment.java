package com.xiaomai.ageny.task.direct_task;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.task.direct_task.contract.TaskDirectContract;
import com.xiaomai.ageny.task.direct_task.presenter.TaskDirectPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

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
    Unbinder unbinder;
    private Adapter adapter;
    private List<OffDirectDeviceBean.DataBean.ListBean> list;

    @Override
    protected void initView(View view) {
        otherview.setHolder(mHolder);
        mPresenter = new TaskDirectPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "1");
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", "", "", "1");
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
        //item tast_direct_item
    }

    @Override
    public void onSuccess(OffDirectDeviceBean bean) {
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().get(0).getCountlinxianbox());
            list = bean.getData().get(0).getList();
            if (list.size() == 0) {
                otherview.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.task_direct_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

}
