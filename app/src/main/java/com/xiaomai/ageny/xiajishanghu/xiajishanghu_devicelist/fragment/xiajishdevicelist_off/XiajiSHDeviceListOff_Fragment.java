package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.XiajiListBean;
import com.xiaomai.ageny.utils.ToastUtil;
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
    Unbinder unbinder;
    private List<XiajiListBean.DataBean> list;
    private Adapter adapter;
    private String id;

    public XiajiSHDeviceListOff_Fragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        mPresenter = new XIajiSHDeviceListOffPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id, "", "", "0");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.xiajishdevicelistoff_fragment;
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
        if (bean.getCode()==1){
            list=bean.getData();
            adapter = new Adapter(R.layout.xiajishdevice_off_item, list);
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


}
