package com.xiaomai.ageny.offline.fragment.indirect.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;

import java.util.List;

public class Adapter_Item extends BaseQuickAdapter<OffIndirectDeivceBean.DataBean.ListBean.BoxBean, BaseViewHolder> {
    public Adapter_Item(int layoutResId, @Nullable List<OffIndirectDeivceBean.DataBean.ListBean.BoxBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffIndirectDeivceBean.DataBean.ListBean.BoxBean item) {
        int kou = Integer.parseInt(item.getStock());
        int tai = kou - 1;
        helper.setText(R.id.price, item.getDetails())
                .setText(R.id.deviceId, item.getBoxid())
                .setText(R.id.devicetype, kou + "口" + tai + "台")
                .setText(R.id.address, item.getBoxaddress())
                .setText(R.id.off_line_time, "离线"+item.getLixiantime() + "h");

    }
}
