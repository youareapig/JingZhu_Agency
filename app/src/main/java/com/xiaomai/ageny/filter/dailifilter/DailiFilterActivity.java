package com.xiaomai.ageny.filter.dailifilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.dailifilter.contract.DailiFilterContract;
import com.xiaomai.ageny.filter.dailifilter.presenter.DailiFilterPresenter;

public class DailiFilterActivity extends BaseMvpActivity<DailiFilterPresenter> implements DailiFilterContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_daili_filter;
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
}
