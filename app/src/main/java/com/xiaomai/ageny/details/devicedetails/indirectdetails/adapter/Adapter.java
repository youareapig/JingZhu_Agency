package com.xiaomai.ageny.details.devicedetails.indirectdetails.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.DirectDetailsActivity;
import com.xiaomai.ageny.offline.fragment.direct.adapter.Adapter_Item;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseQuickAdapter<OffIndirectDeivceDetailsBean.DataBean.ListBean, BaseViewHolder> {
    private String strLevel;

    public Adapter(int layoutResId, @Nullable List<OffIndirectDeivceDetailsBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffIndirectDeivceDetailsBean.DataBean.ListBean item) {
        switch (item.getLevel()) {
            case "1":
                strLevel = "总代理";
                break;
            case "2":
                strLevel = "一级代理";
                break;
            case "3":
                strLevel = "二级代理";
                break;
            case "4":
                strLevel = "三级代理";
                break;
            case "9":
                strLevel = "商户";
                break;
        }
        helper.setText(R.id.name, item.getName())
                .setText(R.id.agency, strLevel);
//                .setText(R.id.time, DateUtils.timeStamp2Date(item.getDistTime().getTime()+""));

    }
}
