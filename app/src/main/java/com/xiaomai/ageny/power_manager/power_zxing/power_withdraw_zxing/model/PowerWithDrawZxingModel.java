package com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.model;

import com.xiaomai.ageny.bean.PowerWithDrawInfoBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.contract.PowerWithDrawZxingContract;

import io.reactivex.Flowable;

public class PowerWithDrawZxingModel implements PowerWithDrawZxingContract.Model {
    @Override
    public Flowable<PowerWithDrawInfoBean> getData(String id) {
        return RetrofitClient.getInstance().getApi().PowerWithDrawInfo(id);
    }
}
