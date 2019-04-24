package com.xiaomai.ageny.device_manage.device_alloted.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.AllotDeviceBean;

import io.reactivex.Flowable;

public interface DeviceAllotedContract {
    interface Model {
        Flowable<AllotDeviceBean> getData(String deviceid, String mobile);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(AllotDeviceBean bean);

        void onSuccessFresh(AllotDeviceBean bean);
    }

    interface Presenter {
        void getData(String deviceid, String mobile);

        void getDataFresh(String deviceid, String mobile);
    }
}
