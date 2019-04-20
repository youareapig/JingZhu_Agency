package com.xiaomai.ageny.deploy.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelToNameBean;
import com.xiaomai.ageny.deploy.contract.DeployContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class DeployModel implements DeployContract.Model {

    @Override
    public Flowable<TelToNameBean> getData(String mobile) {
        return RetrofitClient.getInstance().getApi().getTelName(mobile);
    }

    @Override
    public Flowable<HintBean> getDeploy(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().deployDevice(requestBody);
    }
}
