package com.xiaomai.ageny.unbundle.unbundle_device;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.unbundle.UnbundleFaileActivity;
import com.xiaomai.ageny.unbundle.UnbundleSuccessActivity;
import com.xiaomai.ageny.unbundle.unbundle_device.contract.UnbundleDeviceContract;
import com.xiaomai.ageny.unbundle.unbundle_device.presenter.UnbundleDevicePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnbundleDeviceActivity extends BaseMvpActivity<UnbundleDevicePresenter> implements UnbundleDeviceContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_unbundle)
    TextView btUnbundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbundle_device;
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


    @OnClick({R.id.back, R.id.bt_unbundle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_unbundle:
                toClass1(this,UnbundleFaileActivity.class);
//                toClass1(this,UnbundleSuccessActivity.class);
                break;
        }
    }
}
