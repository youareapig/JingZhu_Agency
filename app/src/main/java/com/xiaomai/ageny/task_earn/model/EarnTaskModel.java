package com.xiaomai.ageny.task_earn.model;

import com.xiaomai.ageny.bean.DeviceEarnListBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.task_earn.contract.EarnTaskContract;

import io.reactivex.Flowable;

public class EarnTaskModel implements EarnTaskContract.Model {
    @Override
    public Flowable<DeviceEarnListBean> getData(String page, String pagesize) {
        return RetrofitClient.getInstance().getApi().DeviceEarnBean(page, pagesize);
    }
}
