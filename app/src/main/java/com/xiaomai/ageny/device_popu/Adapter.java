package com.xiaomai.ageny.device_popu;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.R;

import java.util.List;

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int selectItem = 0;
    public Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.name, item);
        if (helper.getAdapterPosition()==selectItem){
            //选中
            helper.setBackgroundRes(R.id.name, R.drawable.pop_select);
            helper.setTextColor(R.id.name, Color.parseColor("#FFFFFF"));
        }else {
            //未选中
            helper.setBackgroundRes(R.id.name, R.drawable.pop_noselect);
            helper.setTextColor(R.id.name, Color.parseColor("#117AE7"));
        }
    }
    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }
}
