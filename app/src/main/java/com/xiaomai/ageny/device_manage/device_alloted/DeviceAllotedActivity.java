package com.xiaomai.ageny.device_manage.device_alloted;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_alloted.contract.DeviceAllotedContract;
import com.xiaomai.ageny.device_manage.device_alloted.presenter.DeviceAllotedPresenter;
import com.xiaomai.ageny.filter.device_alloted_filter.DeviceAllotedFilterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotedActivity extends BaseMvpActivity<DeviceAllotedPresenter> implements DeviceAllotedContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private List<String> list;
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_alloted;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.device_alloted_item, list);
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
                toClass(this, DeviceAllotedFilterActivity.class);
                break;
        }
    }
}
