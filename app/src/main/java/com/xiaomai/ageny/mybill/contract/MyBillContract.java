package com.xiaomai.ageny.mybill.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.UserInfoBean;

import io.reactivex.Flowable;

public interface MyBillContract {
    interface Model {
        Flowable<BillListBean> getData();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BillListBean bean);

        void onSuccessFresh(BillListBean bean);
    }

    interface Presenter {
        void getData();

        void getDataFresh();
    }
}
