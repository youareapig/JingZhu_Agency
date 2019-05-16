package com.xiaomai.ageny.device_popu.popu_zxing.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_popu.popu_zxing.contract.PopuDeviceContract;
import com.xiaomai.ageny.device_popu.popu_zxing.model.PopuDeviceModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class PopuDevicePresenter extends BasePresenter<PopuDeviceContract.View> implements PopuDeviceContract.Presenter {
    private PopuDeviceContract.Model model;

    public PopuDevicePresenter() {
        model=new PopuDeviceModel();
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
