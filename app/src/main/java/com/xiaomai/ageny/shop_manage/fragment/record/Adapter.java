package com.xiaomai.ageny.shop_manage.fragment.record;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.ShopApplyBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<ShopApplyBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<ShopApplyBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopApplyBean.DataBean item) {
        helper.setText(R.id.time, item.getApplyTime() + "")
                .setText(R.id.state, item.getState().equals("1") ? "已通过" : (item.getState().equals("0") ? "审核中" : "未通过"))
                .setText(R.id.times, "批次：" + item.getBatch())
                .setText(R.id.receiver, "收件人：" + item.getReceiptName() + "  " + item.getReceiptMobile())
                .setText(R.id.small, item.getDeviceSmall() + "数量：" + item.getDeviceSmallcount() + "台")
                .setText(R.id.big, item.getDeviceBig() + "数量：" + item.getDeviceBigcount() + "台")
                .setText(R.id.paytype, "付款方式：" + item.getPayment())
                .setText(R.id.info, item.getExamination());

    }
}
