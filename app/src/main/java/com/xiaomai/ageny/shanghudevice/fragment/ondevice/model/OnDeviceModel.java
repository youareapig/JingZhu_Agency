package com.xiaomai.ageny.shanghudevice.fragment.ondevice.model;

import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.contract.OnDeviceContract;

import io.reactivex.Flowable;

public class OnDeviceModel implements OnDeviceContract.Model {
    @Override
    public Flowable<ContactDeviceListBean> getData(String sellerid, String state, String deviceid, String device_type) {
        return RetrofitClient.getInstance().getApi().getContactDeviceListBean(sellerid, state, deviceid, device_type);
    }
}
