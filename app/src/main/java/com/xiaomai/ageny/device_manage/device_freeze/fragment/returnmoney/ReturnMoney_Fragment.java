package com.xiaomai.ageny.device_manage.device_freeze.fragment.returnmoney;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.details.devcie_freeze_details.DeviceFreezDetailsActivity;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.Adapter;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.returnmoney.contract.ReturnMoneyContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.returnmoney.presenter.ReturnMoneyPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ReturnMoney_Fragment extends BaseMvpFragment<ReturnMoneyPresenter> implements ReturnMoneyContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    private Adapter adapter;
    private List<FreezeBean.DataBean.ListBean> list;

    @Override
    protected void initView(View view) {
        mPresenter=new ReturnMoneyPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("3","","");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.returnmoney_fragment;
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
    public void onSuccess(FreezeBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.freeze_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    toClass(view.getContext(), DeviceFreezDetailsActivity.class);
                }
            });
        }

    }

}
