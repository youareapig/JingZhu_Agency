package com.xiaomai.ageny.device_manage.device_noallot;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_noallot.contract.DeviceNoAllotContract;
import com.xiaomai.ageny.device_manage.device_noallot.presenter.DeviceNoAllotPresenter;
import com.xiaomai.ageny.filter.device_noallot_filter.DeviceNoAllotFilterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceNoAllotActivity extends BaseMvpActivity<DeviceNoAllotPresenter> implements DeviceNoAllotContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    private List<String> list;
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_no_allot;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.device_no_allot_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
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


    @OnClick({R.id.back, R.id.bt_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_filter:
                toClass(this, DeviceNoAllotFilterActivity.class);
                break;
        }
    }
}
