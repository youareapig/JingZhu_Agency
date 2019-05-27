package com.xiaomai.ageny.offline.fragment.indirect.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.DirectDetailsActivity;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.IndirectDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseQuickAdapter<OffIndirectDeivceBean.DataBean.ListBeanX.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<OffIndirectDeivceBean.DataBean.ListBeanX.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffIndirectDeivceBean.DataBean.ListBeanX.ListBean item) {
        helper.setText(R.id.item_storename, item.getRealname())
                .setText(R.id.tel, item.getMobile());
        RecyclerView recyclerView = helper.getView(R.id.item_recycler);

        final List<OffIndirectDeivceBean.DataBean.ListBeanX.ListBean.BoxBean> list = item.getBox();

        Adapter_Item adapter_item = new Adapter_Item(R.layout.direct_item_item, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter_item);
        adapter_item.openLoadAnimation();
        adapter_item.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(view.getContext(), IndirectDetailsActivity.class);
                intent.putExtra("id", list.get(position).getBoxid());
                intent.putExtra("fromact", 2);
                view.getContext().startActivity(intent);
            }
        });
    }
}
