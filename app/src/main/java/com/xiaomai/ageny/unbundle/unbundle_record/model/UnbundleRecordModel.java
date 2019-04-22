package com.xiaomai.ageny.unbundle.unbundle_record.model;

import com.xiaomai.ageny.bean.UnbindRecordBean;
import com.xiaomai.ageny.net.RetrofitClient;
import com.xiaomai.ageny.unbundle.unbundle_record.contract.UnbundleRecordContract;

import io.reactivex.Flowable;

public class UnbundleRecordModel implements UnbundleRecordContract.Model {
    @Override
    public Flowable<UnbindRecordBean> getData(String page, String page_size, String linkman, String linkmobile) {
        return RetrofitClient.getInstance().getApi().getUnbindRecordBean(page, page_size, linkman, linkmobile);
    }
}
