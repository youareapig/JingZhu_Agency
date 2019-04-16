package com.xiaomai.ageny.shanghudevice.fragment.offdevice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.details.shanghudevicedetails.ShanghuDeviceDetailsActivity;
import com.xiaomai.ageny.shanghudevice.fragment.offdevice.contract.OffDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.offdevice.presenter.OffDevicePresenter;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class OffDeviceFragment extends BaseMvpFragment<OffDevicePresenter> implements OffDeviceContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private List<ContactDeviceListBean.DataBean.ListBean> list;
    private Adapter adapter;
    private String id;

    public OffDeviceFragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        mPresenter=new OffDevicePresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id,"0","","");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.offdevice_fragment;
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

    @Override
    public void onSuccess(ContactDeviceListBean bean) {
        list=bean.getData().getList();
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(9));
//        adapter=new Adapter(R.layout.shanghudevice_off_item,list);
//        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(),ShanghuDeviceDetailsActivity.class);
            }
        });
    }
}
