package com.xiaomai.ageny.mybill.model;

import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.mybill.contract.MyBillContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class MyBillModel implements MyBillContract.Model {
    @Override
    public Flowable<BillListBean> getData() {
        return RetrofitClient.getInstance().getApi().getBillList();
    }
}
