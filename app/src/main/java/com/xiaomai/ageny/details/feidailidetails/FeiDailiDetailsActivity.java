package com.xiaomai.ageny.details.feidailidetails;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.feidailidetails.contract.FeiDailiDetailsContract;
import com.xiaomai.ageny.details.feidailidetails.presenter.FeiDailiDetailsPresenter;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.XiaJiSH_ListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeiDailiDetailsActivity extends BaseMvpActivity<FeiDailiDetailsPresenter> implements FeiDailiDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.device_more)
    RelativeLayout deviceMore;
    @BindView(R.id.rent)
    TextView rent;
    @BindView(R.id.rentting)
    TextView rentting;
    @BindView(R.id.off_line)
    TextView offLine;
    @BindView(R.id.on_line)
    TextView onLine;
    @BindView(R.id.shanghu_more)
    RelativeLayout shanghuMore;
    @BindView(R.id.updateuserinfo)
    RelativeLayout updateuserinfo;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fei_daili_details;
    }

    @Override
    public void initView() {
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

    @OnClick({R.id.back, R.id.device_more, R.id.shanghu_more, R.id.updateuserinfo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.device_more:
                toClass(this,XiaJiSH_ListActivity.class);
                break;
            case R.id.shanghu_more:
                toClass(this,XiaJiSH_ListActivity.class);
                break;
            case R.id.updateuserinfo:
                break;
        }
    }
}
