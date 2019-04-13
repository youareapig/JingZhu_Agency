package com.xiaomai.ageny.filter.device_noallot_filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.device_noallot_filter.contract.DeviceNoAllotFilterContract;
import com.xiaomai.ageny.filter.device_noallot_filter.presenter.DeviceNoAllotFilterPresenter;

public class DeviceNoAllotFilterActivity extends BaseMvpActivity<DeviceNoAllotFilterPresenter> implements DeviceNoAllotFilterContract.View {



    @Override
    public int getLayoutId() {
        return R.layout.activity_device_no_allot_filter;
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
