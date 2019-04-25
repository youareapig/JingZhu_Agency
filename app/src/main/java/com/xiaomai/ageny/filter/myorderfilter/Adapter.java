package com.xiaomai.ageny.filter.myorderfilter;

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
        String strDays = SharedPreferencesUtil.getInstance(App.context).getSP("myorder_days");
        if (TextUtils.isEmpty(strDays)) {
            selectItem = 0;
        }
        if (strDays.equals("0")) {
            selectItem = 1;
        }
        if (strDays.equals("3")) {
            selectItem = 2;
        }
        if (strDays.equals("7")) {
            selectItem = 3;
        }
        if (strDays.equals("30")) {
            selectItem = 4;
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
