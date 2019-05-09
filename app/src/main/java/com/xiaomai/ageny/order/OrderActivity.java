package com.xiaomai.ageny.order;

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
import com.xiaomai.ageny.filter.directfilter.DirectFilterActivity;
import com.xiaomai.ageny.filter.indirectfilter.IndirectFilterActivity;
import com.xiaomai.ageny.filter.lowerorderfilter.LowerOrderFilterActivity;
import com.xiaomai.ageny.filter.myorderfilter.MyOrderFilterActivity;
import com.xiaomai.ageny.offline.fragment.direct.DirectFragment;
import com.xiaomai.ageny.offline.fragment.indirect.IndirectFragment;
import com.xiaomai.ageny.order.contract.OrderContract;
import com.xiaomai.ageny.order.fragment.lowerorder.LowerOrderFragment;
import com.xiaomai.ageny.order.fragment.myorder.MyOderFragment;
import com.xiaomai.ageny.order.presenter.OrderPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseMvpActivity<OrderPresenter> implements OrderContract.View {


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
        return R.layout.activity_order;
    }

    @Override
    public void initView() {
        titleList = new ArrayList<>();
        titleList.add("我的订单");
        titleList.add("下级订单");
        fragmentList = new ArrayList<>();
        fragmentList.add(new MyOderFragment());
        fragmentList.add(new LowerOrderFragment());

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
                    toClass(this, MyOrderFilterActivity.class);
                }
                if (tabPosition == 1) {
                    toClass(this, LowerOrderFilterActivity.class);
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtil.getInstance(this).putSP("myorder_id", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_name", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_star", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_end", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_id", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_tel", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_days", "");
    }
}
