package com.xiaomai.ageny.details.devcie_freeze_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.devcie_freeze_details.contract.DeviceFreezeDetailsContract;
import com.xiaomai.ageny.details.devcie_freeze_details.presenter.DeviceFreezeDetailsPresenter;

public class DeviceFreezDetailsActivity extends BaseMvpActivity<DeviceFreezeDetailsPresenter> implements DeviceFreezeDetailsContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_freez_details;
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
