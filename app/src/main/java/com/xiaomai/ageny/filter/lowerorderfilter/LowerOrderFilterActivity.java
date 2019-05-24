package com.xiaomai.ageny.filter.lowerorderfilter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.lowerorderfilter.contract.LowerOrderFilterContract;
import com.xiaomai.ageny.filter.lowerorderfilter.presenter.LowerOrderFilterPresenter;
import com.xiaomai.ageny.utils.DateUtils;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LowerOrderFilterActivity extends BaseMvpActivity<LowerOrderFilterPresenter> implements LowerOrderFilterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    @BindView(R.id.id)
    EditText id;
    @BindView(R.id.tel)
    EditText tel;

    private List<String> list;
    private Adapter adapter;
    private String strId, strTel;
    private int state;

    @Override
    public int getLayoutId() {
        return R.layout.activity_lower_order_filter;
    }

    @Override
    public void initView() {
        strId = SharedPreferencesUtil.getInstance(this).getSP("lowerorder_id");
        strTel = SharedPreferencesUtil.getInstance(this).getSP("lowerorder_name");
        id.setText(strId);
        tel.setText(strTel);

        list = new ArrayList<>();
        list.add("全部");
        list.add("今天");
        list.add("近3天");
        list.add("近7天");
        list.add("近30天");
        recycler.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(30));
        adapter = new Adapter(R.layout.myorderfilter_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
                state = position;
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }


    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                id.setText("");
                tel.setText("");
                adapter.setSelectItem(0);
                adapter.notifyDataSetChanged();
                break;
            case R.id.filter_bt_submit:
                strId = id.getText().toString().trim();
                strTel = tel.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("lowerorder_id", strId);
                SharedPreferencesUtil.getInstance(this).putSP("lowerorder_name", strTel);
                switch (state) {
                    case 0:
                        //全部
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", "");
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", "");
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "");
                        break;
                    case 1:
                        //今天
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", DateUtils.getOldDate(0));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", DateUtils.getOldDate(0));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "0");
                        break;

                    case 2:
                        //近三天
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", DateUtils.getOldDate(3));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", DateUtils.getOldDate(0));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "3");
                        break;
                    case 3:
                        //近七天
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", DateUtils.getOldDate(7));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", DateUtils.getOldDate(0));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "7");
                        break;
                    case 4:
                        //近三十天
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", DateUtils.getOldDate(30));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", DateUtils.getOldDate(0));
                        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "30");
                        break;
                }
                Intent intent = new Intent();
                setResult(2, intent);
                finish();

                break;
        }
    }

}
