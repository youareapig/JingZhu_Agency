package com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing;

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
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.DeviceWithDrawListBean;
import com.xiaomai.ageny.device_manage.device_withdraw.DeviceWithDrawListActivity;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.contract.DeviceWithDrawContract;
import com.xiaomai.ageny.device_manage.device_withdraw.withdraw_zxing.presenter.DeviceWithDrawPresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class DeviceWithdrawActivity extends BaseMvpActivity<DeviceWithDrawPresenter> implements DeviceWithDrawContract.View {

    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.back)
    RelativeLayout back;
    private CaptureFragment captureFragment;
    public static boolean isOpen = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_withdraw;
    }

    @Override
    public void initView() {
        mPresenter = new DeviceWithDrawPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);

        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        ToastUtil.showShortToast("服务器故障");
        finish();
    }

    @Override
    public void onSuccess(DeviceWithDrawListBean bean) {
        if (bean.getCode() == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("id", bean.getData().getDeviceID());
            bundle.putString("type", bean.getData().getDeviceType());
            bundle.putString("tel", bean.getData().getMobile());
            bundle.putString("name", bean.getData().getUserAgentName());
            toClass(this, DeviceWithDrawListActivity.class, bundle);
            finish();
        }else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
        finish();
    }

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {

        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
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
            Logger.d("扫描错误");
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            DeviceWithdrawActivity.this.setResult(RESULT_OK, resultIntent);
            DeviceWithdrawActivity.this.finish();
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


}
