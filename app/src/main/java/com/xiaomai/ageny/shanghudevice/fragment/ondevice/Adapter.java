package com.xiaomai.ageny.shanghudevice.fragment.ondevice;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;

import java.util.List;

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.money, item);

    }
}
