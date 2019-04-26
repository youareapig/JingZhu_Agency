package com.xiaomai.ageny.device_manage.device_alloted;

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
import com.xiaomai.ageny.bean.AllotDeviceBean;
import com.xiaomai.ageny.device_manage.device_alloted.contract.DeviceAllotedContract;
import com.xiaomai.ageny.device_manage.device_alloted.presenter.DeviceAllotedPresenter;
import com.xiaomai.ageny.filter.device_alloted_filter.DeviceAllotedFilterActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotedActivity extends BaseMvpActivity<DeviceAllotedPresenter> implements DeviceAllotedContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
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

    private List<AllotDeviceBean.DataBean> list;
    private Adapter adapter;
    private String strAll, strAllot, strNoallot;
    private String strTel, strId;
    private Bundle mBundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_alloted;
    }

    @Override
    public void initView() {
        mBundle = new Bundle();
        strAll = SharedPreferencesUtil.getInstance(this).getSP("all");
        strAllot = SharedPreferencesUtil.getInstance(this).getSP("fenpei");
        strNoallot =SharedPreferencesUtil.getInstance(this).getSP("weifenpei");
        deviceAllNum.setText(strAll);
        deviceAllot.setText(strAllot);
        deviceNoallot.setText(strNoallot);

        OtherViewHolder holder = new OtherViewHolder(this);
        otherview.setHolder(mHolder);
        otherview1.setHolder(holder);
        mPresenter = new DeviceAllotedPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strId, strTel);
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getDataFresh(strId, strTel);
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
    protected void onStart() {
        super.onStart();
        mPresenter.getData(strId, strTel);
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
    }

    @Override
    public void onSuccess(AllotDeviceBean bean) {
        initData(bean);

    }

    @Override
    public void onSuccessFresh(AllotDeviceBean bean) {
        initData(bean);
    }

    private void initData(AllotDeviceBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherview1.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.device_alloted_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
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
                mBundle.putString("tel", strTel);
                mBundle.putString("id", strId);
                toClass(this, DeviceAllotedFilterActivity.class, mBundle, 1);
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strId = data.getStringExtra("id");
            strTel = data.getStringExtra("tel");
        }
    }
}
