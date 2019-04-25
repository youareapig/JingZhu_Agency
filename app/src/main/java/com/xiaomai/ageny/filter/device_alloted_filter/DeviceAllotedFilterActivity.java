package com.xiaomai.ageny.filter.device_alloted_filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.device_alloted_filter.contract.DeviceAllotedFilterContract;
import com.xiaomai.ageny.filter.device_alloted_filter.presenter.DeviceAllotedFilterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotedFilterActivity extends BaseMvpActivity<DeviceAllotedFilterPresenter> implements DeviceAllotedFilterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.id)
    EditText id;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private String strTel, strId;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_alloted_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strTel = bundle.getString("tel");
        strId = bundle.getString("id");
        tel.setText(strTel);
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
                tel.setText("");
                break;
            case R.id.filter_bt_submit:
                strId = id.getText().toString().trim();
                strTel = tel.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("id", strId);
                intent.putExtra("tel", strTel);
                setResult(2, intent);
                finish();
                break;
        }
    }
}
