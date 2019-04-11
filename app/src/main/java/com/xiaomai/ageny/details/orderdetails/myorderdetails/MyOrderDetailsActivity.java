package com.xiaomai.ageny.details.orderdetails.myorderdetails;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.contract.MyOrderDetailsContract;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.presenter.MyOrderDetailsPresenter;

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
