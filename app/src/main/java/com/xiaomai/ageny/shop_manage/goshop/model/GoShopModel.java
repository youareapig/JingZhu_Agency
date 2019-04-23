package com.xiaomai.ageny.shop_manage.goshop.model;

import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.shop_manage.goshop.contract.GoShopContract;

import io.reactivex.Flowable;
import okhttp3.RequestBody;

public class GoShopModel implements GoShopContract.Model {
    @Override
    public Flowable<HintBean> getData(RequestBody body) {
        return RetrofitClient.getInstance().getApi().goShop(body);
    }
}
