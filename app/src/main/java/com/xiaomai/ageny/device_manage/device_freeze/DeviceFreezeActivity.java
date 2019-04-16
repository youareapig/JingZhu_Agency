package com.xiaomai.ageny.device_manage.device_freeze;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_freeze.contract.DeviceFreezeContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.Freezed_Fragment;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.NoFreeze_Fragment;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.returnmoney.ReturnMoney_Fragment;
import com.xiaomai.ageny.device_manage.device_freeze.presenter.DeviceFreezePresenter;
import com.xiaomai.ageny.filter.devicefreeze_filter.DeviceFreezeFilterActivity;
import com.xiaomai.ageny.order.fragment.lowerorder.LowerOrderFragment;
import com.xiaomai.ageny.order.fragment.myorder.MyOderFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceFreezeActivity extends BaseMvpActivity<DeviceFreezePresenter> implements DeviceFreezeContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.xtab)
    XTabLayout xtab;
    @BindView(R.id.viewpage)
    ViewPager viewpage;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private String id, reletion;
    private int tabposition = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_freeze;
    }

    @Override
    public void initView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("filler_deviceid");
            reletion = bundle.getString("filler_relation");
            tabposition = bundle.getInt("tabposition");
        }

        titleList = new ArrayList<>();
        titleList.add("未解冻");
        titleList.add("已解冻");
        titleList.add("已回款");
        fragmentList = new ArrayList<>();
        fragmentList.add(new NoFreeze_Fragment(id, reletion));
        fragmentList.add(new Freezed_Fragment());
        fragmentList.add(new ReturnMoney_Fragment());

        viewpage.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        viewpage.setOffscreenPageLimit(3);
        xtab.setupWithViewPager(viewpage);
        xtab.getTabAt(0).select();
        xtab.getTabAt(1).select();
        viewpage.setCurrentItem(0);

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
                Bundle bundle1 = new Bundle();
                bundle1.putInt("tabposition", tabposition);
                toClass(this, DeviceFreezeFilterActivity.class, bundle1);
                break;
        }
    }
}
