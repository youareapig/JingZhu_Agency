package com.xiaomai.ageny.unbundle;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.details.contactdetails.ContactDetailsActivity;
import com.xiaomai.ageny.details.shanghudevicedetails.ShanghuDeviceDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnbundleSuccessActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_back_index)
    TextView btBackIndex;
    private int unbundletype;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbundle_success;
    }

    @Override
    public void initView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            //unbundletype 1，商户解绑成功  2,设备解绑成功
            unbundletype = bundle.getInt("unbundletype");
            if (unbundletype == 1) {
                btBackIndex.setText("返回商户列表");
            }
            if (unbundletype == 2) {
                btBackIndex.setText("返回设备列表");
            }
        }
    }

    @OnClick({R.id.back, R.id.bt_back_index})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                if (unbundletype == 1) {
                    finish();
                    if (ContactDetailsActivity.instance != null) {
                        ContactDetailsActivity.instance.finish();
                    }
                }
                if (unbundletype == 2) {
                    finish();
                    //销毁商户设备详情界面
                    if (ShanghuDeviceDetailsActivity.instance != null) {
                        ShanghuDeviceDetailsActivity.instance.finish();
                    }
                }
                break;
            case R.id.bt_back_index:
                if (unbundletype == 1) {
                    finish();
                    if (ContactDetailsActivity.instance != null) {
                        ContactDetailsActivity.instance.finish();
                    }
                }
                if (unbundletype == 2) {
                    finish();
                    //销毁商户设备详情界面
                    if (ShanghuDeviceDetailsActivity.instance != null) {
                        ShanghuDeviceDetailsActivity.instance.finish();
                    }
                }
                break;
        }
    }
}
