package com.xiaomai.ageny.power_manager.power_allot_next;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.power_manager.power_allot_next.contract.PowerAllotNextContract;
import com.xiaomai.ageny.power_manager.power_allot_next.presenter.PowerAllotNextPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerAllotNextActivity extends BaseMvpActivity<PowerAllotNextPresenter> implements PowerAllotNextContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.bt_sure_allot)
    TextView btSureAllot;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_allot_next;
    }

    @Override
    public void initView() {

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


    @OnClick({R.id.back, R.id.bt_sure_allot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_sure_allot:
                break;
        }
    }
}
