package com.xiaomai.ageny.shanghudevice.fragment.offdevice;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.ContactDeviceListBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<ContactDeviceListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<ContactDeviceListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactDeviceListBean.DataBean.ListBean item) {
        helper.setText(R.id.money, item.getMoney())
                .setText(R.id.deviceId, item.getId())
                .setText(R.id.lat, "经纬度：" + item.getLatitude() + "," + item.getLongitude())
                .setText(R.id.address, item.getBoxAddress())
                .setText(R.id.cao_count, item.getStock() + "槽")
                .setText(R.id.off_line_time, "离线：" + item.getLixianTime() + "h")
                .setText(R.id.price, item.getDetails() + "元/小时");

    }
}
