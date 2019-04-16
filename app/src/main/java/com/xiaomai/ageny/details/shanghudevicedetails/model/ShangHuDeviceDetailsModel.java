package com.xiaomai.ageny.details.shanghudevicedetails.model;

import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.details.shanghudevicedetails.contract.ShangHuDeviceDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class ShangHuDeviceDetailsModel implements ShangHuDeviceDetailsContract.Model {
    @Override
    public Flowable<ContactDeviceDetailsBean> getData(String id) {
        return RetrofitClient.getInstance().getApi().getContactDeviceDetailsBean(id);
    }
}
