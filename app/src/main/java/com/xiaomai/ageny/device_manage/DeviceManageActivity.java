package com.xiaomai.ageny.device_manage;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;

import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.contract.DeviceManageContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.device_manage.device_allot.DeviceAllotZxingActivity;
import com.xiaomai.ageny.device_manage.device_alloted.DeviceAllotedActivity;
import com.xiaomai.ageny.device_manage.device_freeze.DeviceFreezeActivity;
import com.xiaomai.ageny.device_manage.device_noallot.DeviceNoAllotActivity;
import com.xiaomai.ageny.device_manage.device_withdraw.DeviceWithDrawListActivity;
import com.xiaomai.ageny.device_manage.device_withdraw.DeviceWithdrawActivity;
import com.xiaomai.ageny.device_manage.presenter.DeviceManagePresenter;
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

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_manage;
    }

    @Override
    public void initView() {

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


    @OnClick({R.id.back, R.id.bt_device_withdraw, R.id.bt_device_allot, R.id.bt_device_freeze, R.id.bt_device_noallot, R.id.bt_device_alloted})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
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
                toClass(this, DeviceNoAllotActivity.class);
                break;
            case R.id.bt_device_alloted:
                //已分配
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
        Intent intent = new Intent(this, DeviceAllotZxingActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //撤回设备
        if (requestCode == 1) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    toClass(this, DeviceWithDrawListActivity.class);
                    Logger.d("解析成功结果:" + result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Logger.d("解析失败");
                }
            }
        }
        if (requestCode == 2) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                //分配设备
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    toClass(this, DeviceAllotListActivity.class);
                    Logger.d("解析成功结果:" + result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Logger.d("解析失败");
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
