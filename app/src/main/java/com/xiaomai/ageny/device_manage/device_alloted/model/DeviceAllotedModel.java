package com.xiaomai.ageny.device_manage.device_alloted.model;

import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.DeviceManageBean;
import com.xiaomai.ageny.device_manage.device_alloted.contract.DeviceAllotedContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceAllotedModel implements DeviceAllotedContract.Model {
    @Override
    public Flowable<AllotDeviceBean> getData(String deviceid, String mobile,String page,String pagesize,String msgid) {
        return RetrofitClient.getInstance().getApi().getAllotDeviceBean(deviceid, mobile,page,pagesize,msgid);
    }

    @Override
    public Flowable<DeviceManageBean> getCount() {
        return RetrofitClient.getInstance().getApi().getDeviceManageBean();
    }
}
