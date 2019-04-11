package com.xiaomai.ageny.offline.fragment.direct;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.TestBean;
import com.xiaomai.ageny.offline.fragment.direct.adapter.Adapter;
import com.xiaomai.ageny.offline.fragment.direct.contract.DirectContract;
import com.xiaomai.ageny.offline.fragment.direct.presenter.DirectPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DirectFragment extends BaseMvpFragment<DirectPresenter> implements DirectContract.View {
    @BindView(R.id.offline_num)
    TextView offlineNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;

    private Adapter adapter;
    private List<String> list;
    @Override
    protected void initView(View view) {
        list=new ArrayList<>();
        list.add("第1家");
        list.add("第2家");
        list.add("第3家");
        list.add("第4家");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.direct_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.direct_fragment;
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
