package com.xiaomai.ageny.device_manage.device_noallot;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.NoAllotDeviceBean;
import com.xiaomai.ageny.device_manage.device_noallot.contract.DeviceNoAllotContract;
import com.xiaomai.ageny.device_manage.device_noallot.presenter.DeviceNoAllotPresenter;
import com.xiaomai.ageny.filter.device_noallot_filter.DeviceNoAllotFilterActivity;
import com.xiaomai.ageny.utils.DateUtils;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceNoAllotActivity extends BaseMvpActivity<DeviceNoAllotPresenter> implements DeviceNoAllotContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.device_all_num)
    TextView deviceAllNum;
    @BindView(R.id.device_noallot)
    TextView deviceNoallot;
    @BindView(R.id.device_allot)
    TextView deviceAllot;
    @BindView(R.id.otherview1)
    OtherView otherview1;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private List<NoAllotDeviceBean.DataBean> list;
    private Adapter adapter;
    private String strAll, strAllot, strNoallot;
    private String strId;
    private Bundle mBundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_no_allot;
    }

    @Override
    public void initView() {
        mBundle = new Bundle();
        Bundle bundle = getIntent().getExtras();
        strAll = bundle.getString("all");
        strAllot = bundle.getString("allot");
        strNoallot = bundle.getString("noallot");
        deviceAllNum.setText(strAll);
        deviceAllot.setText(strAllot);
        deviceNoallot.setText(strNoallot);

        OtherViewHolder holder = new OtherViewHolder(this);
        otherview.setHolder(mHolder);
        otherview1.setHolder(holder);
        mPresenter = new DeviceNoAllotPresenter();
        mPresenter.attachView(this);

        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strId);
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getDataFresh(strId);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData(strId);
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
        refreshLayout.finishRefresh();
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(NoAllotDeviceBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(NoAllotDeviceBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    private void initData(NoAllotDeviceBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherview1.showEmptyView();
            } else {
                otherview1.showContentView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.device_no_allot_item, list);
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
                mBundle.putString("id", strId);
                toClass(this, DeviceNoAllotFilterActivity.class, mBundle, 1);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strId = data.getStringExtra("id");
        }
    }

}
