package com.xiaomai.ageny.order.fragment.myorder.model;

import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.order.fragment.myorder.contract.MyOrderContract;

import io.reactivex.Flowable;

public class MyOrderModel implements MyOrderContract.Model {
    @Override
    public Flowable<MyOrderBean> getData(String orderid, String sellername, String startTime, String endTime) {
        return RetrofitClient.getInstance().getApi().getMyOrderListBean(orderid,sellername,startTime,endTime);
    }
}
