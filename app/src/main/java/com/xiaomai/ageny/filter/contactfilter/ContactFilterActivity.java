package com.xiaomai.ageny.filter.contactfilter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.contactfilter.contract.ContactFilterContract;
import com.xiaomai.ageny.filter.contactfilter.presenter.ContactFilterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactFilterActivity extends BaseMvpActivity<ContactFilterPresenter> implements ContactFilterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.filter_tel)
    EditText filterTel;
    @BindView(R.id.filter_id)
    EditText filterId;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;

    private String strTel, strID;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strTel = bundle.getString("tel");
        strID = bundle.getString("id");
        filterId.setText(strID);
        filterTel.setText(strTel);
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
                filterTel.setText("");
                filterId.setText("");
                break;
            case R.id.filter_bt_submit:
                strID = filterId.getText().toString().trim();
                strTel = filterTel.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("id", strID);
                intent.putExtra("tel", strTel);
                setResult(2, intent);
                finish();
                break;
        }
    }
}
