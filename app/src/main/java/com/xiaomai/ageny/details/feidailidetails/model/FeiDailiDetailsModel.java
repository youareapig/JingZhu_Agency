package com.xiaomai.ageny.details.feidailidetails.model;

import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.details.feidailidetails.contract.FeiDailiDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class FeiDailiDetailsModel implements FeiDailiDetailsContract.Model {
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
