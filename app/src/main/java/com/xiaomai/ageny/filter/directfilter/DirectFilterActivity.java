package com.xiaomai.ageny.filter.directfilter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.directfilter.contract.DirectFilterContract;
import com.xiaomai.ageny.filter.directfilter.presenter.DirectFilterPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DirectFilterActivity extends BaseMvpActivity<DirectFilterPresenter> implements DirectFilterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.id)
    EditText id;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private String strTel = "", strID = "", strName = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_direct_filter;
    }

    @Override
    public void initView() {
        strTel = SharedPreferencesUtil.getInstance(this).getSP("offzhishuTel");
        strID = SharedPreferencesUtil.getInstance(this).getSP("offzhishuId");
        strName = SharedPreferencesUtil.getInstance(this).getSP("offzhishuName");

        name.setText(strName);
        tel.setText(strTel);
        id.setText(strID);
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
                name.setText("");
                tel.setText("");
                id.setText("");
                break;
            case R.id.filter_bt_submit:
                strID = id.getText().toString().trim();
                strName = name.getText().toString().trim();
                strTel = tel.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("offzhishuTel", strTel);
                SharedPreferencesUtil.getInstance(this).putSP("offzhishuId", strID);
                SharedPreferencesUtil.getInstance(this).putSP("offzhishuName", strName);
                finish();
                break;
        }
    }
}
