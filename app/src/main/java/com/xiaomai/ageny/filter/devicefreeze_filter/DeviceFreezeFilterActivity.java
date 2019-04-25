package com.xiaomai.ageny.filter.devicefreeze_filter;

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
import com.xiaomai.ageny.device_manage.device_freeze.DeviceFreezeActivity;
import com.xiaomai.ageny.filter.devicefreeze_filter.contract.DeviceFreezeFilterContract;
import com.xiaomai.ageny.filter.devicefreeze_filter.presenter.DeviceFreezeFilterPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceFreezeFilterActivity extends BaseMvpActivity<DeviceFreezeFilterPresenter> implements DeviceFreezeFilterContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    @BindView(R.id.deviceId)
    EditText deviceId;
    private List<String> list;
    private Adapter adapter;
    private String strId = "";
    private int state;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_freeze_filter;
    }

    @Override
    public void initView() {
        strId = SharedPreferencesUtil.getInstance(this).getSP("freezed_id");
        deviceId.setText(strId);

        bundle = new Bundle();
        list = new ArrayList<>();
        list.add("全部");
        list.add("直属");
        list.add("非直属");
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
                deviceId.setText("");
                adapter.setSelectItem(0);
                adapter.notifyDataSetChanged();
                break;
            case R.id.filter_bt_submit:
                strId = deviceId.getText().toString();
                SharedPreferencesUtil.getInstance(this).putSP("freezed_id", strId);
                SharedPreferencesUtil.getInstance(this).putSP("freezed_state", state == 0 ? "" : list.get(state));
                finish();
                break;
        }
    }


}
