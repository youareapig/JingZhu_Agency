package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.XiajiListBean;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.contract.XiajiSHDeviceListOnContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.presenter.XiajiSHDeviceListOnPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class XiajiSHDeviceListOn_Fragment extends BaseMvpFragment<XiajiSHDeviceListOnPresenter> implements XiajiSHDeviceListOnContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout finishRefresh;
    private List<XiajiListBean.DataBean> list;
    private Adapter adapter;
    private String id;
    private String deviceId, price;

    public XiajiSHDeviceListOn_Fragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new XiajiSHDeviceListOnPresenter();
        mPresenter.attachView(this);

        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(id, deviceId, price, "1");
            }
        });
        finishRefresh.setCanLoadMore(false);
        finishRefresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getDataFresh(id, deviceId, price, "1");
                        finishRefresh.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        deviceId = SharedPreferencesUtil.getInstance(getActivity()).getSP("xiajiId");
        price = SharedPreferencesUtil.getInstance(getActivity()).getSP("xiajiPrice");
        mPresenter.getData(id, deviceId, price, "1");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xiajishdeviceliston_fragment;
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
    public void onSuccess(XiajiListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(XiajiListBean bean) {
        initData(bean);
    }

    private void initData(XiajiListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            adapter = new Adapter(R.layout.xiajishdevice_on_item, list);
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

}
