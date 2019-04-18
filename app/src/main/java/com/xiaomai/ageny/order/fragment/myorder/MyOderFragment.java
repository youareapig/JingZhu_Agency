package com.xiaomai.ageny.order.fragment.myorder;

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
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.MyOrderDetailsActivity;
import com.xiaomai.ageny.order.fragment.myorder.contract.MyOrderContract;
import com.xiaomai.ageny.order.fragment.myorder.presenter.MyOrderPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyOderFragment extends BaseMvpFragment<MyOrderPresenter> implements MyOrderContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.orderTotleMoney)
    TextView orderTotleMoney;
    @BindView(R.id.earn)
    TextView earn;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    private List<MyOrderBean.DataBean.ListBean> list = new ArrayList<>();
    private Adapter adapter;
    private Bundle bundle;
    private int page = 1;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new MyOrderPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "", "1", App.pageSize);

        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (list!=null){
                            list.clear();
                        }
                        page=1;
                        mPresenter.getData("", "", "", "", "1", App.pageSize);
                        refresh.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        mPresenter.getRefrsh("", "", "", "", page + "", App.pageSize);
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });

    }

    @Override
    protected int getLayoutId() {
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

    }

    @Override
    public void onSuccess(MyOrderBean bean) {
        if (bean.getCode() == 1) {
            orderTotleMoney.setText(bean.getData().getCountRentPrice());
            earn.setText(bean.getData().getCountEarn());
            list.addAll(bean.getData().getList());
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
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
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @Override
    public void onFreshSuccess(MyOrderBean bean) {
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
            if (bean.getData().getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        }

    }

    @Override
    public void onFreshError(Throwable throwable) {

    }

}
