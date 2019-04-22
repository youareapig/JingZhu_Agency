package com.xiaomai.ageny.shop_manage.fragment.record.model;

import com.xiaomai.ageny.bean.ShopApplyBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.shop_manage.fragment.record.contract.RecordContract;

import io.reactivex.Flowable;

public class RecordModel implements RecordContract.Model {
    @Override
    public Flowable<ShopApplyBean> getData(String bath, String state, String page, String page_size) {
        return RetrofitClient.getInstance().getApi().getShopApplyBean(bath, state, page, page_size);
    }
}
