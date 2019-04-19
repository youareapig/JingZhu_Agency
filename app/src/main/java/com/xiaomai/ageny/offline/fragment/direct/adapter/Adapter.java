package com.xiaomai.ageny.offline.fragment.direct.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.DirectDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseQuickAdapter<OffDirectDeviceBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<OffDirectDeviceBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffDirectDeviceBean.DataBean.ListBean item) {
        helper.setText(R.id.item_storename, item.getSellername());
        RecyclerView recyclerView = helper.getView(R.id.item_recycler);
        final List<OffDirectDeviceBean.DataBean.ListBean.BoxBean> list = item.getBox();

        Adapter_Item adapter_item = new Adapter_Item(R.layout.direct_item_item, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter_item);
        adapter_item.openLoadAnimation();
        adapter_item.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(view.getContext(), DirectDetailsActivity.class);
                intent.putExtra("id", list.get(position).getBoxid());
                view.getContext().startActivity(intent);
            }
        });
    }
}
