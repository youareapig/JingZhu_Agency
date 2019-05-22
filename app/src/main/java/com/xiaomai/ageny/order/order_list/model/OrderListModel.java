package com.xiaomai.ageny.order.order_list.model;

import com.xiaomai.ageny.bean.OrderListBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.order.order_list.contract.OrderListContract;

import io.reactivex.Flowable;

public class OrderListModel implements OrderListContract.Model {
    @Override
    public Flowable<OrderListBean> getData(String agentid, String page, String pagesize,String orderid,String sellername,String startTime,String endTime,String state) {
        return RetrofitClient.getInstance().getApi().orderList(agentid, page, pagesize, orderid, sellername, startTime, endTime,state);
    }
}
