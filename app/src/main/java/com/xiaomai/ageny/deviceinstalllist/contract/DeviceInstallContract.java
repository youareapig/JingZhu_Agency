package com.xiaomai.ageny.deviceinstalllist.contract;

import com.xiaomai.ageny.base.BaseView;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.LoginOutBean;

import io.reactivex.Flowable;

public interface DeviceInstallContract {
    interface Model {
        Flowable<DeviceInstallListBean> getDeviceInstallListData(String chiyou, String anzhuang, String time);

        Flowable<DeviceInstallListBean> getDeviceInstallListBean_Refresh(String chiyou, String anzhuang, String time);

        Flowable<LoginOutBean> loginOut();

        Flowable<ConfigBean> getConfigBean();
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

        void onSuccess(LoginOutBean bean);

        void onSuccess(ConfigBean bean);
    }

    interface Presenter {
        void getDeviceInstallListData(String chiyou, String anzhuang, String time);

        void getDeviceInstallListBean_Refresh(String chiyou, String anzhuang, String time);

        void loginOut();

        void getConfigBean();
    }
}
