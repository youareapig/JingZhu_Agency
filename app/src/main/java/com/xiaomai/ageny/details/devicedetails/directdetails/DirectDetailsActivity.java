package com.xiaomai.ageny.details.devicedetails.directdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.contract.DirectDetailsContract;
import com.xiaomai.ageny.details.devicedetails.directdetails.presenter.DirectDetailsPresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DirectDetailsActivity extends BaseMvpActivity<DirectDetailsPresenter> implements DirectDetailsContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.id)
    TextView id;
    @BindView(R.id.lat)
    TextView lat;
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
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.otherview)
    OtherView otherView;
    private String deviceid,msgid;

    @Override
    public int getLayoutId() {
        return R.layout.activity_direct_details;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        deviceid = getIntent().getStringExtra("id");
        msgid = getIntent().getStringExtra("msgid");
        mPresenter = new DirectDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(deviceid,msgid);
        Logger.d("id---" + id+ " msgid---"+msgid );
    }

    @Override
    public void showLoading() {
        otherView.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherView.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(ContactDeviceDetailsBean bean) {
        if (bean.getCode() == 1) {
            ContactDeviceDetailsBean.DataBean data = bean.getData();
            id.setText(data.getBoxId());
            lat.setText(data.getBoxlatitude() + "," + data.getBoxlongitude());
            //分割地址
            String[] arrAddress = BaseUtils.spliteUtils(data.getBoxaddress(), ",");
            city.setText(arrAddress[0]);
            address.setText(arrAddress[1]);
            devicePrice.setText(data.getBoxdetails() + "/元小时");
            devicetype.setText(data.getBoxslot() + "槽");
            fenrun.setText(data.getBoxsellerreward());
            freezeMoney.setText(data.getFreeze_money()+"元");
            nofreezemoney.setText(data.getUnfreeze_money()+"元");
            storename.setText(data.getSellername());
            linkname.setText(data.getSellerLinkman());
            linktel.setText(data.getSellerLinkTel());
            installman.setText(data.getInstallname());
            installTel.setText(data.getInstallLinkTel());
            installTime.setText(data.getInstallTime());
            //1,在线 0，离线
            if (data.getBoxstate().equals("1")) {
                onLineView.setVisibility(View.VISIBLE);
                offLineView.setVisibility(View.GONE);
                offLineTime.setVisibility(View.GONE);
            }
            if (data.getBoxstate().equals("0")) {
                onLineView.setVisibility(View.GONE);
                offLineView.setVisibility(View.VISIBLE);
                offLineTime.setVisibility(View.VISIBLE);
                offLineTime.setText("离线时间：" + data.getLixianTime());
            }
            remaincount.setText(data.getSybox() + "个");
            newtime.setText(data.getUpdtime());
            allMoney.setText(data.getCountMoney());
            monthMoney.setText(data.getMonthMoney());
            pingjunmoney.setText(data.getMonthlyMoney());

        }
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
