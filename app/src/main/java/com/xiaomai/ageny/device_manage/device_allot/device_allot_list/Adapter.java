package com.xiaomai.ageny.device_manage.device_allot.device_allot_list;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.AllotSecondBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;

import java.util.List;

public class Adapter extends BaseQuickAdapter<DeviceDao, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<DeviceDao> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceDao item) {
        helper.setText(R.id.deviceId, item.getDeviceId())
                .setText(R.id.type, "类型：" + item.getType())
                .setText(R.id.time, "时间：" + item.getTime())
                .setText(R.id.stoptime, "已滞留" + item.getStopTime());
        helper.addOnClickListener(R.id.delete);
    }
}