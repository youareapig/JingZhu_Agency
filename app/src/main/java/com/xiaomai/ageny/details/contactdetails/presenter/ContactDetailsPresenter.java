package com.xiaomai.ageny.details.contactdetails.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;
import com.xiaomai.ageny.details.contactdetails.contract.ContactDetailsContract;
import com.xiaomai.ageny.details.contactdetails.model.ContactDetailsModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class ContactDetailsPresenter extends BasePresenter<ContactDetailsContract.View> implements ContactDetailsContract.Presenter {
    private ContactDetailsContract.Model model;

    public ContactDetailsPresenter() {
        model = new ContactDetailsModel();
    }

    @Override
    public void getData(String id) {

        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(id).compose(RxScheduler.<ContactDetailsBean>Flo_io_main())
                .subscribe(new Consumer<ContactDetailsBean>() {
                    @Override
                    public void accept(ContactDetailsBean bean) throws Exception {
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

    @Override
    public void getUserInfo(String id, String tel) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getUserInfo(id, tel).compose(RxScheduler.<ContactUserInfoBean>Flo_io_main())
                .subscribe(new Consumer<ContactUserInfoBean>() {
                    @Override
                    public void accept(ContactUserInfoBean bean) throws Exception {
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
