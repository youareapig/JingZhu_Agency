package com.xiaomai.ageny.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.MainActivity;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.LoginBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.deviceinstalllist.DeviceInstallActivity;
import com.xiaomai.ageny.login.contract.LoginContract;
import com.xiaomai.ageny.login.presenter.LoginPresenter;
import com.xiaomai.ageny.utils.CountDownTimerUtils;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cn.jpush.android.api.JPushInterface;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_index_tel)
    EditText etIndexTel;
    @BindView(R.id.et_index_code)
    EditText etIndexCode;
    @BindView(R.id.bt_index_getcode)
    TextView btIndexGetcode;
    @BindView(R.id.bt_login)
    TextView btLogin;

    private CustomDialog dialog;
    private String strTel, strCode;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private Bundle bundle = new Bundle();

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showLoading() {
        dialog = new CustomDialog(this);
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        ToastUtil.showShortToast("服务器故障");
        dialog.dismiss();
    }

    @Override
    public void onSuccess(LoginBean bean) {
        if (bean.getCode() == 1) {
            SharedPreferencesUtil.getInstance(this).putSP("token", bean.getData().getWeixinToken());
            //最大分润比例
            SharedPreferencesUtil.getInstance(this).putSP("reward", bean.getData().getReward());
            SharedPreferencesUtil.getInstance(this).putSP("role", bean.getData().getRole());
            if (bean.getData().getRole().equals("1")) {
                //代理
                toClass1(this, MainActivity.class);
                finish();
            } else {
                //员工2 代理  1
                toClass(this, DeviceInstallActivity.class);
                finish();
            }
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccess(VerCodeBean bean) {
        if (bean.getCode() == 1) {
            CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(btIndexGetcode, 60000, 1000);
            mCountDownTimerUtils.start();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.bt_index_getcode, R.id.bt_login})
    public void onViewClicked(View view) {
        strTel = etIndexTel.getText().toString().trim();
        strCode = etIndexCode.getText().toString().trim();
        switch (view.getId()) {
            case R.id.bt_index_getcode:
                if (TextUtils.isEmpty(strTel)) {
                    ToastUtil.showShortToast("请输入电话号码");
                } else {
                    mPresenter.getCode(strTel);
                }

                break;
            case R.id.bt_login:
                if (TextUtils.isEmpty(strCode) || TextUtils.isEmpty(strTel)) {
                    ToastUtil.showShortToast("请输入验证码或电话号码");
                } else {
                    keyList.add("mobile");
                    keyList.add("captcha");
                    keyList.add("mobileId");

                    valueList.add(strTel);
                    valueList.add(strCode);
                    valueList.add("");

                    mPresenter.login(MaptoJson.toJsonZero(keyList, valueList));
                }
                break;
        }
    }

    @OnTextChanged({R.id.et_index_tel, R.id.et_index_code})
    public void onTextChanged(CharSequence text) {
        strTel = etIndexTel.getText().toString().trim();
        strCode = etIndexCode.getText().toString().trim();
        if (TextUtils.isEmpty(strTel) || TextUtils.isEmpty(strCode)) {
            btLogin.setBackgroundResource(R.drawable.goshop_button);
            btLogin.setEnabled(false);
        } else {
            btLogin.setBackgroundResource(R.drawable.goshop_button_true);
            btLogin.setEnabled(true);
        }
    }
}
