package com.xiaomai.ageny.filter.shop_filter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopFilterActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.times)
    EditText times;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private String strTimes, strTel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_filter;
    }

    @Override
    public void initView() {
        strTimes = SharedPreferencesUtil.getInstance(this).getSP("shop_times");
        strTel = SharedPreferencesUtil.getInstance(this).getSP("shop_tel");
        times.setText(strTimes);
        tel.setText(strTel);
    }


    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                times.setText("");
                tel.setText("");
                break;
            case R.id.filter_bt_submit:
                strTimes = times.getText().toString().trim();
                strTel = tel.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("shop_times", strTimes);
                SharedPreferencesUtil.getInstance(this).putSP("shop_tel", strTel);
                finish();
                break;
        }
    }
}
