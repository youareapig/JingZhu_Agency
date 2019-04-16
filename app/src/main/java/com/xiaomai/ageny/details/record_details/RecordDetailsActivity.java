package com.xiaomai.ageny.details.record_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.record_details.contract.RecordDetailsContract;
import com.xiaomai.ageny.details.record_details.presenter.RecordDetailsPresenter;

public class RecordDetailsActivity extends BaseMvpActivity<RecordDetailsPresenter> implements RecordDetailsContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_record_details;
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
