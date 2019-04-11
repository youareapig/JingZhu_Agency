package com.xiaomai.ageny.details.devicedetails.directdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.devicedetails.directdetails.contract.DirectDetailsContract;
import com.xiaomai.ageny.details.devicedetails.directdetails.presenter.DirectDetailsPresenter;

public class DirectDetailsActivity extends BaseMvpActivity<DirectDetailsPresenter> implements DirectDetailsContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_direct_details;
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
