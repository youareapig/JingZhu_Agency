package com.xiaomai.ageny.power_manager.power_mine.model;

import com.xiaomai.ageny.bean.MyPowerListBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.power_manager.power_mine.contract.MyPowerContract;

import io.reactivex.Flowable;

public class MyPowerModel implements MyPowerContract.Model {
    @Override
    public Flowable<MyPowerListBean> getData(String id) {
        return RetrofitClient.getInstance().getApi().MyPowerListData(id);
    }
}
