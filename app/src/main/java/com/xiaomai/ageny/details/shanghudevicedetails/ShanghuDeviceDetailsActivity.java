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
import com.google.gson.Gson;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.ContactDeviceDetailsBean;
import com.xiaomai.ageny.details.shanghudevicedetails.contract.ShangHuDeviceDetailsContract;
import com.xiaomai.ageny.details.shanghudevicedetails.presenter.ShangHuDeviceDetailsPresenter;
import com.xiaomai.ageny.unbundle.unbundle_device.UnbundleDeviceActivity;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

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
    @BindView(R.id.otherview)
    OtherView otherView;

    private OptionsPickerView pvCustomOptions;
    private List<String> list;
    private String strPrice, strlinktel, strunbindtel;
    private String deviceId;
    private Bundle bundle;
    public static ShanghuDeviceDetailsActivity instance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shanghu_device_details;
    }

    @Override
    public void initView() {
        String jsonConfig = SharedPreferencesUtil.getInstance(this).getSP("config");
        list = BaseUtils.getPriceList(jsonConfig);
        instance = this;
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        deviceId = getIntent().getExtras().getString("id");


        mPresenter = new ShangHuDeviceDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(deviceId, "");
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(deviceId, "");
            }
        });
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
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(ContactDeviceDetailsBean bean) {
        if (bean.getCode() == 1) {
            ContactDeviceDetailsBean.DataBean data = bean.getData();
            strlinktel = data.getSellerLinkTel();
            strunbindtel = data.getLinkTel();

            id.setText(data.getBoxId());
            lat.setText(data.getBoxlatitude() + "," + data.getBoxlongitude());
            //分割地址
            String[] arrAddress = BaseUtils.spliteUtils(data.getBoxaddress(), ",");
            city.setText(arrAddress[0]);
            address.setText(arrAddress[1]);
            devicePrice.setText(data.getBoxdetails() + "/元小时");
            devicetype.setText(data.getBoxslot() + "槽");
            fenrun.setText(data.getBoxsellerreward());
            freezeMoney.setText(data.getFreeze_money());
            nofreezemoney.setText(data.getUnfreeze_money());
            storename.setText(data.getSellername());
            linkname.setText(data.getSellerLinkman());
            linktel.setText(strlinktel);
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

        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


    @OnClick({R.id.back, R.id.bt_unbundle, R.id.bt_setprice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_unbundle:
                bundle.putString("id", deviceId);
                bundle.putString("tel", strunbindtel);

                toClass(this, UnbundleDeviceActivity.class, bundle);
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
