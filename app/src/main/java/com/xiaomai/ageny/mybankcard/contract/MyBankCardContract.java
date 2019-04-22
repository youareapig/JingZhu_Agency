package com.xiaomai.ageny.mybankcard.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.MyBankBean;

import io.reactivex.Flowable;

public interface MyBankCardContract {
    interface Model {
        Flowable<MyBankBean> getData();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(MyBankBean bean);
    }

    interface Presenter {
        void getData();
    }
}
