package com.xiaomai.ageny.details.devicedetails.directdetails.model;

import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.contract.DirectDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DirectDetailsModel implements DirectDetailsContract.Model {
    @Override
    public Flowable<ContactDeviceDetailsBean> getData(String deviceid,String msgid) {
        return RetrofitClient.getInstance().getApi().getContactDeviceDetailsBean(deviceid,msgid);
    }
}
