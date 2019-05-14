package com.xiaomai.ageny.details.device_alloted_details.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceAllotedDetailsBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;

import io.reactivex.Flowable;

public interface DeviceAllotedDetailsContract {
    interface Model {
        Flowable<DeviceAllotedDetailsBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DeviceAllotedDetailsBean bean);
    }

    interface Presenter {
        void getData(String deviceid);
    }
}
