package com.xiaomai.ageny.deposit_list;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
        TextView state = helper.getView(R.id.state);
        RelativeLayout failview = helper.getView(R.id.failview);
        TextView reason = helper.getView(R.id.reason);

        helper.setText(R.id.banktype, item.getBank())
                .setText(R.id.money, item.getMoney())
                .setText(R.id.time, item.getApplyTime())
                .setText(R.id.name, "尾号" + "(" + BaseUtils.subsubBehindNumString(item.getCreditCard(), 4) + ")" + item.getRealName())
                .setText(R.id.service_money, item.getServiceMoney() + "元");
        switch (item.getState()) {
            case "0":
                state.setText("申请中");
                state.setTextColor(Color.parseColor("#117AE7"));
                failview.setVisibility(View.GONE);
                break;
            case "1":
                state.setText("已通过");
                state.setTextColor(Color.parseColor("#666666"));
                failview.setVisibility(View.GONE);
                break;
            case "-1":
                state.setText("未通过");
                state.setTextColor(Color.parseColor("#E55C5C"));
                failview.setVisibility(View.VISIBLE);
                reason.setText(item.getDetails());
                break;
        }
    }
}