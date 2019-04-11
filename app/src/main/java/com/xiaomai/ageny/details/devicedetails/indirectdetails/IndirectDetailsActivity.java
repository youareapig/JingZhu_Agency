package com.xiaomai.ageny.details.devicedetails.indirectdetails;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.adapter.Adapter;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.contract.IndirectDetailsContract;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.presenter.IndirectDetailsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndirectDetailsActivity extends BaseMvpActivity<IndirectDetailsPresenter> implements IndirectDetailsContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private Adapter adapter;
    private List<String> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_indirect_details;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("旺财");
        list.add("旺旺");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        list.add("发财");
        recycler.setNestedScrollingEnabled(false);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.indirectdetails_item, list);
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

}
