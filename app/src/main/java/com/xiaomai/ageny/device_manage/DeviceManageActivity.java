package com.xiaomai.ageny.device_manage;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.DeviceManageBean;
import com.xiaomai.ageny.device_manage.contract.DeviceManageContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.DeviceAllotZxingActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.device_manage.device_alloted.DeviceAllotedActivity;
import com.xiaomai.ageny.device_manage.device_freeze.DeviceFreezeActivity;
import com.xiaomai.ageny.device_manage.device_noallot.DeviceNoAllotActivity;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.DeviceWithdrawActivity;
import com.xiaomai.ageny.device_manage.presenter.DeviceManagePresenter;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import butterknife.BindView;
import butterknife.OnClick;

public class DeviceManageActivity extends BaseMvpActivity<DeviceManagePresenter> implements DeviceManageContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_device_withdraw)
    RelativeLayout btDeviceWithdraw;
    @BindView(R.id.bt_device_allot)
    RelativeLayout btDeviceAllot;
    @BindView(R.id.bt_device_freeze)
    RelativeLayout btDeviceFreeze;
    @BindView(R.id.bt_device_noallot)
    RelativeLayout btDeviceNoallot;
    @BindView(R.id.bt_device_alloted)
    RelativeLayout btDeviceAlloted;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.device_all_num)
    TextView deviceAllNum;
    @BindView(R.id.device_nofreeze_num)
    TextView deviceNofreezeNum;
    @BindView(R.id.device_freeze_num)
    TextView deviceFreezeNum;
    private Bundle bundle;
    private String strAll, strAllot, strNoallot;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    public static DeviceManageActivity instance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_manage;
    }

    @Override
    public void initView() {
        instance = this;
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        mPresenter = new DeviceManagePresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData();
            }
        });
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
    protected void onStart() {
        super.onStart();
        mPresenter.getData();
        try {
            daoSession = DaoSessionManager.getInstace()
                    .getDaoSession(this);
            //查询所有数据
            deviceDaoDao = daoSession.getDeviceDaoDao();
            deviceDaoDao.deleteAll();
            Logger.d("清空数据");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.d("清空数据失败");
        }

    }

    @Override
    public void onSuccess(DeviceManageBean bean) {
        if (bean.getCode() == 1) {
            strAll = bean.getData().getCountBox();
            strAllot = bean.getData().getFenpeiBox();
            strNoallot = bean.getData().getWeifenpeiBox();
            deviceAllNum.setText(strAll);
            deviceNofreezeNum.setText(strNoallot);
            deviceFreezeNum.setText(strAllot);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_device_withdraw, R.id.bt_device_allot, R.id.bt_device_freeze, R.id.bt_device_noallot, R.id.bt_device_alloted})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_device_withdraw:
                //撤回
                MPermissions.requestPermissions(this, 2, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_device_allot:
                //分配
                MPermissions.requestPermissions(this, 3, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_device_freeze:
                //冻结
                toClass(this, DeviceFreezeActivity.class);
                break;
            case R.id.bt_device_noallot:
                //未分配
                bundle.putString("all", strAll);
                bundle.putString("allot", strAllot);
                bundle.putString("noallot", strNoallot);
                toClass(this, DeviceNoAllotActivity.class, bundle);
                break;
            case R.id.bt_device_alloted:
                //已分配
                bundle.putString("all", strAll);
                bundle.putString("allot", strAllot);
                bundle.putString("noallot", strNoallot);
                SharedPreferencesUtil.getInstance(this).putSP("all", strAll);
                SharedPreferencesUtil.getInstance(this).putSP("fenpei", strAllot);
                SharedPreferencesUtil.getInstance(this).putSP("weifenpei", strNoallot);
                toClass(this, DeviceAllotedActivity.class);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(2)
    public void requestCameraSuccess() {
        Intent intent = new Intent(this, DeviceWithdrawActivity.class);
        startActivityForResult(intent, 1);
    }

    @PermissionGrant(3)
    public void requestCameraSuccess_1() {
        Bundle mBundle = new Bundle();
        mBundle.putString("fromact", "1");
        toClass(this, DeviceAllotZxingActivity.class,mBundle);
    }


}
