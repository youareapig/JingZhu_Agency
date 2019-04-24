package com.xiaomai.ageny.device_manage.device_noallot.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.NoAllotDeviceBean;

import io.reactivex.Flowable;

public interface DeviceNoAllotContract {
    interface Model {
        Flowable<NoAllotDeviceBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(NoAllotDeviceBean bean);

        void onSuccessFresh(NoAllotDeviceBean bean);
    }

    interface Presenter {
        void getData(String deviceid);

        void getDataFresh(String deviceid);
    }
}
