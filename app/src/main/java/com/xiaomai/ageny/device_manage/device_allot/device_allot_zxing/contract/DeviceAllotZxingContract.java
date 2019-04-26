package com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceAllotListBean;

import io.reactivex.Flowable;

public interface DeviceAllotZxingContract {
    interface Model {
        Flowable<DeviceAllotListBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DeviceAllotListBean bean);
    }

    interface Presenter {
        void getData(String deviceid);
    }
}
