package com.xiaomai.ageny.shop_manage.fragment.record;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.ShopApplyBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<ShopApplyBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<ShopApplyBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopApplyBean.DataBean item) {
        TextView state = helper.getView(R.id.state);
        LinearLayout failview = helper.getView(R.id.failview);
        helper.setText(R.id.time, DateUtils.timeStamp2DateYMDHM(item.getApplyTime().getTime() + ""))
                .setText(R.id.times, "批次：" + item.getBatch())
                .setText(R.id.receiver, "收件人：" + item.getReceiptName() + "  " + item.getReceiptMobile())
                .setText(R.id.small, item.getDeviceSmall() + "数量：" + item.getDeviceSmallcount() + "台")
                .setText(R.id.big, item.getDeviceBig() + "数量：" + item.getDeviceBigcount() + "台")
                .setText(R.id.paytype, "付款方式：" + item.getPayment())
                .setText(R.id.info, item.getExamination());
        switch (item.getState()) {
            case "1":
                state.setText("已完成");
                state.setTextColor(Color.parseColor("#666666"));
                failview.setVisibility(View.GONE);
                break;
            case "0":
                state.setText("申请中");
                state.setTextColor(Color.parseColor("#117AE7"));
                failview.setVisibility(View.GONE);
                break;
            case "-1":
                state.setText("未通过");
                state.setTextColor(Color.parseColor("#E55C5C"));
                failview.setVisibility(View.VISIBLE);
                break;
        }
    }
}
