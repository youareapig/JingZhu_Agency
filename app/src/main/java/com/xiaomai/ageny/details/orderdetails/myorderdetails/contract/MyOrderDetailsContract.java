package com.xiaomai.ageny.details.orderdetails.myorderdetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.MyOrderDetailsBean;

import io.reactivex.Flowable;

public interface MyOrderDetailsContract {
    interface Model {
        Flowable<MyOrderDetailsBean> getData(String orderid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(MyOrderDetailsBean bean);

    }

    interface Presenter {
        void getData(String orderid);
    }
}
