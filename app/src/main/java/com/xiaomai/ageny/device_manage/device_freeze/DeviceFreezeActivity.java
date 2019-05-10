package com.xiaomai.ageny.device_manage.device_freeze;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_freeze.contract.DeviceFreezeContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.freezed.Freezed_Fragment;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.NoFreeze_Fragment;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.returnmoney.ReturnMoney_Fragment;
import com.xiaomai.ageny.device_manage.device_freeze.presenter.DeviceFreezePresenter;
import com.xiaomai.ageny.filter.devicefreeze_filter.DeviceFreezeFilterActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceFreezeActivity extends BaseMvpActivity<DeviceFreezePresenter> implements DeviceFreezeContract.View, NoFreeze_Fragment.CallBackListener {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.xtab)
    XTabLayout xtab;
    @BindView(R.id.viewpage)
    ViewPager viewpage;
    @BindView(R.id.tv_tixian_money)
    TextView tvTixianMoney;
    @BindView(R.id.tv_tixian_dongjie)
    TextView tvTixianDongjie;
    private List<String> titleList;
    private List<Fragment> fragmentList;


    @Override
    public int getLayoutId() {
        return R.layout.activity_device_freeze;
    }

    @Override
    public void initView() {

        titleList = new ArrayList<>();
        titleList.add("未解冻");
        titleList.add("已解冻");
        titleList.add("已回款");
        fragmentList = new ArrayList<>();
        fragmentList.add(new NoFreeze_Fragment());
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
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, DeviceFreezeFilterActivity.class);
                break;
        }
    }


    @Override
    public void callback(String nofreeze_device, String nofreeze_momney) {
        tvTixianMoney.setText(nofreeze_device);
        tvTixianDongjie.setText(nofreeze_momney);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtil.getInstance(this).putSP("freezed_id", "");
        SharedPreferencesUtil.getInstance(this).putSP("freezed_state", "");
    }
}

