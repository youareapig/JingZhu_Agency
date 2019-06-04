package com.xiaomai.ageny.fragment.agency.fragment.daili.model;

import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.fragment.agency.fragment.daili.contract.DailiContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DailiModel implements DailiContract.Model {
    @Override
    public Flowable<DailiListBean> getData(String mobile, String deviceid, String grade, String directly, String isbytime,String page,String pagesize) {
        return RetrofitClient.getInstance().getApi().getDailiListBean(mobile, deviceid, grade, directly, isbytime,page,pagesize);
    }
}
