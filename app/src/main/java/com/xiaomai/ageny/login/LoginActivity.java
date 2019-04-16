package com.xiaomai.ageny.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xiaomai.ageny.MainActivity;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.login.contract.LoginContract;
import com.xiaomai.ageny.login.presenter.LoginPresenter;
import com.xiaomai.ageny.utils.CountDownTimerUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_index_tel)
    EditText etIndexTel;
    @BindView(R.id.et_index_code)
    EditText etIndexCode;
    @BindView(R.id.bt_index_getcode)
    TextView btIndexGetcode;
    @BindView(R.id.bt_login)
    TextView btLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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


    @OnClick({R.id.bt_index_getcode, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_index_getcode:
                CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(btIndexGetcode, 5000, 1000);
                mCountDownTimerUtils.start();
                break;
            case R.id.bt_login:
                toClass1(this,MainActivity.class);
                break;
        }
    }
}
