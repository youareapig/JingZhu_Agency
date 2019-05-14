package com.xiaomai.ageny.details.shanghudevicedetails.model;

import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.details.shanghudevicedetails.contract.ShangHuDeviceDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class ShangHuDeviceDetailsModel implements ShangHuDeviceDetailsContract.Model {
    @Override
    public Flowable<ContactDeviceDetailsBean> getData(String id,String msgid) {
        return RetrofitClient.getInstance().getApi().getContactDeviceDetailsBean(id,msgid);
    }

    @Override
    public Flowable<HintBean> updatePrice(String id, String price) {
        return RetrofitClient.getInstance().getApi().updatePrice(id, price);
    }
}
