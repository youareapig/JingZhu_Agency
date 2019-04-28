package com.xiaomai.ageny.setting.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.LoginOutBean;

import io.reactivex.Flowable;

public interface SettingContract {
    interface Model {
        Flowable<LoginOutBean> loginOut();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(LoginOutBean bean);
    }

    interface Presenter {
       void loginOut();
    }
}
