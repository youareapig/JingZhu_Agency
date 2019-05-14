package com.xiaomai.ageny.order.fragment.myorder.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.MyOrderBean;

import io.reactivex.Flowable;

public interface MyOrderContract {
    interface Model {
        Flowable<MyOrderBean> getData(String orderid, String sellername, String startTime, String endTime, String page, String pagesize);

    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(MyOrderBean bean);

        void onSuccessLoadMore(MyOrderBean bean);

        void onSuccessFresh(MyOrderBean bean);

    }

    interface Presenter {
        void getData(String orderid, String sellername, String startTime, String endTime, String page, String pagesize);

        void getLoadMore(String orderid, String sellername, String startTime, String endTime, String page, String pagesize);

        void getRefrshFresh(String orderid, String sellername, String startTime, String endTime, String page, String pagesize);
    }
}
