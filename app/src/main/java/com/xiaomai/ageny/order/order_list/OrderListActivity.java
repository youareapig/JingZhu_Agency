package com.xiaomai.ageny.order.order_list;

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
import com.xiaomai.ageny.bean.OrderListBean;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.LowerOrderDetailsActivity;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.MyOrderDetailsActivity;
import com.xiaomai.ageny.filter.lowerorderfilter.LowerOrderFilterActivity;
import com.xiaomai.ageny.filter.myorderfilter.MyOrderFilterActivity;
import com.xiaomai.ageny.order.order_list.contract.OrderListContract;
import com.xiaomai.ageny.order.order_list.presenter.OrderListPresenter;
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

public class OrderListActivity extends BaseMvpActivity<OrderListPresenter> implements OrderListContract.View {

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
    OtherView otherview;
    private String agentId;
    private List<OrderListBean.DataBean.ListBean> list = new ArrayList<>();
    private Adapter adapter;
    private int page = 1;
    private String strId, strName, strStar, strEnd;
    private Bundle bundle=new Bundle();

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        agentId = getIntent().getExtras().getString("id");
        mPresenter = new OrderListPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(agentId, "1", App.pageSize, strId, strName, strStar, strEnd,"0");
            }
        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                mPresenter.getRefrshFresh(agentId, "1", App.pageSize, strId, strName, strStar, strEnd,"0");
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getLoadMore(agentId, page + "", App.pageSize, strId, strName, strStar, strEnd,"0");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        strId = SharedPreferencesUtil.getInstance(this).getSP("lowerorder_id");
        strName = SharedPreferencesUtil.getInstance(this).getSP("lowerorder_name");
        strStar = SharedPreferencesUtil.getInstance(this).getSP("lowerorder_star");
        strEnd = SharedPreferencesUtil.getInstance(this).getSP("lowerorder_end");
        mPresenter.getData(agentId, "1", App.pageSize, strId, strName, strStar, strEnd,"0");
    }

    @Override
    public void showLoading() {
        otherview.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherview.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        otherview.showRetryView();
        refresh.finishRefresh();
        refresh.finishLoadMore();
    }

    @Override
    public void onSuccess(OrderListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(OrderListBean bean) {
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
    public void onSuccessFresh(OrderListBean bean) {
        refresh.finishRefresh();
        initData(bean);
    }

    private void initData(OrderListBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            orderTotleMoney.setText(bean.getData().getCountRentPrice());
            earn.setText(bean.getData().getCountEarn());
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
                refresh.setCanLoadMore(false);
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.order_item, list);
            recycler.setAdapter(adapter);
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getOrderid());
                    bundle.putString("agenid", agentId);
                    toClass(view.getContext(), LowerOrderDetailsActivity.class, bundle);
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.back, R.id.bt_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, LowerOrderFilterActivity.class);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_days", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_id", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_name", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_star", "");
        SharedPreferencesUtil.getInstance(this).putSP("lowerorder_end", "");
    }
}
