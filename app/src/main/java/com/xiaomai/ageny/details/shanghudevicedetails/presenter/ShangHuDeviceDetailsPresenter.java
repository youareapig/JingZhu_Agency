package com.xiaomai.ageny.details.shanghudevicedetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.details.shanghudevicedetails.contract.ShangHuDeviceDetailsContract;
import com.xiaomai.ageny.details.shanghudevicedetails.model.ShangHuDeviceDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class ShangHuDeviceDetailsPresenter extends BasePresenter<ShangHuDeviceDetailsContract.View> implements ShangHuDeviceDetailsContract.Presenter {
    private ShangHuDeviceDetailsContract.Model model;

    public ShangHuDeviceDetailsPresenter() {
        model = new ShangHuDeviceDetailsModel();
    }

    @Override
    public void getData(String id,String msgid) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id,msgid).compose(RxScheduler.<ContactDeviceDetailsBean>Flo_io_main())
                .as(mView.<ContactDeviceDetailsBean>bindAutoDispose())
                .subscribe(new Consumer<ContactDeviceDetailsBean>() {
                    @Override
                    public void accept(ContactDeviceDetailsBean bean) throws Exception {
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
    public void updatePrice(String id, String price) {
        if (!isViewAttached()) {
            return;
        }
        mView.showProcess();
        model.updatePrice(id,price).compose(RxScheduler.<HintBean>Flo_io_main())
                .as(mView.<HintBean>bindAutoDispose())
                .subscribe(new Consumer<HintBean>() {
                    @Override
                    public void accept(HintBean bean) throws Exception {
                        mView.hideProcess();
                        mView.onSuccess(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onErrorProcess(throwable);
                    }
                });
    }
}
