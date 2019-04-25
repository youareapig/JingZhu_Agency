package com.xiaomai.ageny.filter.record_filter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordFilterActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    @BindView(R.id.times)
    EditText times;
    @BindView(R.id.tel)
    EditText tel;
    private List<String> list;
    private Adapter adapter;
    private String strTimes, strTel;
    private int state;

    @Override
    public int getLayoutId() {
        return R.layout.activity_record_filter;
    }

    @Override
    public void initView() {
        strTel = SharedPreferencesUtil.getInstance(this).getSP("record_tel");
        strTimes = SharedPreferencesUtil.getInstance(this).getSP("record_times");
        times.setText(strTimes);
        tel.setText(strTel);

        list = new ArrayList<>();
        list.add("全部");
        list.add("申请中");
        list.add("已通过");
        list.add("未通过");
        recycler.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(30));
        adapter = new Adapter(R.layout.myorderfilter_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                state = position;
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                tel.setText("");
                times.setText("");
                adapter.setSelectItem(0);
                adapter.notifyDataSetChanged();
                break;
            case R.id.filter_bt_submit:
                strTel = tel.getText().toString().trim();
                strTimes = times.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("record_tel", strTel);
                SharedPreferencesUtil.getInstance(this).putSP("record_times", strTimes);
                SharedPreferencesUtil.getInstance(this).putSP("record_state", state == 0 ? "" : list.get(state));
                finish();
                break;
        }
    }


}
