package com.xiaomai.ageny.power_manager.power_withdraw;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bean.daobean.DeviceDao;

import java.util.List;

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.name, item);
        helper.addOnClickListener(R.id.delete);
    }
}