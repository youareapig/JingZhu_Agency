package com.xiaomai.ageny.shop_manage.fragment.record;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ShopApplyBean;
import com.xiaomai.ageny.details.record_details.RecordDetailsActivity;
import com.xiaomai.ageny.shop_manage.fragment.record.contract.RecordContract;
import com.xiaomai.ageny.shop_manage.fragment.record.presenter.RecordPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Record_Fragment extends BaseMvpFragment<RecordPresenter> implements RecordContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private List<ShopApplyBean.DataBean> list;
    private Adapter adapter;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        mPresenter = new RecordPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", "", "", "");
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getDataFresh("", "", "", "");
                        refreshLayout.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getData("", "", "", "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.record_fragment;
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
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(ShopApplyBean bean) {

        initData(bean);
    }

    @Override
    public void onSuccessFresh(ShopApplyBean bean) {
        initData(bean);
    }

    private void initData(ShopApplyBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.record_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getReceiptId());
                    toClass(view.getContext(), RecordDetailsActivity.class, bundle);
                }
            });
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

}
