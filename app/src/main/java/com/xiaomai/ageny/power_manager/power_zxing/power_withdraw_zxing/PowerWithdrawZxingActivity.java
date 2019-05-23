package com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.PowerWithDrawInfoBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.power_manager.power_allot.PowerAllotActivity;
import com.xiaomai.ageny.power_manager.power_withdraw.PowerWithdrawActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.contract.PowerWithDrawZxingContract;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.presenter.PowerWithDrawZxingPresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PowerWithdrawZxingActivity extends BaseMvpActivity<PowerWithDrawZxingPresenter> implements PowerWithDrawZxingContract.View {


    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.back)
    RelativeLayout back;
    private CaptureFragment captureFragment;
    public static boolean isOpen = false;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    private String fromact;
    private String strId, strType, strName, strTel;
    private List<String> idList = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_power_withdraw_zxing;
    }

    @Override
    public void initView() {
        fromact = getIntent().getExtras().getString("fromact");
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        mPresenter = new PowerWithDrawZxingPresenter();
        mPresenter.attachView(this);
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);

        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
        //创建数据库
        daoSession = DaoSessionManager.getInstace()
                .getDaoSession(this);
        deviceDaoDao = daoSession.getDeviceDaoDao();
    }

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {

        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Logger.d("扫描结果result--->");
            try {
                Logger.d("个数:" + result.indexOf(App.ZxingBaseBar));
                if (result.indexOf(App.ZxingBaseBar) != -1) {
                    mPresenter.getData(result);
                    Logger.d("扫码成功");
                } else {
                    ToastUtil.showShortToast("请扫描正确二维码");
                    if (fromact.equals("1")) {
                        finish();
                    } else {
                        toClass(PowerWithdrawZxingActivity.this, PowerWithdrawActivity.class);
                        finish();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                ToastUtil.showShortToast("请扫描正确二维码");
                if (fromact.equals("1")) {
                    finish();
                } else {
                    toClass(PowerWithdrawZxingActivity.this, PowerWithdrawActivity.class);
                    finish();
                }
            }
        }

        @Override
        public void onAnalyzeFailed() {
            Logger.d("扫描结果onAnalyzeFailed");
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            PowerWithdrawZxingActivity.this.setResult(RESULT_OK, resultIntent);
            PowerWithdrawZxingActivity.this.finish();
        }
    };

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void onError(Throwable throwable) {
        if (fromact.equals("1")) {
            finish();
        } else {
            toClass(PowerWithdrawZxingActivity.this, PowerWithdrawActivity.class);
            finish();
        }
    }


    @Override
    public void onSuccess(PowerWithDrawInfoBean bean) {
        if (bean.getCode() == 1) {
            strId = bean.getData().getDeviceID();
            strType = bean.getData().getDeviceType();

            strTel = bean.getData().getMobile();
            strName = bean.getData().getUserAgentName();

            List<DeviceDao> daoList = deviceDaoDao.loadAll();
            if (daoList.size() == 0) {
                DeviceDao secondBean = new DeviceDao();
                secondBean.setDeviceId(strId);
                secondBean.setType(strType);
                secondBean.setTime(strTel);
                secondBean.setStopTime(strName);
                deviceDaoDao.insert(secondBean);
                toClass(this, PowerWithdrawActivity.class);
                finish();
            } else {
//                for (int i = 0; i < daoList.size(); i++) {
//                    if (strId.equals(daoList.get(i).getDeviceId())) {
//                        ToastUtil.showShortToast("列表已存在该设备，不能重复添加");
//                        toClass(this, PowerWithdrawActivity.class);
//                        finish();
//                    } else {
//                        DeviceDao secondBean = new DeviceDao();
//                        secondBean.setDeviceId(strId);
//                        secondBean.setType(strType);
//                        secondBean.setTime(strTel);
//                        secondBean.setStopTime(strName);
//                        deviceDaoDao.insert(secondBean);
//                        toClass(this, PowerWithdrawActivity.class);
//                        finish();
//                    }
//                }
                for (int i = 0; i < daoList.size(); i++) {
                    idList.add(daoList.get(i).getDeviceId());
                }
                if (idList.contains(strId)) {
                    ToastUtil.showShortToast("列表已存在该充电宝，不能重复添加");
                    toClass(this, PowerWithdrawActivity.class);
                    finish();
                } else {
                    DeviceDao secondBean = new DeviceDao();
                    secondBean.setDeviceId(strId);
                    secondBean.setType(strType);
                    secondBean.setTime(strTel);
                    secondBean.setStopTime(strName);
                    deviceDaoDao.insert(secondBean);
                    toClass(this, PowerWithdrawActivity.class);
                    finish();
                }
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
            finish();
        } else {
            Logger.d("扫描错误");
            ToastUtil.showShortToast(bean.getMessage());
            if (fromact.equals("1")) {
                finish();
            } else {
                toClass(this, PowerWithdrawActivity.class);
                finish();
            }
        }
    }


    @OnClick({R.id.fl_my_container, R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_my_container:
                if (!isOpen) {
                    CodeUtils.isLightEnable(true);
                    isOpen = true;
                } else {
                    CodeUtils.isLightEnable(false);
                    isOpen = false;
                }
                break;
            case R.id.back:
                if (fromact.equals("1")) {
                    finish();
                } else {
                    toClass(this, PowerWithdrawActivity.class);
                    finish();
                }
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //点击完返回键，执行的动作
            //1,从设备管理界面跳转过来的，2分配列表过来的
            if (fromact.equals("1")) {
                finish();
            } else {
                toClass(this, PowerWithdrawActivity.class);
                finish();
            }
        }
        return true;
    }

}
