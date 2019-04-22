package com.xiaomai.ageny.mybankcard.model;

import com.xiaomai.ageny.bean.MyBankBean;
import com.xiaomai.ageny.mybankcard.contract.MyBankCardContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class MyBankCardModel implements MyBankCardContract.Model {
    @Override
    public Flowable<MyBankBean> getData() {
        return RetrofitClient.getInstance().getApi().getMyBankBean();
    }
}
