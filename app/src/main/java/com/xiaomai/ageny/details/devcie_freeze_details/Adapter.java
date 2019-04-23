package com.xiaomai.ageny.details.devcie_freeze_details;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.FreezeDetailsBean;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.DirectDetailsActivity;
import com.xiaomai.ageny.offline.fragment.direct.adapter.Adapter_Item;

import java.util.List;

public class Adapter extends BaseQuickAdapter<FreezeDetailsBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<FreezeDetailsBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FreezeDetailsBean.DataBean.ListBean item) {
        TextView agencytype = helper.getView(R.id.agencytype);
        ImageView icon = helper.getView(R.id.icon);
        switch (item.getType()) {
            case "1":
                agencytype.setText("总代理：");
                icon.setImageResource(R.mipmap.icon_agent_all);
                break;
            case "2":
                agencytype.setText("一级代理：");
                icon.setImageResource(R.mipmap.icon_agent_one);
                break;
            case "3":
                agencytype.setText("二级代理：");
                icon.setImageResource(R.mipmap.icon_agent_two);
                break;
            case "4":
                agencytype.setText("三级代理：");
                icon.setImageResource(R.mipmap.icon_agent_three);
                break;
        }
        helper.setText(R.id.agency, item.getName());
    }
}
