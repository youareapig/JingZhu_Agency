package com.xiaomai.ageny.fragment.index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fingdo.statelayout.StateLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.deposit.DepositActivity;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.deviceinstalllist.DeviceInstallActivity;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.fragment.index.presenter.IndexPresenter;
import com.xiaomai.ageny.mybill.MyBillActivity;
import com.xiaomai.ageny.offline.OfflineActivity;
import com.xiaomai.ageny.order.OrderActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Index_Fragment extends BaseMvpFragment<IndexPresenter> implements IndexContract.View {
    @BindView(R.id.yesterday_money)
    TextView yesterdayMoney;
    @BindView(R.id.all_money)
    TextView allMoney;
    @BindView(R.id.month_money)
    TextView monthMoney;
    @BindView(R.id.today_money)
    TextView todayMoney;
    @BindView(R.id.tx_index_money)
    TextView txIndexMoney;
    @BindView(R.id.bt_index_tixian)
    TextView btIndexTixian;
    @BindView(R.id.deposit_money)
    TextView depositMoney;
    @BindView(R.id.rent)
    TextView rent;
    @BindView(R.id.rentting)
    TextView rentting;
    @BindView(R.id.off_line)
    TextView offLine;
    @BindView(R.id.on_line)
    TextView onLine;
    @BindView(R.id.bt_index_bill)
    LinearLayout btIndexBill;
    @BindView(R.id.bt_index_devicemanager)
    LinearLayout btIndexDevicemanager;
    @BindView(R.id.bt_index_devicemake)
    LinearLayout btIndexDevicemake;
    @BindView(R.id.bt_index_order)
    LinearLayout btIndexOrder;
    @BindView(R.id.bt_off_line)
    RelativeLayout btOffLine;
    Unbinder unbinder;

    @Override
    protected void initView(View view) {
        mPresenter = new IndexPresenter();
        mPresenter.attachView(this);
        mPresenter.getData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.index_fragment;
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        Logger.d("失败");
    }

    @Override
    public void onSuccess(IndexBean bean) {
        Logger.d("成功");
        if (bean.getCode() == 1) {
            IndexBean.DataBean data = bean.getData();
            yesterdayMoney.setText(data.getYestoday_earn());
            todayMoney.setText(data.getDay_earn());
            allMoney.setText(data.getTotal_earn());
            monthMoney.setText(data.getMonth_earn());
            txIndexMoney.setText(data.getUnliquidated());
            depositMoney.setText("已提现金额：" + data.getFreeze_money());
            rent.setText("待租借：" + data.getNoRentCount() + "个");
            rentting.setText("租借中：" + data.getRentCount() + "个");
            offLine.setText("离线：" + data.getOffLineCount() + "台");
            onLine.setText("在线：" + data.getOnLineCount() + "台");


        }


    }

    @OnClick({R.id.bt_index_tixian, R.id.bt_index_bill, R.id.bt_index_devicemanager, R.id.bt_index_devicemake, R.id.bt_index_order, R.id.bt_off_line})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_index_tixian:
                toClass(getActivity(), DepositActivity.class);
                break;
            case R.id.bt_index_bill:
                toClass(getActivity(), MyBillActivity.class);
                break;
            case R.id.bt_index_devicemanager:
                toClass(getActivity(), DeviceManageActivity.class);
                break;
            case R.id.bt_index_devicemake:
                toClass(getActivity(), DeviceInstallActivity.class);
                break;
            case R.id.bt_index_order:
                toClass(getActivity(), OrderActivity.class);
                break;
            case R.id.bt_off_line:
                toClass(getActivity(), OfflineActivity.class);
                break;
        }
    }

}
