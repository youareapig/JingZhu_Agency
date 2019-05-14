package com.xiaomai.ageny.deviceinstalllist.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.utils.BaseUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<DeviceInstallListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<DeviceInstallListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DeviceInstallListBean.DataBean.ListBean item) {
        helper.setText(R.id.deviceId, "设备编号："+item.getDeviceid())
                .setText(R.id.time,"设备部署时间："+item.getInstall_time())
                .setText(R.id.chiyouren,"持有人："+item.getSeller_man())
                .setText(R.id.chiyouren_tel,"联系方式："+item.getSeller_mobile())
                .setText(R.id.anzhuangren,"安装人："+item.getInstall_man())
                .setText(R.id.anzhuangren_tel,"联系方式："+item.getInstall_mobile())
                .setText(R.id.address,"详细地址："+item.getAddress());

    }
}