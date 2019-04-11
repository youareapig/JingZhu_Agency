package com.xiaomai.ageny.xiajishanghu.xiajishanghulist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.XiajiSHDeviceListActivity;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.contract.XiajiSHContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.presenter.XiajiSHPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaJiSH_ListActivity extends BaseMvpActivity<XiajiSHPresenter> implements XiajiSHContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;

    private List<String> list;
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xia_ji_sh__list;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("张三顶麻辣烫");
        list.add("张三顶麻辣烫");
        list.add("张三顶麻辣烫");
        adapter = new Adapter(R.layout.xiaji_item, list);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(), XiajiSHDeviceListActivity.class);
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


    @OnClick(R.id.back)
    public void onViewClicked() {
    }
}
