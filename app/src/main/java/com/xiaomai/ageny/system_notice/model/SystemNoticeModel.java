package com.xiaomai.ageny.system_notice.model;

import com.xiaomai.ageny.bean.SystemNoticeBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.system_notice.contract.SystemNoticeContract;

import io.reactivex.Flowable;

public class SystemNoticeModel implements SystemNoticeContract.Model {
    @Override
    public Flowable<SystemNoticeBean> getData(String page, String pagesize) {
        return RetrofitClient.getInstance().getApi().getSystemData(page, pagesize);
    }
}
