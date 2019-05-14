package com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing;

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
import com.xiaomai.ageny.bean.AllotFirstBean;
import com.xiaomai.ageny.bean.AllotSecondBean;
import com.xiaomai.ageny.bean.DeviceAllotListBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.contract.DeviceAllotZxingContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.presenter.DeviceAllotZxingPresenter;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DeviceAllotZxingActivity extends BaseMvpActivity<DeviceAllotZxingPresenter> implements DeviceAllotZxingContract.View {


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
        return R.layout.activity_device_allot_zxing;
    }

    @Override
    public void initView() {
        mPresenter = new DeviceAllotZxingPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);
        //创建数据库
        daoSession = DaoSessionManager.getInstace()
                .getDaoSession(this);
        deviceDaoDao = daoSession.getDeviceDaoDao();

        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {

        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Logger.d("扫描结果" + result);
            try {
                String headurl = BaseUtils.subFrontString(result, "=");
                String shadurl = BaseUtils.subBehindString(result, "=");
                if (headurl.equals(App.ZxingBaseUrl)) {
                    mPresenter.getData(shadurl);
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
            DeviceAllotZxingActivity.this.setResult(RESULT_OK, resultIntent);
            DeviceAllotZxingActivity.this.finish();
        }
    };

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

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        ToastUtil.showShortToast("该设备已经分配");
        finish();
    }

    @Override
    public void onSuccess(DeviceAllotListBean bean) {
        if (bean.getCode() == 1) {
            strId = bean.getData().get(0).getDeviceid();
            strType = bean.getData().get(0).getDeviceType();
            strTime = bean.getData().get(0).getTime();
            strStopTime = bean.getData().get(0).getStrandedTime();
            Logger.d("扫描结果" + strId + "  " + strType + "  " + strTime + "  " + strStopTime);
            List<DeviceDao> daoList = deviceDaoDao.loadAll();
            Logger.d("设备数量" + daoList.size());
            if (daoList.size() == 0) {
                DeviceDao secondBean = new DeviceDao();
                secondBean.setDeviceId(strId);
                secondBean.setType(strType);
                secondBean.setTime(strTime);
                secondBean.setStopTime(strStopTime);
                deviceDaoDao.insert(secondBean);
                toClass(this, DeviceAllotListActivity.class);
                finish();
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
                        toClass(this, DeviceAllotListActivity.class);
                        finish();
                    }
                }
            }


        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            Logger.d("扫描错误");
            ToastUtil.showShortToast(bean.getMessage());
        }
    }
}
