package com.xiaomai.ageny.mybill;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.mybill.contract.MyBillContract;
import com.xiaomai.ageny.mybill.presenter.MyBillPresenter;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBillActivity extends BaseMvpActivity<MyBillPresenter> implements MyBillContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.tv_tixian_money)
    TextView tvTixianMoney;
    @BindView(R.id.tv_tixian_dongjie)
    TextView tvTixianDongjie;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private Adapter adapter;
    private List<String> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("956");
        list.add("956");
        list.add("956");
        list.add("9527");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.mybill_item, list);
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


    @OnClick({R.id.back, R.id.recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.recycler:
                break;
        }
    }
}
