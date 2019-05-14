package com.xiaomai.ageny.details.device_alloted_details.model;

import com.xiaomai.ageny.bean.DeviceAllotedDetailsBean;
import com.xiaomai.ageny.details.device_alloted_details.contract.DeviceAllotedDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceAllotedDetailsModel implements DeviceAllotedDetailsContract.Model {
    @Override
    public Flowable<DeviceAllotedDetailsBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().getAllotDeviceDetailsBean(deviceid);
    }
}
