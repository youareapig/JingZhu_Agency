package com.xiaomai.ageny.login.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.LoginBean;
import com.xiaomai.ageny.bean.VerCodeBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface LoginContract {
    interface Model {
        Flowable<LoginBean> login(RequestBody body);

        Flowable<VerCodeBean> getCode(String mobile);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(LoginBean bean);

        void onSuccess(VerCodeBean bean);
    }

    interface Presenter {
        void login(RequestBody body);

        void getCode(String mobile);
    }
}
