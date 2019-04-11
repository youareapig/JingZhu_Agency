package com.xiaomai.ageny.bank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.bank.contract.BankContract;
import com.xiaomai.ageny.bank.presenter.BankPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.base.BasePresenter;

public class BankActivity extends BaseMvpActivity<BankPresenter> implements BankContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_back;
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
}
