package com.xiaomai.ageny.power_manager.power_withdraw.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_withdraw.contract.PowerWithdrawContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class PowerWithdrawModel implements PowerWithdrawContract.Model {
    @Override
    public Flowable<HintBean> getData(RequestBody body) {
        return RetrofitClient.getInstance().getApi().PowerWithDrawSubmitData(body);
    }
}
