package com.xiaomai.ageny.details.earn_details;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.details.earn_details.contract.EarnDetailsContract;
import com.xiaomai.ageny.details.earn_details.presenter.EarnDetailsPresenter;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EarnDetailsActivity extends BaseMvpActivity<EarnDetailsPresenter> implements EarnDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.id)
    TextView id;
    @BindView(R.id.lat)
    TextView lat;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.device_price)
    TextView devicePrice;
    @BindView(R.id.devicetype)
    TextView devicetype;
    @BindView(R.id.fenrun)
    TextView fenrun;
    @BindView(R.id.freeze_money)
    TextView freezeMoney;
    @BindView(R.id.nofreezemoney)
    TextView nofreezemoney;
    @BindView(R.id.storename)
    TextView storename;
    @BindView(R.id.linkname)
    TextView linkname;
    @BindView(R.id.linktel)
    TextView linktel;
    @BindView(R.id.installman)
    TextView installman;
    @BindView(R.id.install_tel)
    TextView installTel;
    @BindView(R.id.install_time)
    TextView installTime;
    @BindView(R.id.off_line_view)
    LinearLayout offLineView;
    @BindView(R.id.on_line_view)
    LinearLayout onLineView;
    @BindView(R.id.off_line_time)
    TextView offLineTime;
    @BindView(R.id.remaincount)
    TextView remaincount;
    @BindView(R.id.newtime)
    TextView newtime;
    @BindView(R.id.all_money)
    TextView allMoney;
    @BindView(R.id.month_money)
    TextView monthMoney;
    @BindView(R.id.pingjunmoney)
    TextView pingjunmoney;
    @BindView(R.id.otherview)
    OtherView otherview;

    @Override
    public int getLayoutId() {
        return R.layout.activity_earn_details;
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


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
