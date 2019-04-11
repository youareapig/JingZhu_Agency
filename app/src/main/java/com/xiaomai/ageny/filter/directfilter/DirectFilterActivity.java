package com.xiaomai.ageny.filter.directfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.directfilter.contract.DirectFilterContract;
import com.xiaomai.ageny.filter.directfilter.presenter.DirectFilterPresenter;

public class DirectFilterActivity extends BaseMvpActivity<DirectFilterPresenter> implements DirectFilterContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_direct_filter;
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
