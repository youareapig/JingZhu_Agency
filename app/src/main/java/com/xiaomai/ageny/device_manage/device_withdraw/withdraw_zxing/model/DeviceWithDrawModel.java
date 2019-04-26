package com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.model;

import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.contract.DeviceWithDrawContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceWithDrawModel implements DeviceWithDrawContract.Model {
    @Override
    public Flowable<DeviceWithDrawListBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().withDrawDeviceListBean(deviceid);
    }
}
