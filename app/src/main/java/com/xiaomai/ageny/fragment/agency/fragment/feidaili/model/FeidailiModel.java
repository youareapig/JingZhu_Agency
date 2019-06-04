package com.xiaomai.ageny.fragment.agency.fragment.feidaili.model;

import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.contract.FeidailiContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class FeidailiModel implements FeidailiContract.Model {
    @Override
    public Flowable<DailiListBean> getData(String mobile, String deviceid, String grade, String directly, String isbytime,String page,String pagesize) {
        return RetrofitClient.getInstance().getApi().getDailiListBean(mobile, deviceid, grade, directly, isbytime,page,pagesize);
    }
}
