package com.xiaomai.ageny.details.device_alloted_details;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.DeviceAllotedDetailsBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<DeviceAllotedDetailsBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<DeviceAllotedDetailsBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceAllotedDetailsBean.DataBean.ListBean item) {
        helper.setText(R.id.name, item.getAgentName())
                .setText(R.id.agency, item.getAgentLevel() + "级代理")
                .setText(R.id.time, DateUtils.timeStamp2Date(item.getDistTime().getTime()+""));

    }
}
