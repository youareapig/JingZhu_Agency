package com.xiaomai.ageny.fragment.agency.fragment.feidaili;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.details.feidailidetails.FeiDailiDetailsActivity;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.contract.FeidailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.presenter.FeidailiPresenter;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FeidailiFragment extends BaseMvpFragment<FeidailiPresenter> implements FeidailiContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    private Adapter adapter;
    private List<DailiListBean.DataBean.ListBean> list;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new FeidailiPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "0", "");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.feidaili_fragment;
    }

    @Override
    public void showLoading() {
        otherView.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherView.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(DailiListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.feidaili_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getId());
                    toClass(view.getContext(), FeiDailiDetailsActivity.class, bundle);
                }
            });
        }
    }

}
