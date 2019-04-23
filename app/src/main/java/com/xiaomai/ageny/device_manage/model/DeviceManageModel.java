package com.xiaomai.ageny.device_manage.model;

import com.xiaomai.ageny.bean.DeviceManageBean;
import com.xiaomai.ageny.device_manage.contract.DeviceManageContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceManageModel implements DeviceManageContract.Model {
    @Override
    public Flowable<DeviceManageBean> getData() {
        return RetrofitClient.getInstance().getApi().getDeviceManageBean();
    }
}
