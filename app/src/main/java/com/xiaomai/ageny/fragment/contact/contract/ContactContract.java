package com.xiaomai.ageny.fragment.contact.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ContactListBean;

import io.reactivex.Flowable;

public interface ContactContract {
    interface Model {
        Flowable<ContactListBean> getData(String mobile, String sellerId, String isbyearn);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ContactListBean bean);

        void onSuccess_Fresh(ContactListBean bean);
    }

    interface Presenter {
        void getData(String mobile, String sellerId, String isbyearn);

        void getData_Fresh(String mobile, String sellerId, String isbyearn);
    }
}
