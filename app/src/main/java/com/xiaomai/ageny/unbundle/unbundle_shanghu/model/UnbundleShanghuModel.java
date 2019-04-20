package com.xiaomai.ageny.unbundle.unbundle_shanghu.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.contract.UnbundleShanghuContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class UnbundleShanghuModel implements UnbundleShanghuContract.Model {
    @Override
    public Flowable<VerCodeBean> getCode(String mobile) {
        return RetrofitClient.getInstance().getApi().getVercode(mobile);
    }

    @Override
    public Flowable<HintBean> unbundleContanctBean(RequestBody body) {
        return RetrofitClient.getInstance().getApi().getUnbundleContanctBean(body);
    }
}
