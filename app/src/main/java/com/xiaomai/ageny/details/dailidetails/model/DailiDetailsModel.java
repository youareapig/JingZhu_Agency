package com.xiaomai.ageny.details.dailidetails.model;

import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.details.dailidetails.contract.DailiDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DailiDetailsModel implements DailiDetailsContract.Model {
    @Override
    public Flowable<AgencyDetailsBean> getData(String agentid) {
        return RetrofitClient.getInstance().getApi().getAgencyDetials(agentid);
    }

    @Override
    public Flowable<HisSellerBean> getHisSeller(String agentid) {
        return RetrofitClient.getInstance().getApi().getHisSellerBean(agentid);
    }

    @Override
    public Flowable<AgencyUserInfoBean> getAgencyUserInfo(String agentid) {
        return RetrofitClient.getInstance().getApi().getAgencyUserInfo(agentid);
    }
}
