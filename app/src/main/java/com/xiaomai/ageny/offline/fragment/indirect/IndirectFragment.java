package com.xiaomai.ageny.offline.fragment.indirect;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.offline.fragment.indirect.adapter.Adapter;
import com.xiaomai.ageny.offline.fragment.indirect.contract.IndirectContract;
import com.xiaomai.ageny.offline.fragment.indirect.presenter.IndirectPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndirectFragment extends BaseMvpFragment<IndirectPresenter> implements IndirectContract.View {


    @BindView(R.id.offline_num)
    TextView offlineNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    private Adapter adapter;
    private List<OffIndirectDeivceBean.DataBean.ListBean> list;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new IndirectPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.indirect_fragment;
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
    public void onSuccess(OffIndirectDeivceBean bean) {
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().get(0).getCountlinxianbox());
            list = bean.getData().get(0).getList();

            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.indirect_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


}
