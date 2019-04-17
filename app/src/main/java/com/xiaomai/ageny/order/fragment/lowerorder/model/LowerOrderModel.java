package com.xiaomai.ageny.order.fragment.lowerorder.model;

import com.xiaomai.ageny.bean.LowerOrderBean;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.order.fragment.lowerorder.contract.LowerOrderContract;

import io.reactivex.Flowable;

public class LowerOrderModel implements LowerOrderContract.Model {
    @Override
    public Flowable<LowerOrderBean> getData(String orderid, String sellername, String startTime, String endTime) {
        return RetrofitClient.getInstance().getApi().getLowerOrderListBean(orderid, sellername, startTime, endTime);
    }
}
