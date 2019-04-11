package com.xiaomai.ageny.details.orderdetails.lowerorderdetails;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.contract.LowerOrderDetailsContract;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.presenter.LowerOrderDetailsPresenter;

public class LowerOrderDetailsActivity extends BaseMvpActivity<LowerOrderDetailsPresenter> implements LowerOrderDetailsContract.View {



    @Override
    public int getLayoutId() {
        return R.layout.activity_lower_order_details;
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
