package com.xiaomai.ageny.deposit_list.model;

import com.xiaomai.ageny.bean.DepositListBean;
import com.xiaomai.ageny.deposit_list.contract.DepositListContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class DepositListModel implements DepositListContract.Model {
    @Override
    public Flowable<DepositListBean> getData(String page, String page_size, String state, String orderid, String price_start, String price_end) {
        return RetrofitClient.getInstance().getApi().getDepositListBean(page, page_size, state, orderid, price_start, price_end);
    }

    @Override
    public Flowable<DepositListBean> getData_Fresh(String page, String page_size, String state, String orderid, String price_start, String price_end) {
        return RetrofitClient.getInstance().getApi().getDepositListBean(page, page_size, state, orderid, price_start, price_end);
    }
}
