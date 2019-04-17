package com.xiaomai.ageny.order.fragment.myorder.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.MyOrderBean;

import io.reactivex.Flowable;

public interface MyOrderContract {
    interface Model {
        Flowable<MyOrderBean> getData(String orderid, String sellername, String startTime, String endTime);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(MyOrderBean bean);

    }

    interface Presenter {
        void getData(String orderid, String sellername, String startTime, String endTime);
    }
}
