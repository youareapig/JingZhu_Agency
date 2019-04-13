package com.xiaomai.ageny.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.mybankcard.MyBankCardActivity;
import com.xiaomai.ageny.setting.contract.SettingContract;
import com.xiaomai.ageny.setting.presenter.SettingPresenter;
import com.xiaomai.ageny.staff_manage.StaffManageActivity;

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

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
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


    @OnClick({R.id.back, R.id.bt_mybank, R.id.bt_staff_manage, R.id.bt_unbundle_record, R.id.bt_shop_manage, R.id.bt_loginout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_mybank:
                //我的银行卡
                toClass(this, MyBankCardActivity.class);
                break;
            case R.id.bt_staff_manage:
                //员工管理
                toClass(this,StaffManageActivity.class);
                break;
            case R.id.bt_unbundle_record:
                //商户绑定记录
                break;
            case R.id.bt_shop_manage:
                //采购管理
                break;
            case R.id.bt_loginout:
                //退出登录
                break;
        }
    }
}
