package com.xiaomai.ageny.filter.shanghudevicefilter;

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
import com.xiaomai.ageny.filter.shanghudevicefilter.contract.ShangHuDeviceFilterContract;
import com.xiaomai.ageny.filter.shanghudevicefilter.presenter.ShangHuDeviceFilterPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShangHuDeviceFilterActivity extends BaseMvpActivity<ShangHuDeviceFilterPresenter> implements ShangHuDeviceFilterContract.View {


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
    private String deviceId;
    private int slotnum = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shang_hu_device_filter;
    }

    @Override
    public void initView() {
        deviceId = SharedPreferencesUtil.getInstance(this).getSP("contanct_device_id");
        id.setText(deviceId);

        list = new ArrayList<>();
        list.add("全部");
        list.add("6");
        list.add("12");
        recycler.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(30));
        adapter = new Adapter(R.layout.myorderfilter_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                slotnum = position;
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
                adapter.setSelectItem(0);
                adapter.notifyDataSetChanged();
                id.setText("");
                break;
            case R.id.filter_bt_submit:
                deviceId = id.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("contanct_device_id", deviceId);
                SharedPreferencesUtil.getInstance(this).putSP("contanct_device_slot", slotnum == 0 ? "" : list.get(slotnum));
                finish();
                break;
        }
    }

}
