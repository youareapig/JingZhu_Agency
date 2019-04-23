package com.xiaomai.ageny.device_manage.device_alloted.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.device_manage.device_alloted.contract.DeviceAllotedContract;
import com.xiaomai.ageny.device_manage.device_alloted.model.DeviceAllotedModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceAllotedPresenter extends BasePresenter<DeviceAllotedContract.View> implements DeviceAllotedContract.Presenter {
    private DeviceAllotedContract.Model model;
    public DeviceAllotedPresenter() {
        model=new DeviceAllotedModel();
    }

    @Override
    public void getData(String deviceid, String mobile) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid, mobile).compose(RxScheduler.<AllotDeviceBean>Flo_io_main())
                .subscribe(new Consumer<AllotDeviceBean>() {
                    @Override
                    public void accept(AllotDeviceBean bean) throws Exception {
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
