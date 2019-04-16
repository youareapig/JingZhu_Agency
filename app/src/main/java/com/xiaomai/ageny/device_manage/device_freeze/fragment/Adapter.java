package com.xiaomai.ageny.device_manage.device_freeze.fragment;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.FreezeBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<FreezeBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<FreezeBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FreezeBean.DataBean.ListBean item) {
        helper.setText(R.id.name, item.getSellerName())
                .setText(R.id.id, item.getDeviceid())
                .setText(R.id.haveman, item.getSellerLinkman())
                .setText(R.id.installman, item.getInstallMan())
                .setText(R.id.freeze_money, item.getFreezeMoney())
                .setText(R.id.nofreezemoney, item.getNofreezeMoney());

    }
}