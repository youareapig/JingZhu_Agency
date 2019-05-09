package com.xiaomai.ageny.setting;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.LoginOutBean;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.mybankcard.MyBankCardActivity;
import com.xiaomai.ageny.setting.contract.SettingContract;
import com.xiaomai.ageny.setting.presenter.SettingPresenter;
import com.xiaomai.ageny.shop_manage.ShopManageActivity;
import com.xiaomai.ageny.staff_manage.StaffManageActivity;
import com.xiaomai.ageny.unbundle.unbundle_record.UnbundleRecordActivity;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class SettingActivity extends BaseMvpActivity<SettingPresenter> implements SettingContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_mybank)
    RelativeLayout btMybank;
    @BindView(R.id.bt_staff_manage)
    RelativeLayout btStaffManage;
    @BindView(R.id.bt_unbundle_record)
    RelativeLayout btUnbundleRecord;
    @BindView(R.id.bt_shop_manage)
    RelativeLayout btShopManage;
    @BindView(R.id.bt_loginout)
    TextView btLoginout;

    private CustomDialog dialog;
    private String strLev;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        strLev = getIntent().getExtras().getString("lev");
        if (strLev.equals("1")) {
            btShopManage.setVisibility(View.VISIBLE);
        } else {
            btShopManage.setVisibility(View.GONE);
        }
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        mPresenter = new SettingPresenter();
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
        dialog.dismiss();
    }

    @Override
    public void onSuccess(LoginOutBean bean) {
        if (bean.getCode() == 1) {
            JPushInterface.deleteAlias(this, 1);
            SharedPreferencesUtil.getInstance(this).putSP("token", "");
            toClass_Empty(this, LoginActivity.class);
            finish();
        } else if (bean.getCode() == -10) {
            restLoginDialog();
        } else {
            ToastUtil.showShortToast("注销失败");
        }

    }


    @OnClick({R.id.back, R.id.bt_mybank, R.id.bt_staff_manage, R.id.bt_unbundle_record, R.id.bt_shop_manage, R.id.bt_loginout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_mybank:
                //我的银行卡
                toClass(this, MyBankCardActivity.class);
                break;
            case R.id.bt_staff_manage:
                //员工管理
                toClass(this, StaffManageActivity.class);
                break;
            case R.id.bt_unbundle_record:
                //商户绑定记录
                toClass(this, UnbundleRecordActivity.class);
                break;
            case R.id.bt_shop_manage:
                //采购管理
                toClass1(this, ShopManageActivity.class);
                break;
            case R.id.bt_loginout:
                //退出登录
                mPresenter.loginOut();
                break;
        }
    }

    private void restLoginDialog() {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_other_login, null);
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();
        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtil.getInstance(SettingActivity.this).putSP("token", "");
                toClass_Empty(SettingActivity.this, LoginActivity.class);
                SettingActivity.this.finish();
                JPushInterface.deleteAlias(SettingActivity.this, 1);
                builder.dismiss();
            }
        });
    }
}
