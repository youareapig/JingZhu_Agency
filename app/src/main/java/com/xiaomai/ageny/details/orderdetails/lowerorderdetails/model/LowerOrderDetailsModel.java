package com.xiaomai.ageny.details.orderdetails.lowerorderdetails.model;

import com.xiaomai.ageny.bean.LowerOrderDetailsBean;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.contract.LowerOrderDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class LowerOrderDetailsModel implements LowerOrderDetailsContract.Model {
    @Override
    public Flowable<LowerOrderDetailsBean> getData(String orderid) {
        return RetrofitClient.getInstance().getApi().getLowerOrderDetailsBean(orderid);
    }
}
