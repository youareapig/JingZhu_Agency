package com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.xiaomai.ageny.bean.PowerInfoBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.power_manager.power_allot.PowerAllotActivity;
import com.xiaomai.ageny.power_manager.power_alloted.PowerAllotedActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.contract.PowerAlloteZxingContract;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.presenter.PowerAlloteZxingPresenter;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class PowerAlloteZxingActivity extends BaseMvpActivity<PowerAlloteZxingPresenter> implements PowerAlloteZxingContract.View {


    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.back)
    RelativeLayout back;
    private CaptureFragment captureFragment;
    public static boolean isOpen = false;
    private String strId, strType, strTime, strStopTime;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_allote_zxing;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        mPresenter = new PowerAlloteZxingPresenter();
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
            Logger.d("扫描结果result--->" + result);
            try {
                Logger.d("个数:" + result.indexOf(App.ZxingBaseBar));
                if (result.indexOf(App.ZxingBaseBar) != -1) {
                    mPresenter.getData(result);
                    Logger.d("扫码成功");
                } else {
                    finish();
                    ToastUtil.showShortToast("请扫描正确二维码");
                }
            } catch (Exception e) {
                e.printStackTrace();
                finish();
                ToastUtil.showShortToast("请扫描正确二维码");
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
            PowerAlloteZxingActivity.this.setResult(RESULT_OK, resultIntent);
            PowerAlloteZxingActivity.this.finish();
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
        finish();
    }

    @Override
    public void onSuccess(PowerInfoBean bean) {
        if (bean.getCode() == 1) {
            strId = bean.getData().get(0).getDeviceid();
            strType = bean.getData().get(0).getDeviceType();
            strTime = bean.getData().get(0).getTime();
            strStopTime = bean.getData().get(0).getStrandedTime();
            List<DeviceDao> daoList = deviceDaoDao.loadAll();
            if (daoList.size() == 0) {
                DeviceDao secondBean = new DeviceDao();
                secondBean.setDeviceId(strId);
                secondBean.setType(strType);
                secondBean.setTime(strTime);
                secondBean.setStopTime(strStopTime);
                deviceDaoDao.insert(secondBean);
                toClass(this, PowerAllotActivity.class);
            } else {
                for (int i = 0; i < daoList.size(); i++) {
                    if (strId.equals(daoList.get(i).getDeviceId())) {
                        ToastUtil.showShortToast("列表已存在该设备，不能重复添加");
                    } else {
                        DeviceDao secondBean = new DeviceDao();
                        secondBean.setDeviceId(strId);
                        secondBean.setType(strType);
                        secondBean.setTime(strTime);
                        secondBean.setStopTime(strStopTime);
                        deviceDaoDao.insert(secondBean);
                        toClass(this, PowerAllotActivity.class);
                    }
                }
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            Logger.d("扫描错误");
            ToastUtil.showShortToast(bean.getMessage());
        }
        finish();
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
                finish();
                break;
        }
    }
}
