package com.xiaomai.ageny.details.contactdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addcontact.AddContactActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.contactdetails.contract.ContactDetailsContract;
import com.xiaomai.ageny.details.contactdetails.presenter.ContactDetailsPresenter;
import com.xiaomai.ageny.shanghudevice.ShanghuDeviceActivity;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.UnbundleShanghuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactDetailsActivity extends BaseMvpActivity<ContactDetailsPresenter> implements ContactDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_unbundle)
    TextView btUnbundle;
    @BindView(R.id.bt_shanghudevice)
    RelativeLayout btShanghudevice;
    @BindView(R.id.rent)
    TextView rent;
    @BindView(R.id.rentting)
    TextView rentting;
    @BindView(R.id.off_line)
    TextView offLine;
    @BindView(R.id.on_line)
    TextView onLine;
    @BindView(R.id.updateuserinfo)
    RelativeLayout updateuserinfo;

    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_details;
    }

    @Override
    public void initView() {
        bundle = new Bundle();
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
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


    @OnClick({R.id.back, R.id.bt_shanghudevice, R.id.bt_unbundle,R.id.updateuserinfo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_shanghudevice:
                toClass(this, ShanghuDeviceActivity.class);
                break;
            case R.id.bt_unbundle:
                toClass(this, UnbundleShanghuActivity.class);
                break;
            case R.id.updateuserinfo:
                bundle.putInt("isadd",2);
                toClass(this,AddContactActivity.class,bundle);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
