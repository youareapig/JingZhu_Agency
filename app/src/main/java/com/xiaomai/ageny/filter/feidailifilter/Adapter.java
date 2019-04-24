package com.xiaomai.ageny.filter.feidailifilter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.List;

public class Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int selectItem = 0;

    public Adapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        String lev = SharedPreferencesUtil.getInstance(App.context).getSP("zhishuLev");
        if (TextUtils.isEmpty(lev)) {
            selectItem = 0;
        } else {
            selectItem = Integer.valueOf(lev)-1;
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.name, item);
        if (helper.getAdapterPosition() == selectItem) {
            //选中
            helper.setBackgroundRes(R.id.name, R.drawable.filter_select);
            helper.setTextColor(R.id.name, Color.parseColor("#FFFFFF"));
        } else {
            //未选中
            helper.setBackgroundRes(R.id.name, R.drawable.filter_noselect);
            helper.setTextColor(R.id.name, Color.parseColor("#363636"));
        }
    }

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
    }
}
