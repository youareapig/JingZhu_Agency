package com.xiaomai.ageny.fragment.agency;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.xtablayout.XTabLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.addagency.add.AddAgencyActivity;
import com.xiaomai.ageny.addcontact.AddContactActivity;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.filter.dailifilter.DailiFilterActivity;
import com.xiaomai.ageny.filter.feidailifilter.FeiDailiFilterActivity;
import com.xiaomai.ageny.fragment.agency.contract.AgencyContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.DailiFragment;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.FeidailiFragment;
import com.xiaomai.ageny.fragment.agency.presenter.AgencyPresenter;
import com.xiaomai.ageny.order.fragment.lowerorder.LowerOrderFragment;
import com.xiaomai.ageny.order.fragment.myorder.MyOderFragment;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

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
        titleList = new ArrayList<>();
        titleList.add("直属代理");
        titleList.add("非直属代理");
        fragmentList = new ArrayList<>();
        fragmentList.add(new DailiFragment());
        fragmentList.add(new FeidailiFragment());

        viewpage.setAdapter(new TabAdapter(getActivity().getSupportFragmentManager(), titleList, fragmentList));
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
                    toClass(getActivity(), DailiFilterActivity.class);
                }
                if (tabPosition == 1) {
                    //筛选非直属代理
                    toClass(getActivity(), FeiDailiFilterActivity.class);
                }
                break;
            case R.id.bt_add:
                toClass(getActivity(), AddAgencyActivity.class);
                break;
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
