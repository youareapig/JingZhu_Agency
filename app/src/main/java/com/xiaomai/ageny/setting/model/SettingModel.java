package com.xiaomai.ageny.setting.model;

import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.setting.contract.SettingContract;

import io.reactivex.Flowable;

public class SettingModel implements SettingContract.Model {
    @Override
    public Flowable<LoginOutBean> loginOut() {
        return RetrofitClient.getInstance().getApi().loginOutBean();
    }
}
