package com.xiaomai.ageny.deviceinstalllist;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.deploy.DeployActivity;
import com.xiaomai.ageny.deviceinstalllist.adapter.Adapter;
import com.xiaomai.ageny.deviceinstalllist.contract.DeviceInstallContract;
import com.xiaomai.ageny.deviceinstalllist.presenter.DeviceInstallPresenter;
import com.xiaomai.ageny.filter.deviceinstall.DeviceInstallFilterActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DeviceInstallActivity extends BaseMvpActivity<DeviceInstallPresenter> implements DeviceInstallContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_install)
    RelativeLayout btInstall;

    private Adapter adapter;
    private List<String> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_install;
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
        adapter = new Adapter(R.layout.device_install_item, list);
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


    @OnClick({R.id.back, R.id.bt_filter, R.id.bt_install})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, DeviceInstallFilterActivity.class);
                break;
            case R.id.bt_install:
                toClass(this, DeployActivity.class);
                break;
        }
    }

}
