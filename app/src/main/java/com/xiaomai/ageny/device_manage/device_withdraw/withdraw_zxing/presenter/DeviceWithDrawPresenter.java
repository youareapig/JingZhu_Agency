package com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.contract.DeviceWithDrawContract;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.model.DeviceWithDrawModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceWithDrawPresenter extends BasePresenter<DeviceWithDrawContract.View> implements DeviceWithDrawContract.Presenter {
    private DeviceWithDrawContract.Model model;

    public DeviceWithDrawPresenter() {
        model = new DeviceWithDrawModel();
    }

    @Override
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid).compose(RxScheduler.<DeviceWithDrawListBean>Flo_io_main())
                .subscribe(new Consumer<DeviceWithDrawListBean>() {
                    @Override
                    public void accept(DeviceWithDrawListBean bean) throws Exception {
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
