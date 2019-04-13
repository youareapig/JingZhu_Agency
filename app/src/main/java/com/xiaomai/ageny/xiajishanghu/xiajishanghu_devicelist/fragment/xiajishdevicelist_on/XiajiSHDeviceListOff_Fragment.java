package com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.utils.SpacesItemDecoration;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.contract.XIajiSHDeviceListOffContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.fragment.xiajishdevicelist_on.presenter.XIajiSHDeviceListOffPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class XiajiSHDeviceListOff_Fragment extends BaseMvpFragment<XIajiSHDeviceListOffPresenter> implements XIajiSHDeviceListOffContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        adapter = new Adapter(R.layout.xiajishdevice_off_item, list);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.xiajishdevicelistoff_fragment;
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
