package com.xiaomai.ageny.shop_manage.fragment.record;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.details.record_details.RecordDetailsActivity;
import com.xiaomai.ageny.shop_manage.fragment.record.contract.RecordContract;
import com.xiaomai.ageny.shop_manage.fragment.record.presenter.RecordPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Record_Fragment extends BaseMvpFragment<RecordPresenter> implements RecordContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        list.add("2018-12-25 14:17");
        list.add("2018-12-25 14:17");
        list.add("2018-12-25 14:17");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.record_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(),RecordDetailsActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.record_fragment;
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
