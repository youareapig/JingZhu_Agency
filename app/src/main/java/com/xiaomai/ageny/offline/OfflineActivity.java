package com.xiaomai.ageny.offline;

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
import com.xiaomai.ageny.filter.directfilter.DirectFilterActivity;
import com.xiaomai.ageny.filter.indirectfilter.IndirectFilterActivity;
import com.xiaomai.ageny.offline.contract.OfflineContract;
import com.xiaomai.ageny.offline.fragment.direct.DirectFragment;
import com.xiaomai.ageny.offline.fragment.indirect.IndirectFragment;
import com.xiaomai.ageny.offline.presenter.OfflinePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OfflineActivity extends BaseMvpActivity<OfflinePresenter> implements OfflineContract.View {


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
        return R.layout.activity_offline;
    }

    @Override
    public void initView() {
        titleList = new ArrayList<>();
        titleList.add("直属设备");
        titleList.add("非直属设备");
        fragmentList = new ArrayList<>();
        fragmentList.add(new DirectFragment());
        fragmentList.add(new IndirectFragment());

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
                //不加这句点击不能切换，但能滑动
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
                if (tabPosition == 0) {
                    toClass(this, DirectFilterActivity.class);
                }
                if (tabPosition == 1) {
                    toClass(this, IndirectFilterActivity.class);
                }

                break;
        }
    }
}
