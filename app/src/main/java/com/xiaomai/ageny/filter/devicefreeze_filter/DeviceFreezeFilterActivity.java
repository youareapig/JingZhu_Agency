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
    private String strRelation = "";
    private Bundle bundle;
    private int tabposition;
    @Override
    public int getLayoutId() {
        return R.layout.activity_device_freeze_filter;
    }

    @Override
    public void initView() {
        Bundle bundle1=getIntent().getExtras();
        if (bundle1!=null){
            tabposition=bundle1.getInt("tabposition");
        }

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
                strRelation = list.get(position);
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
                break;
            case R.id.filter_bt_reset:
                break;
            case R.id.filter_bt_submit:
                strId = deviceId.getText().toString().trim();
                bundle.putString("filler_deviceid", strId);
                bundle.putString("filler_relation", strRelation);
                bundle.putInt("tabposition", tabposition);
                toClass(this, DeviceFreezeActivity.class, bundle);
                finish();
                break;
        }
    }


}
