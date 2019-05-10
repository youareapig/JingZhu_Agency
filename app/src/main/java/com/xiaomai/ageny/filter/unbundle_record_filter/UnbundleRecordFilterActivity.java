package com.xiaomai.ageny.filter.unbundle_record_filter;

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

public class UnbundleRecordFilterActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private String strName, strTel;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbundle_record_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strName = bundle.getString("name");
        strTel = bundle.getString("tel");
        name.setText(strName);
        tel.setText(strTel);
    }


    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                name.setText("");
                tel.setText("");
                break;
            case R.id.filter_bt_submit:
                strName = name.getText().toString().trim();
                strTel = tel.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("name", strName);
                intent.putExtra("tel", strTel);
                setResult(2, intent);
                finish();
                break;
        }
    }
}
