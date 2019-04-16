package com.xiaomai.ageny.addcontact.presenter;

import com.xiaomai.ageny.addcontact.contract.AddContactContract;
import com.xiaomai.ageny.addcontact.model.AddContactModel;
import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactUpdateUserInfoBean;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;
import okhttp3.RequestBody;

public class AddContactPresenter extends BasePresenter<AddContactContract.View> implements AddContactContract.Presenter {
    private AddContactContract.Model model;

    public AddContactPresenter() {
        model=new AddContactModel();
    }

    @Override
    public void getData(RequestBody requestBody) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(requestBody).compose(RxScheduler.<ContactUpdateUserInfoBean>Flo_io_main())
                .subscribe(new Consumer<ContactUpdateUserInfoBean>() {
                    @Override
                    public void accept(ContactUpdateUserInfoBean bean) throws Exception {
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
    public void AddContanct(RequestBody requestBody) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.AddContanct(requestBody).compose(RxScheduler.<ContactUpdateUserInfoBean>Flo_io_main())
                .subscribe(new Consumer<ContactUpdateUserInfoBean>() {
                    @Override
                    public void accept(ContactUpdateUserInfoBean bean) throws Exception {
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
