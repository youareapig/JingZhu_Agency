package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.xiajishfilter.XiajiSHFilterActivity;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.contract.XiajiSHDeviceListContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.XiajiSHDeviceListOn_Fragment;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_off.XiajiSHDeviceListOff_Fragment;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.presenter.XiajiSHDeviceListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class XiajiSHDeviceListActivity extends BaseMvpActivity<XiajiSHDeviceListPresenter> implements XiajiSHDeviceListContract.View {


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

    @Override
    public int getLayoutId() {
        return R.layout.activity_xiajishanghu_device_list;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        titleList = new ArrayList<>();
        titleList.add("在线设备");
        titleList.add("离线设备");
        fragmentList = new ArrayList<>();
        fragmentList.add(new XiajiSHDeviceListOn_Fragment(id));
        fragmentList.add(new XiajiSHDeviceListOff_Fragment(id));

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
                toClass(this, XiajiSHFilterActivity.class);
                break;
        }
    }
}
