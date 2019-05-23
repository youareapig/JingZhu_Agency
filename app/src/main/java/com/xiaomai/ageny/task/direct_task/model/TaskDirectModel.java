package com.xiaomai.ageny.task.direct_task.model;

import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.task.direct_task.contract.TaskDirectContract;

import io.reactivex.Flowable;

public class TaskDirectModel implements TaskDirectContract.Model {
    @Override
    public Flowable<OffDirectDeviceBean> getData(String sellername, String linkmobile, String deviceid, String state) {
        return RetrofitClient.getInstance().getApi().getDirectListBean(sellername,linkmobile,deviceid,state,"");
    }
}
