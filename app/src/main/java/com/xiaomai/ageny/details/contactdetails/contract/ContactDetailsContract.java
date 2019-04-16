package com.xiaomai.ageny.details.contactdetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;

import io.reactivex.Flowable;

public interface ContactDetailsContract {
    interface Model {
        Flowable<ContactDetailsBean> getData(String id);
        Flowable<ContactUserInfoBean> getUserInfo(String id,String tel);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ContactDetailsBean bean);

        void onSuccess(ContactUserInfoBean userInfoBean);
    }

    interface Presenter {
        void getData(String id);
        void getUserInfo(String id,String tel);
    }
}
