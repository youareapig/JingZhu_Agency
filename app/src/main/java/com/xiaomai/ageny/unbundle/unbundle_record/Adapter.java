package com.xiaomai.ageny.unbundle.unbundle_record;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.UnbindRecordBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<UnbindRecordBean.DataBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<UnbindRecordBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UnbindRecordBean.DataBean item) {
        helper.setText(R.id.storename, "商户名称：" + item.getSellerName())
                .setText(R.id.linkname, "商户联系人：" + item.getSellerLinkman())
                .setText(R.id.reason, "解绑原因：" + item.getInfo())
                .setText(R.id.time, "解绑时间：" + item.getApplyTime());

    }
}