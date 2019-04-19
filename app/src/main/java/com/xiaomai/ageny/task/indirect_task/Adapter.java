package com.xiaomai.ageny.task.indirect_task;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<OffDirectDeviceBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<OffDirectDeviceBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffDirectDeviceBean.DataBean.ListBean item) {
        helper.setText(R.id.item_storename, item.getSellername());
        //item task_indirct_item_item
    }
}
