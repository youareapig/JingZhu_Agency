package com.xiaomai.ageny.device_manage.device_noallot.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.NoAllotDeviceBean;
import com.xiaomai.ageny.device_manage.device_noallot.contract.DeviceNoAllotContract;
import com.xiaomai.ageny.device_manage.device_noallot.model.DeviceNoAllotModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceNoAllotPresenter extends BasePresenter<DeviceNoAllotContract.View> implements DeviceNoAllotContract.Presenter {
    private DeviceNoAllotContract.Model model;

    public DeviceNoAllotPresenter() {
        model = new DeviceNoAllotModel();
    }

    @Override
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid).compose(RxScheduler.<NoAllotDeviceBean>Flo_io_main())
                .subscribe(new Consumer<NoAllotDeviceBean>() {
                    @Override
                    public void accept(NoAllotDeviceBean bean) throws Exception {
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
    public void getDataFresh(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(deviceid).compose(RxScheduler.<NoAllotDeviceBean>Flo_io_main())
                .subscribe(new Consumer<NoAllotDeviceBean>() {
                    @Override
                    public void accept(NoAllotDeviceBean bean) throws Exception {
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
