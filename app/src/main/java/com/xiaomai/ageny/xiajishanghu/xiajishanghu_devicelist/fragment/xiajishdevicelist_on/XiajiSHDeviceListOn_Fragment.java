package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.XiajiListBean;
import com.xiaomai.ageny.utils.ToastUtil;
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

    private List<XiajiListBean.DataBean> list;
    private Adapter adapter;
    private String id;

    public XiajiSHDeviceListOn_Fragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        mPresenter = new XiajiSHDeviceListOnPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id, "", "", "1");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.xiajishdeviceliston_fragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(XiajiListBean bean) {
        if (bean.getCode() == 1) {
            list=bean.getData();
            adapter = new Adapter(R.layout.xiajishdevice_on_item, list);
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


}
