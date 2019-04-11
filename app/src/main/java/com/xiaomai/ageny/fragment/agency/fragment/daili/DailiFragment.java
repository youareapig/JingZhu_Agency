package com.xiaomai.ageny.fragment.agency.fragment.daili;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.details.dailidetails.DailiDetailsActivity;
import com.xiaomai.ageny.fragment.agency.fragment.daili.contract.DailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.presenter.DailiPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DailiFragment extends BaseMvpFragment<DailiPresenter> implements DailiContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private Adapter adapter;
    private List<String> list;

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.daili_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(),DailiDetailsActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.daili_fragment;
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
