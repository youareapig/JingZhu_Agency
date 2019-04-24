package com.xiaomai.ageny.offline.fragment.direct.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;

import io.reactivex.Flowable;

public interface DirectContract {
    interface Model {
        Flowable<OffDirectDeviceBean> getData(String sellername, String linkmobile, String deviceid, String state);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OffDirectDeviceBean bean);

        void onSuccessFresh(OffDirectDeviceBean bean);
    }

    interface Presenter {
        void getData(String sellername, String linkmobile, String deviceid, String state);

        void getDataFresh(String sellername, String linkmobile, String deviceid, String state);
    }
}
