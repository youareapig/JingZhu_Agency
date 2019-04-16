package com.xiaomai.ageny.addcontact.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ContactUpdateUserInfoBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface AddContactContract {
    interface Model {
        Flowable<ContactUpdateUserInfoBean> getData(RequestBody requestBody);

        Flowable<ContactUpdateUserInfoBean> AddContanct(RequestBody requestBody);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ContactUpdateUserInfoBean bean);

    }

    interface Presenter {
        void getData(RequestBody requestBody);

        void AddContanct(RequestBody requestBody);
    }
}
