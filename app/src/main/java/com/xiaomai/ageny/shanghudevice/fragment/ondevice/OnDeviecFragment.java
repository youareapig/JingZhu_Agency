package com.xiaomai.ageny.shanghudevice.fragment.ondevice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.details.shanghudevicedetails.ShanghuDeviceDetailsActivity;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.contract.OnDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.presenter.OnDevicePresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.SpacesItemDecoration;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class OnDeviecFragment extends BaseMvpFragment<OnDevicePresenter> implements OnDeviceContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    private List<ContactDeviceListBean.DataBean.ListBean> list;
    private Adapter adapter;
    private String id;
    private Bundle bundle;
    private String deviceId = "", slotNum = "";

    public OnDeviecFragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        //初始化自定义接口

        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new OnDevicePresenter();
        mPresenter.attachView(this);

        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(id, "1", deviceId, slotNum);
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getDataFresh(id, "1", deviceId, slotNum);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        deviceId = SharedPreferencesUtil.getInstance(getActivity()).getSP("contanct_device_id");
        slotNum = SharedPreferencesUtil.getInstance(getActivity()).getSP("contanct_device_slot");
        mPresenter.getData(id, "1", deviceId, slotNum);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ondevice_fragment;
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
        refreshLayout.finishRefresh();
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(ContactDeviceListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(ContactDeviceListBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    private void initData(ContactDeviceListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.addItemDecoration(new SpacesItemDecoration(9));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.shanghudevice_on_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getId());
                    toClass(view.getContext(), ShanghuDeviceDetailsActivity.class, bundle);
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


}
