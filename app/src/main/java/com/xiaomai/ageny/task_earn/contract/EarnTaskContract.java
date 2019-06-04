package com.xiaomai.ageny.task_earn.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceEarnListBean;

import io.reactivex.Flowable;

public interface EarnTaskContract {
    interface Model {
        Flowable<DeviceEarnListBean> getData(String page, String pagesize);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DeviceEarnListBean bean);

        void onSuccessFresh(DeviceEarnListBean bean);

        void onSuccessLoadMore(DeviceEarnListBean bean);
    }

    interface Presenter {
        void getData(String page, String pagesize);

        void getDataFresh(String page, String pagesize);

        void getDataLoadMore(String page, String pagesize);
    }
}
