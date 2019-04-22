package com.xiaomai.ageny.addbank.model;

import com.xiaomai.ageny.addbank.contract.BankContract;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class BankModel implements BankContract.Model {
    @Override
    public Flowable<HintBean> addBank(RequestBody body) {
        return RetrofitClient.getInstance().getApi().addBank(body);
    }
}
