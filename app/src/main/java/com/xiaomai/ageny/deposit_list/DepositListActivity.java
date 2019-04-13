package com.xiaomai.ageny.deposit_list;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.deposit_list.contract.DepositListContract;
import com.xiaomai.ageny.deposit_list.presenter.DepositListPresenter;
import com.xiaomai.ageny.filter.deposit_list_filter.DepositListFilterActivity;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DepositListActivity extends BaseMvpActivity<DepositListPresenter> implements DepositListContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private Adapter adapter;
    private List<String> list;
    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit_list;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("956");
        list.add("9527");
        list.add("9527");
        list.add("9527");
        list.add("9527");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.deposit_list_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
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
                toClass(this,DepositListFilterActivity.class);
                break;
        }
    }
}
