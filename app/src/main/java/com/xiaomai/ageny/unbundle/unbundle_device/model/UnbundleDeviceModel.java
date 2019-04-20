package com.xiaomai.ageny.unbundle.unbundle_device.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.unbundle.unbundle_device.contract.UnbundleDeviceContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class UnbundleDeviceModel implements UnbundleDeviceContract.Model {
    @Override
    public Flowable<VerCodeBean> getCode(String mobile) {
        return RetrofitClient.getInstance().getApi().getVercode(mobile);
    }

    @Override
    public Flowable<HintBean> getDeviceDelete(RequestBody body) {
        return RetrofitClient.getInstance().getApi().deviceDelete(body);
    }
}
