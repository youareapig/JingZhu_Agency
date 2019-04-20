package com.xiaomai.ageny.shanghudevice.fragment.ondevice.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.net.RxScheduler;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.contract.OnDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.model.OnDeviceModel;

import io.reactivex.functions.Consumer;

public class OnDevicePresenter extends BasePresenter<OnDeviceContract.View> implements OnDeviceContract.Presenter {
    private OnDeviceContract.Model model;
    public OnDevicePresenter() {
        model=new OnDeviceModel();
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
}
