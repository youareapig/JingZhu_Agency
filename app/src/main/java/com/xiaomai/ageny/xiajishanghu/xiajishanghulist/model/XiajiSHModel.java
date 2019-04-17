package com.xiaomai.ageny.xiajishanghu.xiajishanghulist.model;

import com.xiaomai.ageny.bean.AgencySellerListBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.contract.XiajiSHContract;

import io.reactivex.Flowable;

public class XiajiSHModel implements XiajiSHContract.Model {
    @Override
    public Flowable<AgencySellerListBean> getData(String id) {
        return RetrofitClient.getInstance().getApi().getAgencySellerListBean(id);
    }
}
