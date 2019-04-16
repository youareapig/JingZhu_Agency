package com.xiaomai.ageny.deploy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeployZxingActivity extends BaseActivity {


    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.back)
    RelativeLayout back;
    public static boolean isOpen = false;
    private CaptureFragment captureFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_deploy_zxing;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        captureFragment = new CaptureFragment();
        // 为二维码扫描界面设置定制化界面
        CodeUtils.setFragmentArgs(captureFragment, R.layout.my_camera);

        captureFragment.setAnalyzeCallback(analyzeCallback);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_my_container, captureFragment).commit();
    }

    CodeUtils.AnalyzeCallback analyzeCallback = new CodeUtils.AnalyzeCallback() {

        @Override
        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
            bundle.putString(CodeUtils.RESULT_STRING, result);
            resultIntent.putExtras(bundle);
            DeployZxingActivity.this.setResult(RESULT_OK, resultIntent);
            DeployZxingActivity.this.finish();
        }

        @Override
        public void onAnalyzeFailed() {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            DeployZxingActivity.this.setResult(RESULT_OK, resultIntent);
            DeployZxingActivity.this.finish();
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
                break;
        }
    }
}
