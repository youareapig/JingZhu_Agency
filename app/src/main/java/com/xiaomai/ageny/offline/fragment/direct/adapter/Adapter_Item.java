package com.xiaomai.ageny.offline.fragment.direct.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;

import java.util.List;

public class Adapter_Item extends BaseQuickAdapter<String,BaseViewHolder> {
    public Adapter_Item(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.price,item);
    }
}
