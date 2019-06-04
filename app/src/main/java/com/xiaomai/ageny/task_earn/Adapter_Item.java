package com.xiaomai.ageny.task_earn;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.DeviceEarnListBean;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;

import java.util.List;

public class Adapter_Item extends BaseQuickAdapter<DeviceEarnListBean.DataBean.ListBean.BoxBean, BaseViewHolder> {
    public Adapter_Item(int layoutResId, @Nullable List<DeviceEarnListBean.DataBean.ListBean.BoxBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceEarnListBean.DataBean.ListBean.BoxBean item) {
        helper.setText(R.id.deviceId, item.getBoxid())
                .setText(R.id.off_line_time, item.getLixiantime() + "h 未产单");
    }
}
