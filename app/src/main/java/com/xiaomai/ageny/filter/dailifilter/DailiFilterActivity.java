package com.xiaomai.ageny.filter.dailifilter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.dailifilter.contract.DailiFilterContract;
import com.xiaomai.ageny.filter.dailifilter.presenter.DailiFilterPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DailiFilterActivity extends BaseMvpActivity<DailiFilterPresenter> implements DailiFilterContract.View {


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

    @Override
    public int getLayoutId() {
        return R.layout.activity_daili_filter;
    }

    @Override
    public void initView() {
        strTel = SharedPreferencesUtil.getInstance(this).getSP("feizhishuTel");
        strId = SharedPreferencesUtil.getInstance(this).getSP("feizhishuId");
        Logger.d("筛选取出：" + strTel + "   " + strId);
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
                tel.setText("");
                id.setText("");
                break;
            case R.id.filter_bt_submit:
                strTel = tel.getText().toString().trim();
                strId = id.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("feizhishuTel", strTel);
                SharedPreferencesUtil.getInstance(this).putSP("feizhishuId", strId);
                finish();
                break;
        }
    }
}
