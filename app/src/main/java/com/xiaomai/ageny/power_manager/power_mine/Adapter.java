package com.xiaomai.ageny.power_manager.power_mine;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.bean.MyPowerListBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<MyPowerListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<MyPowerListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPowerListBean.DataBean.ListBean item) {
        helper.setText(R.id.powerid, item.getTerminalId())
                .setText(R.id.time, "时间：" + DateUtils.timeStamp2Date(item.getAssginTime().getTime() + ""));
    }
}