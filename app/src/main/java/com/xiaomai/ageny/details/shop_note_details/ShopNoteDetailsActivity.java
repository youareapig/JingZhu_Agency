package com.xiaomai.ageny.details.shop_note_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.shop_note_details.contract.ShopNoteDetailsContract;
import com.xiaomai.ageny.details.shop_note_details.presenter.ShopNoteDetailsPresenter;

public class ShopNoteDetailsActivity extends BaseMvpActivity<ShopNoteDetailsPresenter> implements ShopNoteDetailsContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_note_details;
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
