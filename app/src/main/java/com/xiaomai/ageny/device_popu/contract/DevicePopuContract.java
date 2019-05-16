package com.xiaomai.ageny.device_popu.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.PopDeviceBean;
import com.xiaomai.ageny.bean.ShowHoleBean;

import io.reactivex.Flowable;

public interface DevicePopuContract {
    interface Model {
        Flowable<PopDeviceBean> popu(String deviceid, String slot);

    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(PopDeviceBean bean);


    }

    interface Presenter {
        void popu(String deviceid, String slot);

    }
}
