package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.XiajiListBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.contract.XiajiSHDeviceListOnContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.model.XiajiSHDeviceListOnModel;

import io.reactivex.functions.Consumer;

public class XiajiSHDeviceListOnPresenter extends BasePresenter<XiajiSHDeviceListOnContract.View> implements XiajiSHDeviceListOnContract.Presenter {
    private XiajiSHDeviceListOnContract.Model model;

    public XiajiSHDeviceListOnPresenter() {
        model = new XiajiSHDeviceListOnModel();
    }

    @Override
    public void getData(String id, String deviceid, String dentails, String state) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id, deviceid, dentails, state).compose(RxScheduler.<XiajiListBean>Flo_io_main())
                .subscribe(new Consumer<XiajiListBean>() {
                    @Override
                    public void accept(XiajiListBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
