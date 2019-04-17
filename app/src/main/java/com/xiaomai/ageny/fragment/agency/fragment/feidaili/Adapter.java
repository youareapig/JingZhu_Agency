package com.xiaomai.ageny.fragment.agency.fragment.feidaili;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.DailiListBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<DailiListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<DailiListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DailiListBean.DataBean.ListBean item) {
        helper.setText(R.id.name, item.getRealname())
                .setText(R.id.rent_count, item.getCount())
                .setText(R.id.offlin_count, item.getBoxcount())
                .setText(R.id.onlinecount, item.getZaixianbox())
                .setText(R.id.agencyId, item.getParentid())
                .setText(R.id.shangjiName, item.getParentRealname());

    }
}
