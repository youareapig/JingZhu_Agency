package com.xiaomai.ageny.login.model;

import com.xiaomai.ageny.bean.LoginBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.login.contract.LoginContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class LoginModel implements LoginContract.Model {
    @Override
    public Flowable<LoginBean> login(RequestBody body) {
        return RetrofitClient.getInstance().getApi().loginBean(body);
    }

    @Override
    public Flowable<VerCodeBean> getCode(String mobile) {
        return RetrofitClient.getInstance().getApi().getVercode(mobile);
    }
}
