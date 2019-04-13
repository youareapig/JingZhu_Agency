package com.xiaomai.ageny.fragment.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.deposit_list.DepositListActivity;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.fragment.mine.contract.MineContract;
import com.xiaomai.ageny.fragment.mine.presenter.MinePresenter;
import com.xiaomai.ageny.mybill.MyBillActivity;
import com.xiaomai.ageny.setting.SettingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Mine_Fragment extends BaseMvpFragment<MinePresenter> implements MineContract.View {
    @BindView(R.id.bt_device_manage)
    RelativeLayout btDeviceManage;
    @BindView(R.id.bt_deposit_list)
    RelativeLayout btDepositList;
    @BindView(R.id.bt_myorder)
    RelativeLayout btMyorder;
    @BindView(R.id.bt_popup)
    RelativeLayout btPopup;
    @BindView(R.id.bt_setting)
    RelativeLayout btSetting;
    Unbinder unbinder;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
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


    @OnClick({R.id.bt_device_manage, R.id.bt_deposit_list, R.id.bt_myorder, R.id.bt_popup, R.id.bt_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_device_manage:
                toClass(getActivity(),DeviceManageActivity.class);
                break;
            case R.id.bt_deposit_list:
                toClass(getActivity(), DepositListActivity.class);
                break;
            case R.id.bt_myorder:
                toClass(getActivity(),MyBillActivity.class);
                break;
            case R.id.bt_popup:
                break;
            case R.id.bt_setting:
                toClass(getActivity(),SettingActivity.class);
                break;
        }
    }
}
