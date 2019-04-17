package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.XiajiListBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<XiajiListBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<XiajiListBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XiajiListBean.DataBean item) {
        helper.setText(R.id.deviceId, item.getId())
                .setText(R.id.price, "设置单价：" + item.getDetails() + "元/小时")
                .setText(R.id.time, "离线" + item.getLixianTime());

    }
}