package com.xiaomai.ageny.fragment.index.model;

import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.UpdateBean;
import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class IndexModel implements IndexContract.Model {
    @Override
    public Flowable<IndexBean> getData() {
        return RetrofitClient.getInstance().getApi().getIndexBean();
    }

    @Override
    public Flowable<ConfigBean> getConfigBean() {
        return RetrofitClient.getInstance().getApi().getConfig();
    }

    @Override
    public Flowable<UpdateBean> getUpdate(String type) {
        return RetrofitClient.getInstance().getApi().getUpdate(type);
    }

    @Override
    public Flowable<UserInfoBean> getAlias() {
        return RetrofitClient.getInstance().getApi().getUserInfo();
    }

}
