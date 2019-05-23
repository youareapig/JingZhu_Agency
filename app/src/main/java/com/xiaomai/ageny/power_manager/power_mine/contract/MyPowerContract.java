package com.xiaomai.ageny.power_manager.power_mine.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.MyPowerListBean;
import com.xiaomai.ageny.bean.PowerManagerBean;

import io.reactivex.Flowable;

public interface MyPowerContract {
    interface Model {
        Flowable<MyPowerListBean> getData(String id, String page, String pagesize);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(MyPowerListBean bean);

        void onSuccessLoadMore(MyPowerListBean bean);

        void onSuccessFresh(MyPowerListBean bean);
    }

    interface Presenter {
        void getData(String id, String page, String pagesize);

        void getDataFresh(String id, String page, String pagesize);

        void getDataLoadMore(String id, String page, String pagesize);
    }
}
