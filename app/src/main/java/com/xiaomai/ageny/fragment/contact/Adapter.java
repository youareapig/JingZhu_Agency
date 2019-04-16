package com.xiaomai.ageny.fragment.contact;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.ContactListBean;

import java.util.List;

import butterknife.BindView;

public class Adapter extends BaseQuickAdapter<ContactListBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<ContactListBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactListBean.DataBean.ListBean item) {
        helper.setText(R.id.title, item.getName())
                .setText(R.id.rent_count, item.getBoxcount())
                .setText(R.id.offlin_count, item.getCount())
                .setText(R.id.make_moneycount, item.getMoney())
                .setText(R.id.name, item.getLinkman())
                .setText(R.id.tel, item.getLinktel())
                .setText(R.id.id,item.getId())
                .setText(R.id.address, item.getAddress());

    }
}
