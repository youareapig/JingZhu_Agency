package com.xiaomai.ageny.filter.deviceinstall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.deviceinstalllist.DeviceInstallActivity;
import com.xiaomai.ageny.filter.deviceinstall.contract.DeviceInstallFilterContract;
import com.xiaomai.ageny.filter.deviceinstall.presenter.DeviceInstallFilterPresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceInstallFilterActivity extends BaseMvpActivity<DeviceInstallFilterPresenter> implements DeviceInstallFilterContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.filter_time)
    TextView filterTime;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    @BindView(R.id.chiyouren_tel)
    EditText chiyourenTel;
    @BindView(R.id.anzhuangren_tel)
    EditText anzhuangrenTel;

    private String strChiyourenTel, strAnzhuangrenTel, strTime;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_install_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strChiyourenTel = bundle.getString("chiyou");
        strAnzhuangrenTel = bundle.getString("anzhuang");
        strTime = bundle.getString("time");
        anzhuangrenTel.setText(strAnzhuangrenTel);
        chiyourenTel.setText(strChiyourenTel);
        filterTime.setText(strTime);
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


    @OnClick({R.id.back, R.id.filter_time, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_time:
                BaseUtils.hideInput(this);
                TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        filterTime.setText(DateUtils.getTodayDateTime(date));
                    }
                }).build();
                pvTime.show();
                break;
            case R.id.filter_bt_reset:
                chiyourenTel.setText("");
                anzhuangrenTel.setText("");
                filterTime.setText("");
                break;
            case R.id.filter_bt_submit:
                strChiyourenTel = chiyourenTel.getText().toString().trim();
                strAnzhuangrenTel = anzhuangrenTel.getText().toString().trim();
                strTime = filterTime.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("chiyou", strChiyourenTel);
                intent.putExtra("anzhuang", strAnzhuangrenTel);
                intent.putExtra("time", strTime);
                setResult(2, intent);
                finish();
                break;
        }
    }

}
