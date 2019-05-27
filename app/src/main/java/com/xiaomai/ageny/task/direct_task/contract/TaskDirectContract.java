package com.xiaomai.ageny.task.direct_task.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;

import io.reactivex.Flowable;

public interface TaskDirectContract {
    interface Model {
        Flowable<OffDirectDeviceBean> getData(String sellername, String linkmobile, String deviceid, String state, String page, String pagesize);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OffDirectDeviceBean bean);

        void onSuccessFresh(OffDirectDeviceBean bean);

        void onSuccessLoadMore(OffDirectDeviceBean bean);
    }

    interface Presenter {
        void getData(String sellername, String linkmobile, String deviceid, String state, String page, String pagesize);

        void getDataFresh(String sellername, String linkmobile, String deviceid, String state, String page, String pagesize);

        void getDataLoadMore(String sellername, String linkmobile, String deviceid, String state, String page, String pagesize);
    }
}
