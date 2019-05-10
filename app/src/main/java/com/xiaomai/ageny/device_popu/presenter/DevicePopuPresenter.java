package com.xiaomai.ageny.device_popu.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_popu.contract.DevicePopuContract;
import com.xiaomai.ageny.device_popu.model.DevicePopuModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DevicePopuPresenter extends BasePresenter<DevicePopuContract.View> implements DevicePopuContract.Presenter {
    private DevicePopuContract.Model model;

    public DevicePopuPresenter() {
        model = new DevicePopuModel();
    }

    @Override
    public void popu(String deviceid, String slot) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.popu(deviceid, slot).compose(RxScheduler.<HintBean>Flo_io_main())
                .as(mView.<HintBean>bindAutoDispose())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
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
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(deviceid).compose(RxScheduler.<ShowHoleBean>Flo_io_main())
                .as(mView.<ShowHoleBean>bindAutoDispose())
                .subscribe(new Consumer<ShowHoleBean>() {
                    @Override
                    public void accept(ShowHoleBean bean) throws Exception {
                        mView.onSuccess(bean);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                    }
                });
    }
}
