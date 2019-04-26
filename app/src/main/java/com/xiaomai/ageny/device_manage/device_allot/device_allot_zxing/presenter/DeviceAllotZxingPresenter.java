package com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DeviceAllotListBean;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.contract.DeviceAllotZxingContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.model.DeviceAllotZxingModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceAllotZxingPresenter extends BasePresenter<DeviceAllotZxingContract.View> implements DeviceAllotZxingContract.Presenter {
    private DeviceAllotZxingContract.Model model;
    public DeviceAllotZxingPresenter() {
        model=new DeviceAllotZxingModel();
    }

    @Override
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(deviceid).compose(RxScheduler.<DeviceAllotListBean>Flo_io_main())
                .subscribe(new Consumer<DeviceAllotListBean>() {
                    @Override
                    public void accept(DeviceAllotListBean bean) throws Exception {
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
