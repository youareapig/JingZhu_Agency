package com.xiaomai.ageny.device_manage.device_alloted;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<AllotDeviceBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<AllotDeviceBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AllotDeviceBean.DataBean.ListBean item) {
        helper.setText(R.id.deviceId, item.getDeviceId())
                .setText(R.id.name, "领取人：" + item.getLingquren() + "  " + item.getLingqurenmobile())
                .setText(R.id.time, "分配时间：" + DateUtils.timeStamp2Date(item.getDistTime().getTime() + ""));
    }
}