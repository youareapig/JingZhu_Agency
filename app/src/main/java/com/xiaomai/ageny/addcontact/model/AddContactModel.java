package com.xiaomai.ageny.addcontact.model;

import com.xiaomai.ageny.addcontact.contract.AddContactContract;
import com.xiaomai.ageny.bean.ContactUpdateUserInfoBean;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class AddContactModel implements AddContactContract.Model {
    @Override
    public Flowable<ContactUpdateUserInfoBean> getData(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().contactUpdateUserInfo(requestBody);
    }

    @Override
    public Flowable<ContactUpdateUserInfoBean> AddContanct(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().addContanct(requestBody);
    }
}
