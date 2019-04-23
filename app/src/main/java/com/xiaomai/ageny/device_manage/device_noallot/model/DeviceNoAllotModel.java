package com.xiaomai.ageny.device_manage.device_noallot.model;

import com.xiaomai.ageny.bean.NoAllotDeviceBean;
import com.xiaomai.ageny.device_manage.device_noallot.contract.DeviceNoAllotContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceNoAllotModel implements DeviceNoAllotContract.Model {
    @Override
    public Flowable<NoAllotDeviceBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().getNoAllotDeviceBean(deviceid);
    }
}
