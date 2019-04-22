package com.xiaomai.ageny.shop_manage.fragment.shopnote.model;

import com.xiaomai.ageny.bean.ShopRecordBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.contract.ShopNoteContract;

import io.reactivex.Flowable;

public class ShopNoteModel implements ShopNoteContract.Model {
    @Override
    public Flowable<ShopRecordBean> getData(String bath, String mobile, String page, String page_size) {
        return RetrofitClient.getInstance().getApi().getShopRecordListBean(bath, mobile, page, page_size);
    }
}
