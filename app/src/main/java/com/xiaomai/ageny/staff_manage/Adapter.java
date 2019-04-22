package com.xiaomai.ageny.staff_manage;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.StaffBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<StaffBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<StaffBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, StaffBean.DataBean.ListBean item) {
        helper.setText(R.id.name, "姓名：" + item.getName())
                .setText(R.id.tel, "联系方式：" + item.getMobile())
                .setText(R.id.time, "最后登录时间：" + item.getLastLoginTime());
        helper.addOnClickListener(R.id.delete);

    }
}