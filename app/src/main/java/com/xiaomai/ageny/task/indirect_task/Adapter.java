package com.xiaomai.ageny.task.indirect_task;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;

import java.util.List;

public class Adapter extends BaseQuickAdapter<OffIndirectDeivceBean.DataBean.ListBean, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<OffIndirectDeivceBean.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OffIndirectDeivceBean.DataBean.ListBean item) {
        helper.setText(R.id.item_storename, item.getRealname())
                .setText(R.id.tel,item.getMobile());
        RecyclerView recyclerView = helper.getView(R.id.item_recycler);

        final List<OffIndirectDeivceBean.DataBean.ListBean.BoxBean> list = item.getBox();

        Adapter_Item adapter_item = new Adapter_Item(R.layout.task_indirect_item_item, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(App.context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter_item);
        adapter_item.openLoadAnimation();
    }
}
