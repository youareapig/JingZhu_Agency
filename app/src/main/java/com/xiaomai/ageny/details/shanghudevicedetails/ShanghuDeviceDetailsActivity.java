package com.xiaomai.ageny.details.shanghudevicedetails;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
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

    private OptionsPickerView pvCustomOptions;
    private List<String> list;
    private String strPrice;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shanghu_device_details;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("1.5/小时");
        list.add("2.5/小时");
        list.add("3.5/小时");
        list.add("4.5/小时");
        list.add("5.5/小时");
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


    @OnClick({R.id.back, R.id.bt_unbundle, R.id.bt_setprice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_unbundle:
                toClass(this,UnbundleDeviceActivity.class);
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
