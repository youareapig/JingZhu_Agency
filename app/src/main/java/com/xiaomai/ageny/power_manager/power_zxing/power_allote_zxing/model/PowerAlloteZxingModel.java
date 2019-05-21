package com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.model;

import com.xiaomai.ageny.bean.PowerInfoBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.contract.PowerAlloteZxingContract;

import io.reactivex.Flowable;

public class PowerAlloteZxingModel implements PowerAlloteZxingContract.Model {
    @Override
    public Flowable<PowerInfoBean> getData(String powerid) {
        return RetrofitClient.getInstance().getApi().PowerInfo(powerid);
    }
}
