package com.xiaomai.ageny.addcontact.model;

import com.xiaomai.ageny.addcontact.contract.AddContactContract;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class AddContactModel implements AddContactContract.Model {
    @Override
    public Flowable<HintBean> getData(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().contactUpdateUserInfo(requestBody);
    }

    @Override
    public Flowable<HintBean> AddContanct(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().addContanct(requestBody);
    }
}
