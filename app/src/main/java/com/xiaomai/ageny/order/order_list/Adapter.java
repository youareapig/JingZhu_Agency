package com.xiaomai.ageny.order.order_list;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.bean.OrderListBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<OrderListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<OrderListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderListBean.DataBean.ListBean item) {
        helper.setText(R.id.orderId, item.getOrderid())
                .setText(R.id.orderTime, item.getUpdTime())
                .setText(R.id.storename, item.getSellername())
                .setText(R.id.name, "所属代理：" + item.getAgentname())
                .setText(R.id.rentTime, "租借时间：" + item.getLeasetime())
                .setText(R.id.pay, "实付金额" + item.getRentprice() + "元")
                .setText(R.id.make_money, item.getEarn());

    }
}
