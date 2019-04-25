package com.xiaomai.ageny.filter.device_noallot_filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.device_noallot_filter.contract.DeviceNoAllotFilterContract;
import com.xiaomai.ageny.filter.device_noallot_filter.presenter.DeviceNoAllotFilterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceNoAllotFilterActivity extends BaseMvpActivity<DeviceNoAllotFilterPresenter> implements DeviceNoAllotFilterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.id)
    EditText id;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private String strId;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_no_allot_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strId = bundle.getString("id");
        id.setText(strId);
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

    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                id.setText("");
                break;
            case R.id.filter_bt_submit:
                strId = id.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("id", strId);
                setResult(2, intent);
                finish();
                break;
        }
    }
}
