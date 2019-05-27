package com.xiaomai.ageny.filter.indirectfilter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.indirectfilter.contract.IndirectFilterContract;
import com.xiaomai.ageny.filter.indirectfilter.presenter.IndirectFilterPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IndirectFilterActivity extends BaseMvpActivity<IndirectFilterPresenter> implements IndirectFilterContract.View {


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
        return R.layout.activity_indirect_filter2;
    }

    @Override
    public void initView() {
        strTel = SharedPreferencesUtil.getInstance(this).getSP("offfeizhishuTel");
        strID = SharedPreferencesUtil.getInstance(this).getSP("offfeizhishuId");
        strName = SharedPreferencesUtil.getInstance(this).getSP("offfeizhishuName");

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
                SharedPreferencesUtil.getInstance(this).putSP("offfeizhishuTel", strTel);
                SharedPreferencesUtil.getInstance(this).putSP("offfeizhishuId", strID);
                SharedPreferencesUtil.getInstance(this).putSP("offfeizhishuName", strName);
                Intent intent=new Intent();
                setResult(2, intent);
                finish();
                break;
        }
    }
}
