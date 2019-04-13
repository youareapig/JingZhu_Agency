package com.xiaomai.ageny.addagency.update;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addagency.update.contract.UpdateAgencyContract;
import com.xiaomai.ageny.addagency.update.presenter.UpdateAgencyPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateAgencyActivity extends BaseMvpActivity<UpdateAgencyPresenter> implements UpdateAgencyContract.View {
    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_person)
    TextView btPerson;
    @BindView(R.id.bt_firm)
    TextView btFirm;
    @BindView(R.id.view_firm)
    RelativeLayout viewFirm;
    @Override
    public int getLayoutId() {
        return R.layout.activity_update_agency;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        //默认选中企业
        btFirm.setSelected(true);
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
    @OnClick({R.id.back, R.id.bt_person, R.id.bt_firm,})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_person:
                btPerson.setSelected(true);
                btFirm.setSelected(false);
                viewFirm.setVisibility(View.GONE);
                break;
            case R.id.bt_firm:
                btPerson.setSelected(false);
                btFirm.setSelected(true);
                viewFirm.setVisibility(View.VISIBLE);
                break;
        }
    }
}
