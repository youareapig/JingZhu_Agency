package com.xiaomai.ageny.system_notice;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.SystemNoticeBean;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.List;

public class Adapter extends BaseQuickAdapter<SystemNoticeBean.DataBean.ListBean, BaseViewHolder> {
    private String strhead;

    public Adapter(int layoutResId, @Nullable List<SystemNoticeBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemNoticeBean.DataBean.ListBean item) {
        TextView tv_title, tv_deviceid, tv_name, tv_address, tv_ystime, tv_yjtime;
        ImageView item_icon;
        tv_title = helper.getView(R.id.item_title);
        tv_deviceid = helper.getView(R.id.item_deviceid);
        tv_name = helper.getView(R.id.item_name);
        tv_address = helper.getView(R.id.item_adress);
        tv_ystime = helper.getView(R.id.item_ystime);
        tv_yjtime = helper.getView(R.id.item_yjtime);
        item_icon = helper.getView(R.id.item_icon);
        //0 遗失  1找回  2离线
        switch (item.getType()) {
            case 0:
                strhead = "遗失时间：";
                break;
            case 1:
                strhead = "找回时间：";
                break;
            case 2:
                strhead = "预警时间：";
                break;
        }

        if (TextUtils.isEmpty(item.getMessage())) {
            tv_title.setVisibility(View.GONE);
        } else {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(item.getMessage());
        }
        if (TextUtils.isEmpty(item.getDeviceId())) {
            tv_deviceid.setVisibility(View.GONE);
        } else {
            tv_deviceid.setVisibility(View.VISIBLE);
            tv_deviceid.setText("设备编号：" + item.getDeviceId());
        }
        if (TextUtils.isEmpty(item.getSellername())) {
            tv_name.setVisibility(View.GONE);
        } else {
            tv_name.setVisibility(View.VISIBLE);
            tv_name.setText("商户联系人：" + item.getSellername() + "  " + item.getSellertel());
        }
        if (TextUtils.isEmpty(item.getAddress())) {
            tv_address.setVisibility(View.GONE);
        } else {
            tv_address.setVisibility(View.VISIBLE);
            tv_address.setText("设备地址：" + item.getAddress());
        }
        if (TextUtils.isEmpty(item.getCreateTime().getTime() + "")) {
            tv_ystime.setVisibility(View.GONE);
        } else {
            tv_ystime.setVisibility(View.VISIBLE);
            tv_ystime.setText(strhead + DateUtils.timeStamp2DateYMDHM(item.getCreateTime().getTime() + ""));
        }

        //0 未读  1 已读
        item_icon.setImageResource(item.getState() == 0 ? R.mipmap.news_icon : R.mipmap.news_icon1);
    }
}