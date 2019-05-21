package com.xiaomai.ageny.power_manager.power_index.model;

import com.xiaomai.ageny.bean.PowerManagerBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_index.contract.PowerIndexContract;

import io.reactivex.Flowable;

public class PowerIndexModel implements PowerIndexContract.Model {
    @Override
    public Flowable<PowerManagerBean> getData() {
        return RetrofitClient.getInstance().getApi().PowerManagerData();
    }
}
