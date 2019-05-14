package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off;

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
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.contract.XIajiSHDeviceListOffContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.presenter.XIajiSHDeviceListOffPresenter;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.presenter.XiajiSHDeviceListOnPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class XiajiSHDeviceListOff_Fragment extends BaseMvpFragment<XIajiSHDeviceListOffPresenter> implements XIajiSHDeviceListOffContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout finishRefresh;
    private List<XiajiListBean.DataBean> list;
    private Adapter adapter;
    private String id, deviceId, price;

    public XiajiSHDeviceListOff_Fragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new XIajiSHDeviceListOffPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(id, deviceId, price, "0");
            }
        });
        finishRefresh.setCanLoadMore(false);
        finishRefresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getDataFresh(id, deviceId, price, "0");
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
        mPresenter.getData(id, deviceId, price, "0");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xiajishdevicelistoff_fragment;
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
        finishRefresh.finishRefresh();
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(XiajiListBean bean) {
        initData(bean);

    }

    private void initData(XiajiListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            adapter = new Adapter(R.layout.xiajishdevice_off_item, list);
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessFresh(XiajiListBean bean) {
        finishRefresh.finishRefresh();
        initData(bean);
    }


}
