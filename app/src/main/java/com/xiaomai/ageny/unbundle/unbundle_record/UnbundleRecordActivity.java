package com.xiaomai.ageny.unbundle.unbundle_record;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.unbundle_record_filter.UnbundleRecordFilterActivity;
import com.xiaomai.ageny.unbundle.unbundle_record.contract.UnbundleRecordContract;
import com.xiaomai.ageny.unbundle.unbundle_record.presenter.UnbundleRecordPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnbundleRecordActivity extends BaseMvpActivity<UnbundleRecordPresenter> implements UnbundleRecordContract.View {


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
        return R.layout.activity_unbundle_record;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("商户名称：兵哥豌豆面（武侯店）");
        list.add("商户名称：兵哥豌豆面（武侯店）");
        list.add("商户名称：兵哥豌豆面（武侯店）");
        list.add("商户名称：兵哥豌豆面（武侯店）");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.unbundle_record_item, list);
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
                toClass1(this, UnbundleRecordFilterActivity.class);
                break;
        }
    }
}
