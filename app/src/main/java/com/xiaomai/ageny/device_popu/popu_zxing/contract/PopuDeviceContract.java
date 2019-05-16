package com.xiaomai.ageny.device_popu.popu_zxing.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.PopDeviceBean;
import com.xiaomai.ageny.bean.ShowHoleBean;

import io.reactivex.Flowable;

public interface PopuDeviceContract {
    interface Model {
        Flowable<ShowHoleBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ShowHoleBean bean);
    }

    interface Presenter {
        void getData(String deviceid);
    }
}
