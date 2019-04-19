package com.xiaomai.ageny.details.devicedetails.indirectdetails.model;

import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.contract.IndirectDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class IndirectDetailsModel implements IndirectDetailsContract.Model {
    @Override
    public Flowable<OffIndirectDeivceDetailsBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().getInDirectDetailsBean(deviceid);
    }
}
