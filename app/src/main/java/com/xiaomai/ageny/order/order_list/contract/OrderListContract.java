package com.xiaomai.ageny.order.order_list.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.bean.OrderListBean;

import io.reactivex.Flowable;

public interface OrderListContract {
    interface Model {
        Flowable<OrderListBean> getData(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OrderListBean bean);

        void onSuccessLoadMore(OrderListBean bean);

        void onSuccessFresh(OrderListBean bean);
    }

    interface Presenter {
        void getData(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime);

        void getLoadMore(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime);

        void getRefrshFresh(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime);
    }
}
