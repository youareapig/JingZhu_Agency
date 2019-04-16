package com.xiaomai.ageny.details.shanghudevicedetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.details.shanghudevicedetails.contract.ShangHuDeviceDetailsContract;
import com.xiaomai.ageny.details.shanghudevicedetails.presenter.ShangHuDeviceDetailsPresenter;
import com.xiaomai.ageny.unbundle.unbundle_device.UnbundleDeviceActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShanghuDeviceDetailsActivity extends BaseMvpActivity<ShangHuDeviceDetailsPresenter> implements ShangHuDeviceDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_unbundle)
    TextView btUnbundle;
    @BindView(R.id.bt_setprice)
    ImageView btSetprice;
    @BindView(R.id.device_price)
    TextView devicePrice;
    @BindView(R.id.id)
    TextView id;
    @BindView(R.id.lat)
    TextView lat;
    @BindView(R.id.city)
    TextView city;
    @BindView(R.id.address)
    TextView address;
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

    private OptionsPickerView pvCustomOptions;
    private List<String> list;
    private String strPrice;
    private String deviceId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shanghu_device_details;
    }

    @Override
    public void initView() {
        deviceId = getIntent().getExtras().getString("id");

        list = new ArrayList<>();
        list.add("1.5/小时");
        list.add("2.5/小时");
        list.add("3.5/小时");
        list.add("4.5/小时");
        list.add("5.5/小时");

        mPresenter = new ShangHuDeviceDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(deviceId);
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

    @Override
    public void onSuccess(ContactDeviceDetailsBean bean) {
        if (bean.getCode() == 1) {
            ContactDeviceDetailsBean.DataBean data = bean.getData();
            id.setText(data.getBoxId());
            lat.setText(data.getBoxlatitude() + "," + data.getBoxlongitude());
            city.setText("");
            address.setText(data.getBoxaddress());
            devicePrice.setText(data.getBoxdetails() + "/元小时");
            devicetype.setText(data.getBoxslot() + "槽");
            fenrun.setText(data.getBoxsellerreward());
            freezeMoney.setText("冻结金额："+data.getFreeze_money());
            nofreezemoney.setText("已解冻金额："+data.getUnfreeze_money());
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
                offLineTime.setText("离线时间：" + data.getLixianTime() + "h");
            }
            remaincount.setText(data.getSybox() + "个");
            newtime.setText(data.getUpdtime());
            allMoney.setText(data.getCountMoney());
            monthMoney.setText(data.getMonthMoney());
            pingjunmoney.setText(data.getMonthlyMoney());


        }

    }


    @OnClick({R.id.back, R.id.bt_unbundle, R.id.bt_setprice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_unbundle:
                toClass(this, UnbundleDeviceActivity.class);
                break;
            case R.id.bt_setprice:
                choosePrice();
                break;
        }
    }

    //选择单价
    private void choosePrice() {
        pvCustomOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                strPrice = list.get(options1);
                devicePrice.setText(strPrice);
            }
        }).setLayoutRes(R.layout.setting_price, new CustomListener() {
            @Override
            public void customLayout(View v) {
                v.findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pvCustomOptions.returnData();
                        pvCustomOptions.dismiss();
                    }
                });
                v.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        devicePrice.setText(strPrice);
                        pvCustomOptions.dismiss();
                    }
                });
            }
        }).isDialog(true).setOutSideCancelable(false).build();
        pvCustomOptions.setPicker(list);
        pvCustomOptions.show();
    }

}
