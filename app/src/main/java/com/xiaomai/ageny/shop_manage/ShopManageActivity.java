package com.xiaomai.ageny.shop_manage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.filter.record_filter.RecordFilterActivity;
import com.xiaomai.ageny.filter.shop_filter.ShopFilterActivity;
import com.xiaomai.ageny.order.fragment.lowerorder.LowerOrderFragment;
import com.xiaomai.ageny.order.fragment.myorder.MyOderFragment;
import com.xiaomai.ageny.shop_manage.fragment.record.Record_Fragment;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.ShopNote_Fragment;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopManageActivity extends BaseActivity {


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
    private int tabPosition = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_manage;
    }

    @Override
    public void initView() {
        titleList = new ArrayList<>();
        titleList.add("采购单");
        titleList.add("申请记录");
        fragmentList = new ArrayList<>();
        fragmentList.add(new ShopNote_Fragment());
        fragmentList.add(new Record_Fragment());

        viewpage.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        viewpage.setOffscreenPageLimit(0);
        xtab.setupWithViewPager(viewpage);
        xtab.getTabAt(0).select();
        xtab.getTabAt(1).select();
        viewpage.setCurrentItem(0);
        xtab.setOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(XTabLayout.Tab tab) {
                tabPosition = tab.getPosition();
                viewpage.setCurrentItem(tabPosition);
            }

            @Override
            public void onTabUnselected(XTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(XTabLayout.Tab tab) {

            }
        });
    }


    @OnClick({R.id.back, R.id.bt_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                if (tabPosition == 0) {
                    toClass1(this, ShopFilterActivity.class);
                }
                if (tabPosition == 1) {
                    toClass1(this, RecordFilterActivity.class);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtil.getInstance(this).putSP("record_times", "");
        SharedPreferencesUtil.getInstance(this).putSP("record_tel", "");
        SharedPreferencesUtil.getInstance(this).putSP("record_state", "");
        SharedPreferencesUtil.getInstance(this).putSP("shop_times", "");
        SharedPreferencesUtil.getInstance(this).putSP("shop_tel", "");
    }
}
