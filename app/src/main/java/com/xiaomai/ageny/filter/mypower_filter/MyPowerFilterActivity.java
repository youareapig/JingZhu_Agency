package com.xiaomai.ageny.filter.mypower_filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyPowerFilterActivity extends BaseActivity {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.powerid)
    EditText powerid;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private Bundle bundle;
    private String strPowerId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_power_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strPowerId = bundle.getString("powerid");
        powerid.setText(strPowerId);
    }


    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                powerid.setText("");
                break;
            case R.id.filter_bt_submit:
                strPowerId=powerid.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("powerid", strPowerId);
                setResult(2, intent);
                finish();
                break;
        }
    }
}
