package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.model;

import com.xiaomai.ageny.bean.XiajiListBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.contract.XIajiSHDeviceListOffContract;

import io.reactivex.Flowable;

public class XIajiSHDeviceListOffModel implements XIajiSHDeviceListOffContract.Model {
    @Override
    public Flowable<XiajiListBean> getData(String id, String deviceid, String dentails, String state) {
        return RetrofitClient.getInstance().getApi().getXiajiListBean(id, deviceid, dentails, state);
    }
}
