package com.xiaomai.ageny.device_manage.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DeviceManageBean;
import com.xiaomai.ageny.device_manage.contract.DeviceManageContract;
import com.xiaomai.ageny.device_manage.model.DeviceManageModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceManagePresenter extends BasePresenter<DeviceManageContract.View> implements DeviceManageContract.Presenter {
    private DeviceManageContract.Model model;

    public DeviceManagePresenter() {
        model=new DeviceManageModel();
    }

    @Override
    public void getData() {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData().compose(RxScheduler.<DeviceManageBean>Flo_io_main())
                .subscribe(new Consumer<DeviceManageBean>() {
                    @Override
                    public void accept(DeviceManageBean bean) throws Exception {
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
