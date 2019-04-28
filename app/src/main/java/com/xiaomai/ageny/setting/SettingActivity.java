package com.xiaomai.ageny.setting;

import android.os.Bundle;
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


    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
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
            SharedPreferencesUtil.getInstance(this).putSP("token", "");
            toClass_Empty(this, LoginActivity.class);
            finish();
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
}
