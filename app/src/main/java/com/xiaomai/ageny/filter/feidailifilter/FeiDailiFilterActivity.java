package com.xiaomai.ageny.filter.feidailifilter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.feidailifilter.contract.FeidailiFilterContract;
import com.xiaomai.ageny.filter.feidailifilter.presenter.FeidailiFilterPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeiDailiFilterActivity extends BaseMvpActivity<FeidailiFilterPresenter> implements FeidailiFilterContract.View {


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
    private List<String> list;
    private Adapter adapter;
    private String strLev, strId;
    private int lev = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fei_daili_filter;
    }

    @Override
    public void initView() {
        strId = SharedPreferencesUtil.getInstance(this).getSP("zhishuId");
        id.setText(strId);

        list = new ArrayList<>();
        list.add("全部");
        list.add("二级");
        list.add("三级");
        recycler.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(30));
        adapter = new Adapter(R.layout.myorderfilter_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                lev = position;
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
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
                adapter.setSelectItem(0);
                adapter.notifyDataSetChanged();
                break;
            case R.id.filter_bt_submit:
                strId = id.getText().toString().trim();
                Logger.d("选中等级" + lev);
                SharedPreferencesUtil.getInstance(this).putSP("zhishuId", strId);
                SharedPreferencesUtil.getInstance(this).putSP("zhishuLev", lev == 0 ? "" : lev + 1 + "");
                Intent intent=new Intent();
                setResult(2,intent);
                finish();
                break;
        }
    }

}
