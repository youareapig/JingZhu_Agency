package com.xiaomai.ageny.details.contactdetails.model;

import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;
import com.xiaomai.ageny.details.contactdetails.contract.ContactDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class ContactDetailsModel implements ContactDetailsContract.Model {
    @Override
    public Flowable<ContactDetailsBean> getData(String id) {
        return RetrofitClient.getInstance().getApi().getContactDetailsBean(id);
    }

    @Override
    public Flowable<ContactUserInfoBean> getUserInfo(String id, String tel) {
        return RetrofitClient.getInstance().getApi().getContactUserInfoBean(id, tel);
    }
}
