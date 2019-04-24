package com.xiaomai.ageny.shanghudevice.fragment.offdevice.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.shanghudevice.fragment.offdevice.contract.OffDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.offdevice.model.OffDeviceModel;

import io.reactivex.functions.Consumer;

public class OffDevicePresenter extends BasePresenter<OffDeviceContract.View> implements OffDeviceContract.Presenter {
    private OffDeviceContract.Model model;
    public OffDevicePresenter() {
        model=new OffDeviceModel();
    }

    @Override
    public void getData(String sellerid, String state, String deviceid, String device_type) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(sellerid, state, deviceid, device_type).compose(RxScheduler.<ContactDeviceListBean>Flo_io_main())
                .subscribe(new Consumer<ContactDeviceListBean>() {
                    @Override
                    public void accept(ContactDeviceListBean bean) throws Exception {
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

    @Override
    public void getDataFresh(String sellerid, String state, String deviceid, String device_type) {
        if (!isViewAttached()) {
            return;
        }
        model.getData(sellerid, state, deviceid, device_type).compose(RxScheduler.<ContactDeviceListBean>Flo_io_main())
                .subscribe(new Consumer<ContactDeviceListBean>() {
                    @Override
                    public void accept(ContactDeviceListBean bean) throws Exception {
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
