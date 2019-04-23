package com.xiaomai.ageny.details.devcie_freeze_details.model;

import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.FreezeDetailsBean;
import com.xiaomai.ageny.details.devcie_freeze_details.contract.DeviceFreezeDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DeviceFreezeDetailsModel implements DeviceFreezeDetailsContract.Model {
    @Override
    public Flowable<FreezeDetailsBean> getData(String deviceid) {
        return RetrofitClient.getInstance().getApi().getFreezeDetailsBean(deviceid);
    }

    @Override
    public Flowable<FreezeBean> getData(String filler_state, String deviceid, String filler_relation) {
        return RetrofitClient.getInstance().getApi().getFreezeListData(filler_state, deviceid, filler_relation);
    }
}
