package com.xiaomai.ageny.mybill;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.BillListBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<BillListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<BillListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, BillListBean.DataBean.ListBean item) {
        helper.setText(R.id.title_month, item.getBillMonth())
                .setText(R.id.paymentday,"账期："+item.getBillDate())
                .setText(R.id.totle_money,item.getTotalEarn())
                .setText(R.id.dailifenrun,item.getAgentEarn())
                .setText(R.id.shangjifenrun,item.getSellerEarn())
                .setText(R.id.chuzhang,"出账日期："+item.getCreateTime());


    }
}