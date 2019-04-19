package com.xiaomai.ageny.details.devicedetails.directdetails.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;

import io.reactivex.Flowable;

public interface DirectDetailsContract {
    interface Model {
        Flowable<ContactDeviceDetailsBean> getData(String deviceid);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ContactDeviceDetailsBean bean);
    }

    interface Presenter {
        void getData(String deviceid);
    }
}
