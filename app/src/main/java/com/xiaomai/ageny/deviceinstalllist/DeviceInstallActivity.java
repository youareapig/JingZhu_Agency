package com.xiaomai.ageny.deviceinstalllist;

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
import com.xiaomai.ageny.deploy.DeployActivity;
import com.xiaomai.ageny.deviceinstalllist.adapter.Adapter;
import com.xiaomai.ageny.deviceinstalllist.contract.DeviceInstallContract;
import com.xiaomai.ageny.deviceinstalllist.presenter.DeviceInstallPresenter;
import com.xiaomai.ageny.filter.deviceinstall.DeviceInstallFilterActivity;

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

    private Adapter adapter;
    private List<DeviceInstallListBean.DataBean.ListBean> list;
    private String strChiyourenTel = "";
    private String strAnzhuangrenTel = "";
    private String strTime = "";
    private int page = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_install;
    }

    @Override
    public void initView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            strChiyourenTel = bundle.getString("cyren");
            strAnzhuangrenTel = bundle.getString("azren");
            strTime = bundle.getString("time");
        }
        Logger.d("参数" + strChiyourenTel + strAnzhuangrenTel + strTime);

        mPresenter = new DeviceInstallPresenter();
        mPresenter.attachView(this);
        mPresenter.getDeviceInstallListData(strChiyourenTel, strAnzhuangrenTel, strTime);

        //下拉上啦
        refresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page=1;
                        mPresenter.getDeviceInstallListBean_Refresh(page,strChiyourenTel, strAnzhuangrenTel, strTime);
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
                        mPresenter.getDeviceInstallListBean_Refresh(page,strChiyourenTel, strAnzhuangrenTel, strTime);
                        refresh.finishLoadMore();
                    }
                }, 1000);
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(DeviceInstallListBean bean) {
        list = bean.getData().getList();
        if (bean.getCode() == 1) {
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.device_install_item, list);
            recycler.setNestedScrollingEnabled(false);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        }
    }

    @Override
    public void onSuccess_Refresh(DeviceInstallListBean bean) {

    }


    @OnClick({R.id.back, R.id.bt_filter, R.id.bt_install})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, DeviceInstallFilterActivity.class);
                break;
            case R.id.bt_install:
                toClass(this, DeployActivity.class);
                break;
        }
    }

}
