package com.xiaomai.ageny.device_manage.device_allot.device_allot_agency;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_allot.DeviceAllotSuccessActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.contract.DeviceAllotAgencyContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.presenter.DeviceAllotAgencyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotAgencyActivity extends BaseMvpActivity<DeviceAllotAgencyPresenter> implements DeviceAllotAgencyContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.bt_sure_allot)
    TextView btSureAllot;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_allot_agency;
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

    @OnClick({R.id.back, R.id.bt_sure_allot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_sure_allot:
                toClass1(this, DeviceAllotSuccessActivity.class);
                break;
        }
    }
}
