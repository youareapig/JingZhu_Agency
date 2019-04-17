package com.xiaomai.ageny.xiajishanghu.xiajishanghulist;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.AgencySellerListBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<AgencySellerListBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<AgencySellerListBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AgencySellerListBean.DataBean item) {
        helper.setText(R.id.name, item.getName())
                .setText(R.id.id, item.getId())
                .setText(R.id.onlinecount, item.getZaixian())
                .setText(R.id.offlin_count, item.getLixian());

    }
}