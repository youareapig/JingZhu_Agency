package com.xiaomai.ageny.fragment.index.model;

import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.net.RetrofitClient;

import io.reactivex.Flowable;

public class IndexModel implements IndexContract.Model {
    @Override
    public Flowable<IndexBean> getData() {
        return RetrofitClient.getInstance().getApi().getIndexBean();
    }

}
