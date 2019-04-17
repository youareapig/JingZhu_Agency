package com.xiaomai.ageny.details.orderdetails.lowerorderdetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.LowerOrderDetailsBean;

import io.reactivex.Flowable;

public interface LowerOrderDetailsContract {
    interface Model {
        Flowable<LowerOrderDetailsBean> getData(String orderid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(LowerOrderDetailsBean bean);
    }

    interface Presenter {
        void getData(String orderid);
    }
}
