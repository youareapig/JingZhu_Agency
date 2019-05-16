package com.xiaomai.ageny.device_popu.popu_zxing.model;

import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_popu.popu_zxing.contract.PopuDeviceContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class PopuDeviceModel implements PopuDeviceContract.Model {
    @Override
    public Flowable<ShowHoleBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().showHole(deviceid);
    }
}
