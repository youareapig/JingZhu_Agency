package com.xiaomai.ageny.deposit_list.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DepositListBean;

import io.reactivex.Flowable;

public interface DepositListContract {
    interface Model {
        Flowable<DepositListBean> getData(String page, String page_size, String state, String orderid, String price_start, String price_end);

    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DepositListBean bean);

        void onSuccessFresh(DepositListBean bean);

        void onSuccessLoadMore(DepositListBean bean);
    }

    interface Presenter {
        void getData(String page, String page_size, String state, String orderid, String price_start, String price_end);

        void getDataFresh(String page, String page_size, String state, String orderid, String price_start, String price_end);

        void getDataLoadMore(String page, String page_size, String state, String orderid, String price_start, String price_end);
    }
}
