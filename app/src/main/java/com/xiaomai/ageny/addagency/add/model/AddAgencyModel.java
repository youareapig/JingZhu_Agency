package com.xiaomai.ageny.addagency.add.model;

import com.xiaomai.ageny.addagency.add.contract.AddAgencyContract;
import com.xiaomai.ageny.bean.AddAgencyBean;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class AddAgencyModel implements AddAgencyContract.Model {
    @Override
    public Flowable<AddAgencyBean> getData(RequestBody body) {
        return RetrofitClient.getInstance().getApi().AddAgency(body);
    }
}
