package com.xiaomai.ageny.shop_manage.goshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.shop_manage.goshop.contract.GoShopContract;
import com.xiaomai.ageny.shop_manage.goshop.presenter.GoShopPresenter;

public class GoShopActivity extends BaseMvpActivity<GoShopPresenter> implements GoShopContract.View {



    @Override
    public int getLayoutId() {
        return R.layout.activity_go_shop;
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
