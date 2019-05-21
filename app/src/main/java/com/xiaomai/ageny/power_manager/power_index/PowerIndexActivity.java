package com.xiaomai.ageny.power_manager.power_index;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.PowerManagerBean;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.DeviceWithdrawActivity;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.power_manager.power_alloted.PowerAllotedActivity;
import com.xiaomai.ageny.power_manager.power_index.contract.PowerIndexContract;
import com.xiaomai.ageny.power_manager.power_index.presenter.PowerIndexPresenter;
import com.xiaomai.ageny.power_manager.power_mine.MyPowerActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.PowerAlloteZxingActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.PowerWithdrawZxingActivity;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerIndexActivity extends BaseMvpActivity<PowerIndexPresenter> implements PowerIndexContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.power_totle)
    TextView powerTotle;
    @BindView(R.id.power_fenpei)
    TextView powerFenpei;
    @BindView(R.id.power_chiyou)
    TextView powerChiyou;
    @BindView(R.id.bt_power_withdraw)
    RelativeLayout btPowerWithdraw;
    @BindView(R.id.bt_power_allot)
    RelativeLayout btPowerAllot;
    @BindView(R.id.bt_mypower)
    RelativeLayout btMypower;
    @BindView(R.id.bt_power_alloted)
    RelativeLayout btPowerAlloted;
    @BindView(R.id.otherview)
    OtherView otherview;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    @Override
    public int getLayoutId() {
        return R.layout.activity_power_index;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mPresenter = new PowerIndexPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData();
        try {
            daoSession = DaoSessionManager.getInstace()
                    .getDaoSession(this);
            //查询所有数据
            deviceDaoDao = daoSession.getDeviceDaoDao();
            deviceDaoDao.deleteAll();
            Logger.d("清空数据");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.d("清空数据失败");
        }
    }

    @Override
    public void showLoading() {
        otherview.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherview.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(PowerManagerBean bean) {
        if (bean.getCode() == 1) {
            powerTotle.setText(bean.getData().getCountBox());
            powerFenpei.setText(bean.getData().getFenpeiBox());
            powerChiyou.setText(bean.getData().getWeifenpeiBox());
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(90)
    public void openCameraSuccess90() {
        toClass(this, PowerWithdrawZxingActivity.class);

    }

    @PermissionGrant(92)
    public void openCameraSuccess92() {
        toClass(this, PowerAlloteZxingActivity.class);

    }

    @OnClick({R.id.back, R.id.bt_power_withdraw, R.id.bt_power_allot, R.id.bt_mypower, R.id.bt_power_alloted})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_power_withdraw:
                //充电宝撤回
                MPermissions.requestPermissions(this, 90, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_power_allot:
                //充电宝分配
                MPermissions.requestPermissions(this, 92, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_mypower:
                //我的充电宝
                toClass(this, MyPowerActivity.class);
                break;
            case R.id.bt_power_alloted:
                //已分配充电宝
                toClass(this, PowerAllotedActivity.class);
                break;
        }
    }
}
