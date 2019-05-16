package com.xiaomai.ageny.device_popu.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.PopDeviceBean;
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
        model.popu(deviceid, slot).compose(RxScheduler.<PopDeviceBean>Flo_io_main())
                .as(mView.<PopDeviceBean>bindAutoDispose())
                .subscribe(new Consumer<PopDeviceBean>() {
                    @Override
                    public void accept(PopDeviceBean bean) throws Exception {
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


}
