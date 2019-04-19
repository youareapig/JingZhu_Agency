package com.xiaomai.ageny.deposit.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DepositBean;
import com.xiaomai.ageny.bean.IndexBean;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public interface DepositContract {
    interface Model {
        Flowable<IndexBean> getData();

        Flowable<DepositBean> getDepositBean(RequestBody requestBody);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(IndexBean bean);

        void onSuccessDeposit(DepositBean bean);
    }

    interface Presenter {
        void getData();

        void getDepositBean(RequestBody requestBody);
    }
}
