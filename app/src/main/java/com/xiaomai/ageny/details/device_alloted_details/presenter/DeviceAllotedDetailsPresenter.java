package com.xiaomai.ageny.details.device_alloted_details.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.DeviceAllotedDetailsBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.details.device_alloted_details.contract.DeviceAllotedDetailsContract;
import com.xiaomai.ageny.details.device_alloted_details.model.DeviceAllotedDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceAllotedDetailsPresenter extends BasePresenter<DeviceAllotedDetailsContract.View> implements DeviceAllotedDetailsContract.Presenter {
    private DeviceAllotedDetailsContract.Model model;

    public DeviceAllotedDetailsPresenter() {
        model=new DeviceAllotedDetailsModel();
    }

    @Override
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid).compose(RxScheduler.<DeviceAllotedDetailsBean>Flo_io_main())
                .as(mView.<DeviceAllotedDetailsBean>bindAutoDispose())
                .subscribe(new Consumer<DeviceAllotedDetailsBean>() {
                    @Override
                    public void accept(DeviceAllotedDetailsBean bean) throws Exception {
                        mView.hideLoading();
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.hideLoading();
                        mView.onError(throwable);

                    }
                });

    }
}
