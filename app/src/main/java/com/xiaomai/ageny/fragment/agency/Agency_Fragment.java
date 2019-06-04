package com.xiaomai.ageny.fragment.agency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.addagency.add.AddAgencyActivity;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.filter.dailifilter.DailiFilterActivity;
import com.xiaomai.ageny.filter.feidailifilter.FeiDailiFilterActivity;
import com.xiaomai.ageny.fragment.agency.contract.AgencyContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.DailiFragment;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.FeidailiFragment;
import com.xiaomai.ageny.fragment.agency.presenter.AgencyPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class Agency_Fragment extends BaseMvpFragment<AgencyPresenter> implements AgencyContract.View {
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.xtab)
    XTabLayout xtab;
    @BindView(R.id.viewpage)
    ViewPager viewpage;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private int tabPosition = 0;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        sView(0);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.agency_fragment;
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


    @OnClick({R.id.bt_filter, R.id.bt_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_filter:
                if (tabPosition == 0) {
                    //筛选直属代理
                    toClass(getActivity(), DailiFilterActivity.class, 1);
                }
                if (tabPosition == 1) {
                    //筛选非直属代理
                    toClass(getActivity(), FeiDailiFilterActivity.class, 2);
                }
                break;
            case R.id.bt_add:
                toClass(getActivity(), AddAgencyActivity.class, 3);
                break;
        }
    }

    private void sView(int posi) {
        titleList = new ArrayList<>();
        titleList.add("直属代理");
        titleList.add("非直属代理");
        fragmentList = new ArrayList<>();
        fragmentList.add(new DailiFragment());
        fragmentList.add(new FeidailiFragment());

        viewpage.setAdapter(new TabAdapter(getActivity().getSupportFragmentManager(), titleList, fragmentList));
        viewpage.setOffscreenPageLimit(2);
        xtab.setupWithViewPager(viewpage);
        xtab.getTabAt(posi).select();
        viewpage.setCurrentItem(posi);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 1) {
            titleList.clear();
            fragmentList.clear();
            sView(0);
        } else if (requestCode == 2 && resultCode == 2) {
            titleList.clear();
            fragmentList.clear();
            sView(1);

        } else if (requestCode == 3 && resultCode == 3) {
            titleList.clear();
            fragmentList.clear();
            sView(0);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //清空筛选条件
        SharedPreferencesUtil.getInstance(getActivity()).putSP("feizhishuTel", "");
        SharedPreferencesUtil.getInstance(getActivity()).putSP("feizhishuId", "");
        SharedPreferencesUtil.getInstance(getActivity()).putSP("zhishuId", "");
        SharedPreferencesUtil.getInstance(getActivity()).putSP("zhishuLev", "");
    }

}
