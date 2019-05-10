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
                .setText(R.id.haveman, "持有人：" + item.getSellerLinkman())
                .setText(R.id.installman, "安装人：" + item.getInstallMan())
                .setText(R.id.freeze_money, item.getNofreezeMoney())
                .setText(R.id.nofreezemoney, item.getUnfreezeMoney())
                .setText(R.id.relation, item.getRelation().equals("0") ? "非直属" : "直属");

    }
}