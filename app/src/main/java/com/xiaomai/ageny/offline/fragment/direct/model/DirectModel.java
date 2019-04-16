package com.xiaomai.ageny.offline.fragment.direct.model;

import com.xiaomai.ageny.bean.OffDeviceBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.offline.fragment.direct.contract.DirectContract;

import io.reactivex.Flowable;

public class DirectModel implements DirectContract.Model {
    @Override
    public Flowable<OffDeviceBean> getData(String sellername, String linkmobile, String deviceid) {
        return RetrofitClient.getInstance().getApi().getDirectListBean(sellername,linkmobile,deviceid);
    }
}
