package com.xiaomai.ageny.offline.fragment.indirect.model;

import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.offline.fragment.indirect.contract.IndirectContract;

import io.reactivex.Flowable;

public class IndirectModel implements IndirectContract.Model {
    @Override
    public Flowable<OffIndirectDeivceBean> getData(String agentname, String agentmobile, String deviceid) {
        return RetrofitClient.getInstance().getApi().getInDirectListBean(agentname, agentmobile, deviceid);
    }
}
