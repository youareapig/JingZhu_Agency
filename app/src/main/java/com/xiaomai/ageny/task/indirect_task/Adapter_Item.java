package com.xiaomai.ageny.task.indirect_task;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;

import java.util.List;

public class Adapter_Item extends BaseQuickAdapter<OffIndirectDeivceBean.DataBean.ListBeanX.ListBean.BoxBean, BaseViewHolder> {
    public Adapter_Item(int layoutResId, @Nullable List<OffIndirectDeivceBean.DataBean.ListBeanX.ListBean.BoxBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffIndirectDeivceBean.DataBean.ListBeanX.ListBean.BoxBean item) {
        helper.setText(R.id.deviceId, item.getBoxid())
                .setText(R.id.off_line_time, "离线" + item.getLixiantime() + "h");
    }
}
