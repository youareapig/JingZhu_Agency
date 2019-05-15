package com.xiaomai.ageny.device_popu.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.PopDeviceBean;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_popu.contract.DevicePopuContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DevicePopuModel implements DevicePopuContract.Model {
    @Override
    public Flowable<PopDeviceBean> popu(String deviceid, String slot) {
        return RetrofitClient.getInstance().getApi().popDevice(deviceid, slot);
    }

    @Override
    public Flowable<ShowHoleBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().showHole(deviceid);
    }
}
