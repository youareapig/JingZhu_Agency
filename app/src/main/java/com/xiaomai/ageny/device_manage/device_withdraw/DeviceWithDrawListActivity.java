package com.xiaomai.ageny.device_manage.device_withdraw;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_withdraw.contract.DeviceWithDrawListContract;
import com.xiaomai.ageny.device_manage.device_withdraw.presenter.DeviceWithDrawListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceWithDrawListActivity extends BaseMvpActivity<DeviceWithDrawListPresenter> implements DeviceWithDrawListContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_sure_withdraw)
    TextView btSureWithdraw;

    private List<String> list;
    private Adapter adapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_device_with_draw_list;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("张三");
        list.add("旺旺");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.device_withdraw_item, list);
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


    @OnClick({R.id.back, R.id.bt_sure_withdraw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_sure_withdraw:
                toClass1(this,DeviceWithSuccessActivity.class);
                break;
        }
    }
}
