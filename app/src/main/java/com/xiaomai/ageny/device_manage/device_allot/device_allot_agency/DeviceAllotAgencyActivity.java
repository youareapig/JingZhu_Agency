package com.xiaomai.ageny.device_manage.device_allot.device_allot_agency;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.contract.DeviceAllotAgencyContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.presenter.DeviceAllotAgencyPresenter;

public class DeviceAllotAgencyActivity extends BaseMvpActivity<DeviceAllotAgencyPresenter> implements DeviceAllotAgencyContract.View {


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
}
