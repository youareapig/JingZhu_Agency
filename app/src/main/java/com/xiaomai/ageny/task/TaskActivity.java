package com.xiaomai.ageny.task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.androidkun.xtablayout.XTabLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.TabAdapter;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.offline.fragment.direct.DirectFragment;
import com.xiaomai.ageny.offline.fragment.indirect.IndirectFragment;
import com.xiaomai.ageny.task.direct_task.TaskDirectFragment;
import com.xiaomai.ageny.task.indirect_task.TaskIndirectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TaskActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.xtab)
    XTabLayout xtab;
    @BindView(R.id.viewpage)
    ViewPager viewpage;
    private List<String> titleList;
    private List<Fragment> fragmentList;

    @Override
    public int getLayoutId() {
        return R.layout.activity_task;
    }

    @Override
    public void initView() {
        titleList = new ArrayList<>();
        titleList.add("直属设备");
        titleList.add("非直属设备");
        fragmentList = new ArrayList<>();
        fragmentList.add(new TaskDirectFragment());
        fragmentList.add(new TaskIndirectFragment());

        viewpage.setAdapter(new TabAdapter(getSupportFragmentManager(), titleList, fragmentList));
        viewpage.setOffscreenPageLimit(0);
        xtab.setupWithViewPager(viewpage);
        xtab.getTabAt(0).select();
        xtab.getTabAt(1).select();
        viewpage.setCurrentItem(0);
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
