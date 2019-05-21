package com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing;

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
import com.xiaomai.ageny.bean.PowerWithDrawInfoBean;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.contract.PowerWithDrawZxingContract;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.presenter.PowerWithDrawZxingPresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class PowerWithdrawZxingActivity extends BaseMvpActivity<PowerWithDrawZxingPresenter> implements PowerWithDrawZxingContract.View {


    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.back)
    RelativeLayout back;
    private CaptureFragment captureFragment;
    public static boolean isOpen = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_withdraw_zxing;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        mPresenter = new PowerWithDrawZxingPresenter();
        mPresenter.attachView(this);
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);

        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
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

    }

    @Override
    public void onSuccess(PowerWithDrawInfoBean bean) {

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
