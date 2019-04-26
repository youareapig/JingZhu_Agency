package com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.model;

import com.xiaomai.ageny.bean.DeviceAllotListBean;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.contract.DeviceAllotZxingContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceAllotZxingModel implements DeviceAllotZxingContract.Model {
    @Override
    public Flowable<DeviceAllotListBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().allotDeviceListBean(deviceid);
    }
}
