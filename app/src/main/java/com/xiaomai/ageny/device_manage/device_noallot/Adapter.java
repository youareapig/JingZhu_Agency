package com.xiaomai.ageny.device_manage.device_noallot;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.NoAllotDeviceBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<NoAllotDeviceBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<NoAllotDeviceBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NoAllotDeviceBean.DataBean item) {
        //获取当前时间戳
        Long dd = DateUtils.getCurrentTime_Today();
        Long tt = item.getUpdateTime().getTime();
        int kou = Integer.valueOf(item.getDeviceType());
        int tai = kou - 1;
        helper.setText(R.id.deviceId, item.getDeviceId())
                .setText(R.id.type, "类型：" + kou + "口" + tai + "台")
                .setText(R.id.time, "时间：" + DateUtils.timeStamp2Date(item.getCreateTime().getTime() + ""))
                .setText(R.id.stoptime, "已滞留" + DateUtils.timeStamp2DateHM((dd - tt) + ""));

    }
}