package com.xiaomai.ageny.deposit_list;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.DepositListBean;
import com.xiaomai.ageny.utils.BaseUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<DepositListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<DepositListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DepositListBean.DataBean.ListBean item) {
        helper.setText(R.id.banktype, item.getBank())
                .setText(R.id.money, item.getMoney())
                .setText(R.id.state, item.getState().equals("0") ? "未处理" : (item.getState().endsWith("1") ? "已到账" : "提现失败"))
                .setText(R.id.time,item.getApplyTime())
                .setText(R.id.name,"尾号"+"("+BaseUtils.subsubBehindNumString(item.getCreditCard(),4)+")"+item.getRealName())
                .setText(R.id.service_money,item.getServiceMoney()+"元");

    }
}