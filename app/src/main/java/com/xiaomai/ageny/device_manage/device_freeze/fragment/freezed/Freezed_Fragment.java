package com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.details.devcie_freeze_details.DeviceFreezDetailsActivity;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.Adapter;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.contract.FreezedContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.presenter.FreezedPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Freezed_Fragment extends BaseMvpFragment<FreezedPresenter> implements FreezedContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    Unbinder unbinder;
    private Adapter adapter;
    private List<FreezeBean.DataBean.ListBean> list;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        mPresenter = new FreezedPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("2", "", "");
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("2", "", "");
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.freezed_fragment;
    }

    @Override
    public void showLoading() {
        otherView.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherView.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(FreezeBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.freeze_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getDeviceid());
                    bundle.putString("state","2");
                    toClass(view.getContext(), DeviceFreezDetailsActivity.class, bundle);
                }
            });
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

}
