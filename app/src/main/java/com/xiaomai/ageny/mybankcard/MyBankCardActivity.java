package com.xiaomai.ageny.mybankcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.mybankcard.contract.MyBankCardContract;
import com.xiaomai.ageny.mybankcard.presenter.MyBankCardPresenter;

public class MyBankCardActivity extends BaseMvpActivity<MyBankCardPresenter> implements MyBankCardContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_my_bank_card;
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
