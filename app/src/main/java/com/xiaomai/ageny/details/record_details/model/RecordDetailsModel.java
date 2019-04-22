package com.xiaomai.ageny.details.record_details.model;

import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.details.record_details.contract.RecordDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class RecordDetailsModel implements RecordDetailsContract.Model {
    @Override
    public Flowable<ShopBean> getData(String receiptId) {
        return RetrofitClient.getInstance().getApi().getShopDetails(receiptId);
    }
}
