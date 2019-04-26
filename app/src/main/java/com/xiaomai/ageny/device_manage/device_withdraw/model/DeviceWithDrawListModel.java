package com.xiaomai.ageny.device_manage.device_withdraw.model;

import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.device_manage.device_withdraw.contract.DeviceWithDrawListContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceWithDrawListModel implements DeviceWithDrawListContract.Model {


    @Override
    public Flowable<HintBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().withDrawDeviceBean(deviceid);
    }
}
