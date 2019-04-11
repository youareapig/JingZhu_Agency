package com.xiaomai.ageny.orderdetails.myorderdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.orderdetails.myorderdetails.contract.MyOrderDetailsContract;
import com.xiaomai.ageny.orderdetails.myorderdetails.presenter.MyOrderDetailsPresenter;

public class MyOrderDetailsActivity extends BaseMvpActivity<MyOrderDetailsPresenter> implements MyOrderDetailsContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_my_order_details;
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
