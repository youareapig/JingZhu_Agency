package com.xiaomai.ageny.device_manage.device_alloted.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.DeviceManageBean;

import io.reactivex.Flowable;

public interface DeviceAllotedContract {
    interface Model {
        Flowable<AllotDeviceBean> getData(String deviceid, String mobile, String page, String pagesize,String msgid);

        Flowable<DeviceManageBean> getCount();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(AllotDeviceBean bean);

        void onSuccess(DeviceManageBean bean);

        void onSuccessFresh(AllotDeviceBean bean);

        void onSuccessLoadMore(AllotDeviceBean bean);

    }

    interface Presenter {
        void getData(String deviceid, String mobile, String page, String pagesize,String msgid);

        void getDataFresh(String deviceid, String mobile, String page, String pagesize,String msgid);

        void getDataLoadMore(String deviceid, String mobile, String page, String pagesize,String msgid);

        void getCount();
    }
}
