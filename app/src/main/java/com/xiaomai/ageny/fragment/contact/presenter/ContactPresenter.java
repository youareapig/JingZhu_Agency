package com.xiaomai.ageny.fragment.contact.presenter;

import com.xiaomai.ageny.base.BasePresenter;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.fragment.contact.contract.ContactContract;
import com.xiaomai.ageny.fragment.contact.model.ContactModel;
import com.xiaomai.ageny.net.RxScheduler;

import io.reactivex.functions.Consumer;

public class ContactPresenter extends BasePresenter<ContactContract.View> implements ContactContract.Presenter {
    private ContactContract.Model model;

    public ContactPresenter() {
        model = new ContactModel();
    }

    @Override
    public void getData(String mobile, String sellerId, String isbyearn) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getData(mobile, sellerId, isbyearn).compose(RxScheduler.<ContactListBean>Flo_io_main())
                .subscribe(new Consumer<ContactListBean>() {
                    @Override
                    public void accept(ContactListBean bean) throws Exception {
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
