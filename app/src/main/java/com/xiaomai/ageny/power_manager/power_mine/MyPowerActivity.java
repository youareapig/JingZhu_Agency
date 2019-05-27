package com.xiaomai.ageny.power_manager.power_mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.MyPowerListBean;
import com.xiaomai.ageny.filter.mypower_filter.MyPowerFilterActivity;
import com.xiaomai.ageny.power_manager.power_mine.contract.MyPowerContract;
import com.xiaomai.ageny.power_manager.power_mine.presenter.MyPowerPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.SpacesItemDecoration;
import com.xiaomai.ageny.utils.SpacesItemDecoration_left;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyPowerActivity extends BaseMvpActivity<MyPowerPresenter> implements MyPowerContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    private List<MyPowerListBean.DataBean.ListBean> list=new ArrayList<>();
    private Adapter adapter;
    private String powerId;
    private Bundle bundle=new Bundle();
    private int page=1;
    @Override
    public int getLayoutId() {
        return R.layout.activity_my_power;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mPresenter = new MyPowerPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(powerId,"1",App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(powerId,"1",App.pageSize);
            }
        });
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page=1;
                mPresenter.getDataFresh(powerId,"1",App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getDataLoadMore(powerId,page+"",App.pageSize);
            }
        });
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
        Logger.d("throwable---"+throwable.getMessage());
        refresh.finishRefresh();
        refresh.finishLoadMore();
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(MyPowerListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(MyPowerListBean bean) {
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
        }else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessFresh(MyPowerListBean bean) {
        refresh.finishRefresh();
        initData(bean);
    }

    private void initData(MyPowerListBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
                refresh.setCanLoadMore(false);
            }else {
                refresh.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.mypower_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
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
                bundle.putString("powerid",powerId);
                toClass1(this, MyPowerFilterActivity.class,bundle,1);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            page=1;
            powerId = data.getStringExtra("powerid");
            mPresenter.getData(powerId,"1",App.pageSize);
        }
    }
}
