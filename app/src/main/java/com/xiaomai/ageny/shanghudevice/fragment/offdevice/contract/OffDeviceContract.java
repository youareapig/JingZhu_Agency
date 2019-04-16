package com.xiaomai.ageny.shanghudevice.fragment.offdevice.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ContactDeviceListBean;

import io.reactivex.Flowable;

public interface OffDeviceContract {
    interface Model {
        Flowable<ContactDeviceListBean> getData(String sellerid, String state, String deviceid, String device_type);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(ContactDeviceListBean bean);
    }

    interface Presenter {
        void getData(String sellerid,String state,String deviceid,String device_type);
    }
}
