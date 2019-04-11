package com.xiaomai.ageny.filter.contactfilter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.contactfilter.contract.ContactFilterContract;
import com.xiaomai.ageny.filter.contactfilter.presenter.ContactFilterPresenter;
import com.xiaomai.ageny.fragment.contact.contract.ContactContract;

public class ContactFilterActivity extends BaseMvpActivity<ContactFilterPresenter> implements ContactFilterContract.View {



    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_filter;
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
