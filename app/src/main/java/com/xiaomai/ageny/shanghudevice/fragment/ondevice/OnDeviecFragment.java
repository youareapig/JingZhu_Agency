package com.xiaomai.ageny.shanghudevice.fragment.ondevice;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.details.shanghudevicedetails.ShanghuDeviceDetailsActivity;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.contract.OnDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.presenter.OnDevicePresenter;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class OnDeviecFragment extends BaseMvpFragment<OnDevicePresenter> implements OnDeviceContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private List<String> list;
    private Adapter adapter;
    @Override
    protected void initView(View view) {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(9));
        list=new ArrayList<>();
        list.add("20058.3");
        list.add("20058.3");
        list.add("20058.3");
        list.add("20058.3");
        list.add("20058.3");
        adapter=new Adapter(R.layout.shanghudevice_on_item,list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(),ShanghuDeviceDetailsActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.ondevice_fragment;
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
