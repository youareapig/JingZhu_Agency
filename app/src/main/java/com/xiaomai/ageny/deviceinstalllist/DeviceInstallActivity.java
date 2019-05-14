package com.xiaomai.ageny.deviceinstalllist;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.DeviceInstallListBean;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.deploy.DeployActivity;
import com.xiaomai.ageny.deploy.DeployZxingActivity;
import com.xiaomai.ageny.deviceinstalllist.adapter.Adapter;
import com.xiaomai.ageny.deviceinstalllist.contract.DeviceInstallContract;
import com.xiaomai.ageny.deviceinstalllist.presenter.DeviceInstallPresenter;
import com.xiaomai.ageny.filter.deviceinstall.DeviceInstallFilterActivity;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

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
    private String role;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_install;
    }

    @Override
    public void initView() {
        role = SharedPreferencesUtil.getInstance(this).getSP("role");

        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new DeviceInstallPresenter();
        mPresenter.attachView(this);
        if (!TextUtils.isEmpty(role)) {
            if (role.equals("1")) {
                //代理
                btInstall.setVisibility(View.VISIBLE);
                btStaff.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);
            } else {
                //员工
                btInstall.setVisibility(View.GONE);
                btStaff.setVisibility(View.VISIBLE);
                mPresenter.getConfigBean();
                back.setVisibility(View.GONE);
            }
        }
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
                mPresenter.getDeviceInstallListBean_Refresh(strChiyourenTel, strAnzhuangrenTel, strTime);
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
        refresh.finishRefresh();
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(DeviceInstallListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess_Refresh(DeviceInstallListBean bean) {
        refresh.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccess(LoginOutBean bean) {
        if (bean.getCode() == 1) {
            SharedPreferencesUtil.getInstance(this).putSP("token", "");
            toClass_Empty(this, LoginActivity.class);
            finish();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast("注销失败");
        }

    }

    @Override
    public void onSuccess(ConfigBean bean) {
        if (bean.getCode() == 1) {
            Gson gson = new Gson();
            String jsonConfig = gson.toJson(bean);
            SharedPreferencesUtil.getInstance(this).putSP("config", jsonConfig);
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
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
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
                MPermissions.requestPermissions(this, 1, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_bushu:
                MPermissions.requestPermissions(this, 15, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_loginout:
                //退出登录
                mPresenter.loginOut();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(1)
    public void requestCameraSuccess() {
        goCamera();
    }

    @PermissionGrant(15)
    public void requestCameraSuccess15() {
        goCamera();
    }

    //打开相机，二维码
    private void goCamera() {
        Intent intent = new Intent(this, DeployZxingActivity.class);
        startActivityForResult(intent, 5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strChiyourenTel = data.getStringExtra("chiyou");
            strAnzhuangrenTel = data.getStringExtra("anzhuang");
            strTime = data.getStringExtra("time");
        } else if (requestCode == 5) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    try {
                        String headurl = BaseUtils.subFrontString(result, "=");
                        String shadurl = BaseUtils.subBehindString(result, "=");

                        Logger.d("解析成功结果:" + result);
                        Logger.d("头---" + headurl + "尾---" + shadurl);
                        if (headurl.equals(App.ZxingBaseUrl)) {
                            bundle.putString("deviceId", shadurl);
                            toClass(this, DeployActivity.class, bundle);
                        } else {
                            ToastUtil.showShortToast("请扫描正确二维码");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtil.showShortToast("请扫描正确二维码");
                    }

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Logger.d("解析失败");
                }
            }
        }
    }


}
