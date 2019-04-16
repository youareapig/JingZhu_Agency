package com.xiaomai.ageny.fragment.mine.model;

import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.fragment.mine.contract.MineContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class MineModel implements MineContract.Model {
    @Override
    public Flowable<UserInfoBean> getData() {
        return RetrofitClient.getInstance().getApi().getUserInfo();
    }
}
