package com.xiaomai.ageny.details.power_alloted_details.model;

import com.xiaomai.ageny.bean.PowerDetailsBean;
import com.xiaomai.ageny.details.power_alloted_details.contract.PowerAllotedDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class PowerAllotedDetailsModel implements PowerAllotedDetailsContract.Model {
    @Override
    public Flowable<PowerDetailsBean> getData(String id) {
        return RetrofitClient.getInstance().getApi().PowerDetailsData(id);
    }
}
