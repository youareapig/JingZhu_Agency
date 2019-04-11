package com.xiaomai.ageny.filter.indirectfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.indirectfilter.contract.IndirectFilterContract;
import com.xiaomai.ageny.filter.indirectfilter.presenter.IndirectFilterPresenter;

public class IndirectFilterActivity extends BaseMvpActivity<IndirectFilterPresenter> implements IndirectFilterContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.activity_indirect_filter2;
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
