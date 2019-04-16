package com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.model;

import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.contract.FreezedContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class FreezedModel implements FreezedContract.Model {
    @Override
    public Flowable<FreezeBean> getData(String filler_state, String filler_deviceid, String filler_relation) {
        return RetrofitClient.getInstance().getApi().getFreezeListData(filler_state,filler_deviceid,filler_relation);
    }
}
