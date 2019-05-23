package com.xiaomai.ageny.power_manager.power_alloted.model;

import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_alloted.contract.PowerAllotedContract;

import io.reactivex.Flowable;

public class PowerAllotedModel implements PowerAllotedContract.Model {
    @Override
    public Flowable<PowerAllotedBean> getData(String id, String startTime, String endTime,String page,String pagesize) {
        return RetrofitClient.getInstance().getApi().PowerAllotedData(id, startTime, endTime,page,pagesize);
    }
}
