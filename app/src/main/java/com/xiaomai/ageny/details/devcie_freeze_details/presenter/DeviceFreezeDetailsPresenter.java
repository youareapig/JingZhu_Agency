package com.xiaomai.ageny.details.devcie_freeze_details.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.FreezeDetailsBean;
import com.xiaomai.ageny.details.devcie_freeze_details.contract.DeviceFreezeDetailsContract;
import com.xiaomai.ageny.details.devcie_freeze_details.model.DeviceFreezeDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DeviceFreezeDetailsPresenter extends BasePresenter<DeviceFreezeDetailsContract.View> implements DeviceFreezeDetailsContract.Presenter {
    private DeviceFreezeDetailsContract.Model model;

    public DeviceFreezeDetailsPresenter() {
        model = new DeviceFreezeDetailsModel();
    }

    @Override
    public void getData(String deviceid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid).compose(RxScheduler.<FreezeDetailsBean>Flo_io_main())
                .subscribe(new Consumer<FreezeDetailsBean>() {
                    @Override
                    public void accept(FreezeDetailsBean bean) throws Exception {
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
    public void getData(String filler_state, String deviceid, String filler_relation) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(filler_state, deviceid, filler_relation).compose(RxScheduler.<FreezeBean>Flo_io_main())
                .subscribe(new Consumer<FreezeBean>() {
                    @Override
                    public void accept(FreezeBean bean) throws Exception {
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
