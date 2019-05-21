package com.xiaomai.ageny.power_manager.power_allot;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.daobean.DeviceDao;

import java.util.List;

public class Adapter extends BaseQuickAdapter<DeviceDao, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<DeviceDao> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceDao item) {
        helper.setText(R.id.powerid, item.getDeviceId());
        helper.addOnClickListener(R.id.delete);
    }
}