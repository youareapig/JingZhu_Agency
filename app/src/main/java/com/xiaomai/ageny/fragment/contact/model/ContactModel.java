package com.xiaomai.ageny.fragment.contact.model;

import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.fragment.contact.contract.ContactContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class ContactModel implements ContactContract.Model {
    @Override
    public Flowable<ContactListBean> getData(String mobile, String sellerId, String isbyearn) {
        return RetrofitClient.getInstance().getApi().getContactList(mobile, sellerId, isbyearn);
    }
}
