package com.xiaomai.ageny.shanghudevice.fragment.ondevice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ContactDeviceListBean;
import com.xiaomai.ageny.details.shanghudevicedetails.ShanghuDeviceDetailsActivity;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.contract.OnDeviceContract;
import com.xiaomai.ageny.shanghudevice.fragment.ondevice.presenter.OnDevicePresenter;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class OnDeviecFragment extends BaseMvpFragment<OnDevicePresenter> implements OnDeviceContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private List<ContactDeviceListBean.DataBean.ListBean> list;
    private Adapter adapter;
    private String id;
    private Bundle bundle;
    public OnDeviecFragment(String id) {
        this.id = id;
    }

    @Override
    protected void initView(View view) {
        bundle=new Bundle();
        mPresenter = new OnDevicePresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id, "1", "", "");
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
        Logger.d("错误");
    }

    @Override
    public void onSuccess(ContactDeviceListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.addItemDecoration(new SpacesItemDecoration(9));
            adapter = new Adapter(R.layout.shanghudevice_on_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id",list.get(position).getId());
                    toClass(view.getContext(), ShanghuDeviceDetailsActivity.class,bundle);
                }
            });
        }

    }

}
