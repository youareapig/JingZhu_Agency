package com.xiaomai.ageny.offline.fragment.direct.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.OffDeviceBean;

import io.reactivex.Flowable;

public interface DirectContract {
    interface Model {
        Flowable<OffDeviceBean> getData(String sellername, String linkmobile, String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(OffDeviceBean bean);
    }

    interface Presenter {
        void getData(String sellername, String linkmobile, String deviceid);
    }
}
