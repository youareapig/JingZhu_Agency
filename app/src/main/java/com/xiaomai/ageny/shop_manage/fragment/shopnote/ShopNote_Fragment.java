package com.xiaomai.ageny.shop_manage.fragment.shopnote;

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
import com.xiaomai.ageny.bean.ShopRecordBean;
import com.xiaomai.ageny.details.shop_note_details.ShopNoteDetailsActivity;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.contract.ShopNoteContract;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.presenter.ShopNotePresenter;
import com.xiaomai.ageny.shop_manage.goshop.GoShopActivity;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ShopNote_Fragment extends BaseMvpFragment<ShopNotePresenter> implements ShopNoteContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_shop)
    TextView btShop;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private List<ShopRecordBean.DataBean.ListBean> list;
    private Adapter adapter;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        mPresenter = new ShopNotePresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "");
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
    protected int getLayoutId() {
        return R.layout.shopnote_fragment;
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
    public void onSuccess(ShopRecordBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(ShopRecordBean bean) {
        initData(bean);
    }

    private void initData(ShopRecordBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.shop_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getReceiptId());
                    toClass(view.getContext(), ShopNoteDetailsActivity.class, bundle);
                }
            });
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick(R.id.bt_shop)
    public void onViewClicked() {
        toClass(getActivity(), GoShopActivity.class);
    }
}
