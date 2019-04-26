package com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceWithDrawListBean;

import io.reactivex.Flowable;

public interface DeviceWithDrawContract {
    interface Model {
        Flowable<DeviceWithDrawListBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DeviceWithDrawListBean bean);

    }

    interface Presenter {
        void getData(String deviceid);
    }
}
