package com.xiaomai.ageny.details.orderdetails.myorderdetails.model;

import com.xiaomai.ageny.bean.MyOrderDetailsBean;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.contract.MyOrderDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class MyOrderDetailsModel implements MyOrderDetailsContract.Model {
    @Override
    public Flowable<MyOrderDetailsBean> getData(String orderid) {
        return RetrofitClient.getInstance().getApi().getMyOrderDetailsBean(orderid);
    }
}
