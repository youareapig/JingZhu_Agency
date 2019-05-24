package com.xiaomai.ageny.order.fragment.myorder;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.MyOrderDetailsActivity;
import com.xiaomai.ageny.filter.myorderfilter.MyOrderFilterActivity;
import com.xiaomai.ageny.order.fragment.myorder.contract.MyOrderContract;
import com.xiaomai.ageny.order.fragment.myorder.presenter.MyOrderPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyOderActivity extends BaseMvpActivity<MyOrderPresenter> implements MyOrderContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.orderTotleMoney)
    TextView orderTotleMoney;
    @BindView(R.id.earn)
    TextView earn;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    @BindView(R.id.otherview)
    OtherView otherView;
    private List<MyOrderBean.DataBean.ListBean> list = new ArrayList<>();
    private Adapter adapter;
    private Bundle bundle;
    private int page = 1;
    private String strId, strName, strStar, strEnd;

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new MyOrderPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(strId, strName, strStar, strEnd, "1", App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strId, strName, strStar, strEnd, "1", App.pageSize);
            }
        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                mPresenter.getRefrshFresh(strId, strName, strStar, strEnd, "1", App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getLoadMore(strId, strName, strStar, strEnd, page + "", App.pageSize);
            }
        });
    }


    @Override
    public int getLayoutId() {
        return R.layout.myorder_fragment;
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
        refresh.finishRefresh();
        refresh.finishLoadMore();
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(MyOrderBean bean) {
        initData(bean);
    }

    private void initData(MyOrderBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            orderTotleMoney.setText(bean.getData().getCountRentPrice());
            earn.setText(bean.getData().getCountEarn());
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherView.showEmptyView();
                refresh.setCanLoadMore(false);
            } else {
                refresh.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.order_item, list);
            recycler.setAdapter(adapter);

            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getOrderid());
                    toClass(view.getContext(), MyOrderDetailsActivity.class, bundle);
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessLoadMore(MyOrderBean bean) {
        refresh.finishLoadMore();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            //延迟更新数据，避免卡顿
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
                }
            }, 500);
            if (bean.getData().getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessFresh(MyOrderBean bean) {
        refresh.finishRefresh();
        initData(bean);
    }


    @OnClick({R.id.back, R.id.bt_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, MyOrderFilterActivity.class, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            page = 1;
            strId = SharedPreferencesUtil.getInstance(this).getSP("myorder_id");
            strName = SharedPreferencesUtil.getInstance(this).getSP("myorder_name");
            strStar = SharedPreferencesUtil.getInstance(this).getSP("myorder_star");
            strEnd = SharedPreferencesUtil.getInstance(this).getSP("myorder_end");
            mPresenter.getData(strId, strName, strStar, strEnd, "1", App.pageSize);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtil.getInstance(this).putSP("myorder_id", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_name", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_star", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_end", "");
        SharedPreferencesUtil.getInstance(this).putSP("myorder_days", "");
    }
}
