package com.xiaomai.ageny.deviceinstalllist.model;

import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.deviceinstalllist.contract.DeviceInstallContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceInstallModel implements DeviceInstallContract.Model {


    @Override
    public Flowable<DeviceInstallListBean> getDeviceInstallListData(String chiyou, String anzhuang, String time) {
        return  RetrofitClient.getInstance().getApi().getDeviceInstallListBean(chiyou,anzhuang,time);
    }

    @Override
    public Flowable<DeviceInstallListBean> getDeviceInstallListBean_Refresh( String chiyou, String anzhuang, String time) {
        return  RetrofitClient.getInstance().getApi().getDeviceInstallListBean(chiyou,anzhuang,time);
    }

    @Override
    public Flowable<LoginOutBean> loginOut() {
        return RetrofitClient.getInstance().getApi().loginOutBean();
    }
}
