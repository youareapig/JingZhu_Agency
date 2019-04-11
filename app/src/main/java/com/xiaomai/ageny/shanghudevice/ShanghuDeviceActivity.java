package com.xiaomai.ageny.shanghudevice;

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
import com.xiaomai.ageny.filter.lowerorderfilter.LowerOrderFilterActivity;
import com.xiaomai.ageny.filter.myorderfilter.MyOrderFilterActivity;
import com.xiaomai.ageny.filter.shanghudevicefilter.ShangHuDeviceFilterActivity;
import com.xiaomai.ageny.order.fragment.lowerorder.LowerOrderFragment;
import com.xiaomai.ageny.order.fragment.myorder.MyOderFragment;
import com.xiaomai.ageny.shanghudevice.contract.ShangHuDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.offdevice.OffDeviceFragment;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.OnDeviecFragment;
import com.xiaomai.ageny.shanghudevice.presenter.ShangHuDevicePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShanghuDeviceActivity extends BaseMvpActivity<ShangHuDevicePresenter> implements ShangHuDeviceContract.View {


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
    @Override
    public int getLayoutId() {
        return R.layout.activity_shanghu_device;
    }

    @Override
    public void initView() {
        titleList = new ArrayList<>();
        titleList.add("在线设备（89台）");
        titleList.add("离线设备（9台）");
        fragmentList = new ArrayList<>();
        fragmentList.add(new OnDeviecFragment());
        fragmentList.add(new OffDeviceFragment());

        viewpage.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        viewpage.setOffscreenPageLimit(0);
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
                toClass(this,ShangHuDeviceFilterActivity.class);
                break;
        }
    }
}
