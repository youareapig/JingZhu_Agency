package com.xiaomai.ageny.mybill;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.mybill.contract.MyBillContract;
import com.xiaomai.ageny.mybill.presenter.MyBillPresenter;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBillActivity extends BaseMvpActivity<MyBillPresenter> implements MyBillContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.tv_all_money)
    TextView tvAllMoney;
    @BindView(R.id.tv_order_money)
    TextView tvOrderMoney;
    @BindView(R.id.otherview)
    OtherView otherview;
    private Adapter adapter;
    private List<BillListBean.DataBean.ListBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData();
            }
        });
        mPresenter = new MyBillPresenter();
        mPresenter.attachView(this);
        mPresenter.getData();
    }

    @Override
    public void showLoading() {
        Logger.d("showLoading");
        otherview.showLoadingView();
    }

    @Override
    public void hideLoading() {
        Logger.d("hideLoading");
        otherview.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        Logger.d("onError");
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(BillListBean bean) {
        if (bean.getCode() == 1) {
            tvAllMoney.setText(bean.getData().getTotal_earn());
            tvOrderMoney.setText(bean.getData().getTotal_price());
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.mybill_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        }

    }


    @OnClick({R.id.back, R.id.recycler})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.recycler:
                break;
        }
    }

}
