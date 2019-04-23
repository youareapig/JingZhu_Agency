package com.xiaomai.ageny.device_manage.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceManageBean;

import io.reactivex.Flowable;

public interface DeviceManageContract {
    interface Model {
        Flowable<DeviceManageBean> getData();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DeviceManageBean bean);
    }

    interface Presenter {
        void getData();
    }
}
