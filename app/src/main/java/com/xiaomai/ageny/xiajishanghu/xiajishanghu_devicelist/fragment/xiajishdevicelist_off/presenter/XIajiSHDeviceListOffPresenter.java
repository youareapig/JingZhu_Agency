package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.XiajiListBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.contract.XIajiSHDeviceListOffContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.model.XIajiSHDeviceListOffModel;

import io.reactivex.functions.Consumer;

public class XIajiSHDeviceListOffPresenter extends BasePresenter<XIajiSHDeviceListOffContract.View> implements XIajiSHDeviceListOffContract.Presenter {
    private XIajiSHDeviceListOffContract.Model model;

    public XIajiSHDeviceListOffPresenter() {
        model = new XIajiSHDeviceListOffModel();
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
                        mView.hideLoading();
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }

    @Override
    public void getDataFresh(String id, String deviceid, String dentails, String state) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(id, deviceid, dentails, state).compose(RxScheduler.<XiajiListBean>Flo_io_main())
                .subscribe(new Consumer<XiajiListBean>() {
                    @Override
                    public void accept(XiajiListBean bean) throws Exception {
                        mView.onSuccessFresh(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
