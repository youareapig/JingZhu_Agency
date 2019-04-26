package com.xiaomai.ageny.device_manage.device_allot;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.device_manage.device_alloted.DeviceAllotedActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotSuccessActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_devicelist)
    TextView btDevicelist;
    @BindView(R.id.bt_devicemanage)
    TextView btDevicemanage;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_allot_success;
    }

    @Override
    public void initView() {

    }


    @OnClick({R.id.back, R.id.bt_devicelist, R.id.bt_devicemanage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                DeviceAllotListActivity.instance.finish();
                finish();
                break;
            case R.id.bt_devicelist:
                toClass(this, DeviceAllotedActivity.class);
                DeviceAllotListActivity.instance.finish();
                finish();
                break;
            case R.id.bt_devicemanage:
                DeviceAllotListActivity.instance.finish();
                finish();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //点击完返回键，执行的动作
            DeviceAllotListActivity.instance.finish();
            finish();
        }
        return true;
    }
}
