package com.xiaomai.ageny.details.shop_note_details.model;

import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.details.shop_note_details.contract.ShopNoteDetailsContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class ShopNoteDetailsModel implements ShopNoteDetailsContract.Model {
    @Override
    public Flowable<ShopBean> getData(String receiptId) {
        return RetrofitClient.getInstance().getApi().getShopDetails(receiptId);
    }
}
