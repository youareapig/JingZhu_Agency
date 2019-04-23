package com.xiaomai.ageny.device_popu.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.ShowHoleBean;

import io.reactivex.Flowable;

public interface DevicePopuContract {
    interface Model {
        Flowable<HintBean> popu(String deviceid, String slot);

        Flowable<ShowHoleBean> getData(String deviceid);


    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(HintBean bean);

        void onSuccess(ShowHoleBean bean);

    }

    interface Presenter {
        void popu(String deviceid, String slot);

        void getData(String deviceid);
    }
}
