package com.xiaomai.ageny.details.devicedetails.directdetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.contract.DirectDetailsContract;
import com.xiaomai.ageny.details.devicedetails.directdetails.model.DirectDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class DirectDetailsPresenter extends BasePresenter<DirectDetailsContract.View> implements DirectDetailsContract.Presenter {
    private DirectDetailsContract.Model model;

    public DirectDetailsPresenter() {
        model = new DirectDetailsModel();
    }

    @Override
    public void getData(String deviceid,String msgid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(deviceid,msgid).compose(RxScheduler.<ContactDeviceDetailsBean>Flo_io_main())
                .subscribe(new Consumer<ContactDeviceDetailsBean>() {
                    @Override
                    public void accept(ContactDeviceDetailsBean bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
