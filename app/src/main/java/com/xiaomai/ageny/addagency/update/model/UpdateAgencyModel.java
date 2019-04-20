package com.xiaomai.ageny.addagency.update.model;

import com.xiaomai.ageny.addagency.update.contract.UpdateAgencyContract;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class UpdateAgencyModel implements UpdateAgencyContract.Model {
    @Override
    public Flowable<HintBean> getData(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().AgencyUpdate(requestBody);
    }
}
