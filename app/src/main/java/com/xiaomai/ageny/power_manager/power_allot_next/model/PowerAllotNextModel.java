package com.xiaomai.ageny.power_manager.power_allot_next.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_allot_next.contract.PowerAllotNextContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class PowerAllotNextModel implements PowerAllotNextContract.Model {
    @Override
    public Flowable<TelBean> sureTel(String tel) {
        return RetrofitClient.getInstance().getApi().sureTel(tel);
    }

    @Override
    public Flowable<HintBean> getData(RequestBody body) {
        return RetrofitClient.getInstance().getApi().PowerSubmitData(body);
    }
}
