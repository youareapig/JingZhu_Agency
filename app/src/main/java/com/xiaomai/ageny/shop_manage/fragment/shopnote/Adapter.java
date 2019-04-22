package com.xiaomai.ageny.shop_manage.fragment.shopnote;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.ShopRecordBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<ShopRecordBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<ShopRecordBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopRecordBean.DataBean.ListBean item) {
        helper.setText(R.id.times, "批次："+item.getBatch())
                .setText(R.id.receiver,"收件人："+item.getReceiptName()+"  "+item.getReceiptMobile())
                .setText(R.id.typesmall,item.getDeviceSmall()+"数量：")
                .setText(R.id.small_fahuo,item.getDeviceSmallDelivery())
                .setText(R.id.smallweifahuo,item.getDeviceSmallNodelivery())
                .setText(R.id.typebig,item.getDeviceBig()+"数量：")
                .setText(R.id.big_fahuo,item.getDeviceBigDelivery())
                .setText(R.id.big_weifahuo,item.getDeviceBigNodelivery());

    }
}
