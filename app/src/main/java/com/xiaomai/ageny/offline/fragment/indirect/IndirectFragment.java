package com.xiaomai.ageny.offline.fragment.indirect;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.OffIndirectDeivceBean;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.offline.fragment.indirect.adapter.Adapter;
import com.xiaomai.ageny.offline.fragment.indirect.contract.IndirectContract;
import com.xiaomai.ageny.offline.fragment.indirect.presenter.IndirectPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

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
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private Adapter adapter;
    private List<OffIndirectDeivceBean.DataBean.ListBean> list;
    private String strTel = "", strID = "", strName = "";

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new IndirectPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strName, strTel, strID, "");
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getData_Fresh(strName, strTel, strID, "");
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        strTel = SharedPreferencesUtil.getInstance(getActivity()).getSP("offfeizhishuTel");
        strID = SharedPreferencesUtil.getInstance(getActivity()).getSP("offfeizhishuId");
        strName = SharedPreferencesUtil.getInstance(getActivity()).getSP("offfeizhishuName");
        mPresenter.getData(strName, strTel, strID, "");
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
        refreshLayout.finishRefresh();
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(OffIndirectDeivceBean bean) {
        initData(bean);

    }

    @Override
    public void onSuccess_Fresh(OffIndirectDeivceBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    private void initData(OffIndirectDeivceBean bean) {
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().get(0).getCountlinxianbox());
            list = bean.getData().get(0).getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.indirect_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

}
