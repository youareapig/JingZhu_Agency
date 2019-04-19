package com.xiaomai.ageny.deposit.model;

import com.xiaomai.ageny.bean.DepositBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.deposit.contract.DepositContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class DepositModel implements DepositContract.Model {
    @Override
    public Flowable<IndexBean> getData() {
        return RetrofitClient.getInstance().getApi().getIndexBean();
    }

    @Override
    public Flowable<DepositBean> getDepositBean(RequestBody requestBody) {
        return RetrofitClient.getInstance().getApi().dePosit(requestBody);
    }


}
