package com.xiaomai.ageny.filter.device_alloted_filter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.device_alloted_filter.contract.DeviceAllotedFilterContract;
import com.xiaomai.ageny.filter.device_alloted_filter.presenter.DeviceAllotedFilterPresenter;

public class DeviceAllotedFilterActivity extends BaseMvpActivity<DeviceAllotedFilterPresenter> implements DeviceAllotedFilterContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_device_alloted_filter;
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
