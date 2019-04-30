package com.xiaomai.ageny.deviceinstalllist;

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
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.deploy.DeployActivity;
import com.xiaomai.ageny.deviceinstalllist.adapter.Adapter;
import com.xiaomai.ageny.deviceinstalllist.contract.DeviceInstallContract;
import com.xiaomai.ageny.deviceinstalllist.presenter.DeviceInstallPresenter;
import com.xiaomai.ageny.filter.deviceinstall.DeviceInstallFilterActivity;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceInstallActivity extends BaseMvpActivity<DeviceInstallPresenter> implements DeviceInstallContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_install)
    RelativeLayout btInstall;
    @BindView(R.id.refresh)
    PullToRefreshLayout refresh;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.bt_bushu)
    TextView btBushu;
    @BindView(R.id.bt_loginout)
    TextView btLoginout;
    @BindView(R.id.bt_staff)
    RelativeLayout btStaff;

    private Adapter adapter;
    private List<DeviceInstallListBean.DataBean.ListBean> list;
    private String strChiyourenTel = "";
    private String strAnzhuangrenTel = "";
    private String strTime = "";
    private Bundle bundle;
    private Bundle mBundle;
    private String role;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_install;
    }

    @Override
    public void initView() {
        mBundle = getIntent().getExtras();
        if (mBundle != null) {
            role = mBundle.getString("role");
            if (role.equals("1")) {
                //代理
                btInstall.setVisibility(View.VISIBLE);
                btStaff.setVisibility(View.GONE);
            } else {
                btInstall.setVisibility(View.GONE);
                btStaff.setVisibility(View.VISIBLE);
            }
        }
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new DeviceInstallPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getDeviceInstallListData(strChiyourenTel, strAnzhuangrenTel, strTime);
            }
        });
        //下拉上啦
        refresh.setCanLoadMore(false);
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getDeviceInstallListBean_Refresh(strChiyourenTel, strAnzhuangrenTel, strTime);
                        refresh.finishRefresh();
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
        mPresenter.getDeviceInstallListData(strChiyourenTel, strAnzhuangrenTel, strTime);

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
    public void onSuccess(DeviceInstallListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess_Refresh(DeviceInstallListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess(LoginOutBean bean) {
        if (bean.getCode() == 1) {
            SharedPreferencesUtil.getInstance(this).putSP("token", "");
            toClass_Empty(this, LoginActivity.class);
            finish();
        } else {
            ToastUtil.showShortToast("注销失败");
        }

    }

    private void initData(DeviceInstallListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.device_install_item, list);
            recycler.setNestedScrollingEnabled(false);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.back, R.id.bt_filter, R.id.bt_install, R.id.bt_bushu, R.id.bt_loginout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                bundle.putString("chiyou", strChiyourenTel);
                bundle.putString("anzhuang", strAnzhuangrenTel);
                bundle.putString("time", strTime);
                toClass(this, DeviceInstallFilterActivity.class, bundle, 1);
                break;
            case R.id.bt_install:
                toClass(this, DeployActivity.class);
                break;
            case R.id.bt_bushu:
                toClass(this, DeployActivity.class);
                break;
            case R.id.bt_loginout:
                //退出登录
                mPresenter.loginOut();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strChiyourenTel = data.getStringExtra("chiyou");
            strAnzhuangrenTel = data.getStringExtra("anzhuang");
            strTime = data.getStringExtra("time");
        }
    }


}
