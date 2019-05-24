package com.xiaomai.ageny.shanghudevice;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.shanghudevicefilter.ShangHuDeviceFilterActivity;
import com.xiaomai.ageny.shanghudevice.contract.ShangHuDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.offdevice.OffDeviceFragment;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.OnDeviecFragment;
import com.xiaomai.ageny.shanghudevice.presenter.ShangHuDevicePresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
    private String id;
    public static ShanghuDeviceActivity instance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shanghu_device;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        instance = this;
        titleList = new ArrayList<>();
        titleList.add("在线设备");
        titleList.add("离线设备");
        fragmentList = new ArrayList<>();
        fragmentList.add(new OnDeviecFragment(id));
        fragmentList.add(new OffDeviceFragment(id));

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
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, ShangHuDeviceFilterActivity.class);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //清空筛选条件
        SharedPreferencesUtil.getInstance(this).putSP("contanct_device_id", "");
        SharedPreferencesUtil.getInstance(this).putSP("contanct_device_slot", "");
    }
}
