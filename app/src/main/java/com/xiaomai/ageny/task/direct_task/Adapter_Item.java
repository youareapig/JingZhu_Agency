package com.xiaomai.ageny.task.direct_task;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;

import java.util.List;

public class Adapter_Item extends BaseQuickAdapter<OffDirectDeviceBean.DataBean.ListBeanX.ListBean.BoxBean, BaseViewHolder> {
    public Adapter_Item(int layoutResId, @Nullable List<OffDirectDeviceBean.DataBean.ListBeanX.ListBean.BoxBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffDirectDeviceBean.DataBean.ListBeanX.ListBean.BoxBean item) {
        helper.setText(R.id.deviceId, item.getBoxid())
                .setText(R.id.off_line_time, "离线" + item.getLixiantime() + "h");
    }
}
