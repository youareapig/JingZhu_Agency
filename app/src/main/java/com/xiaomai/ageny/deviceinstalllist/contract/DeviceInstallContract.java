package com.xiaomai.ageny.deviceinstalllist.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.IndexBean;

import io.reactivex.Flowable;

public interface DeviceInstallContract {
    interface Model {
        Flowable<DeviceInstallListBean> getDeviceInstallListData(String chiyou,String anzhuang,String time);
        Flowable<DeviceInstallListBean> getDeviceInstallListBean_Refresh(int page,String chiyou,String anzhuang,String time);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(DeviceInstallListBean bean);
        void onSuccess_Refresh(DeviceInstallListBean bean);
    }

    interface Presenter {
        void getDeviceInstallListData(String chiyou,String anzhuang,String time);
        void getDeviceInstallListBean_Refresh(int page,String chiyou,String anzhuang,String time);
    }
}
