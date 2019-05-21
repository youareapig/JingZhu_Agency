package com.xiaomai.ageny.power_manager.power_alloted;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.PowerAllotedBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<PowerAllotedBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<PowerAllotedBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PowerAllotedBean.DataBean item) {
        helper.setText(R.id.deviceId, item.getDeviceId())
                .setText(R.id.name, "领取人：" + item.getLingquren() + "  " + item.getLingqurenMobile())
                .setText(R.id.time, "分配时间：" + item.getAssaginTime());
    }
}