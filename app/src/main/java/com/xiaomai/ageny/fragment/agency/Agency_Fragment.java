package com.xiaomai.ageny.fragment.agency;

import android.view.View;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.fragment.agency.contract.AgencyContract;
import com.xiaomai.ageny.fragment.agency.presenter.AgencyPresenter;

public class Agency_Fragment extends BaseMvpFragment<AgencyPresenter> implements AgencyContract.View {
    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.agency_fragment;
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
