package com.xiaomai.ageny.order.fragment.lowerorder.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.LowerOrderBean;
import com.xiaomai.ageny.bean.MyOrderBean;

import io.reactivex.Flowable;

public interface LowerOrderContract {
    interface Model {
        Flowable<LowerOrderBean> getData(String orderid, String sellername, String startTime, String endTime,String page,String pagesize);

        Flowable<LowerOrderBean> getRefrsh(String orderid, String sellername, String startTime, String endTime, String page,String pagesize);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(LowerOrderBean bean);

        void onFreshSuccess(LowerOrderBean bean);

        void onFreshError(Throwable throwable);
    }

    interface Presenter {
        void getData(String orderid, String sellername, String startTime, String endTime,String page,String pagesize);

        void getRefrsh(String orderid, String sellername, String startTime, String endTime, String page,String pagesize);
    }
}
