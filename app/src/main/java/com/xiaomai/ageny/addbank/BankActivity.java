package com.xiaomai.ageny.addbank;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addbank.contract.BankContract;
import com.xiaomai.ageny.addbank.presenter.BankPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;

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
