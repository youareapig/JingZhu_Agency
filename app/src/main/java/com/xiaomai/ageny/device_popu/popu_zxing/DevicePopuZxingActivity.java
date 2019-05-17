package com.xiaomai.ageny.device_popu.popu_zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.uuzuche.lib_zxing.activity.CaptureFragment;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_manage.device_withdraw.DeviceWithDrawListActivity;
import com.xiaomai.ageny.device_popu.Adapter;
import com.xiaomai.ageny.device_popu.DevicePopuActivity;
import com.xiaomai.ageny.device_popu.popu_zxing.contract.PopuDeviceContract;
import com.xiaomai.ageny.device_popu.popu_zxing.presenter.PopuDevicePresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.SpacesItemDecoration_left;
import com.xiaomai.ageny.utils.ToastUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DevicePopuZxingActivity extends BaseMvpActivity<PopuDevicePresenter> implements PopuDeviceContract.View {


    @BindView(R.id.fl_my_container)
    FrameLayout flMyContainer;
    @BindView(R.id.back)
    RelativeLayout back;
    private CaptureFragment captureFragment;
    public static boolean isOpen = false;
    private List<String> list;
    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_popu_zxing;
    }

    @Override
    public void initView() {
        mPresenter = new PopuDevicePresenter();
        mPresenter.attachView(this);
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
//            Intent resultIntent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_SUCCESS);
//            bundle.putString(CodeUtils.RESULT_STRING, result);
//            resultIntent.putExtras(bundle);
//            DevicePopuZxingActivity.this.setResult(RESULT_OK, resultIntent);
//            DevicePopuZxingActivity.this.finish();
            try {
                String headurl = BaseUtils.subFrontString(result, "=");
                id = BaseUtils.subBehindString(result, "=");
                if (headurl.equals(App.ZxingBaseUrl)) {
                    mPresenter.getData(id);
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
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt(CodeUtils.RESULT_TYPE, CodeUtils.RESULT_FAILED);
            bundle.putString(CodeUtils.RESULT_STRING, "");
            resultIntent.putExtras(bundle);
            DevicePopuZxingActivity.this.setResult(RESULT_OK, resultIntent);
            DevicePopuZxingActivity.this.finish();
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
        finish();
    }

    @Override
    public void onSuccess(ShowHoleBean bean) {
        if (bean.getCode() == 1) {
            list = new ArrayList<>();
            int kongcount = bean.getData();
            for (int i = 1; i <= kongcount; i++) {
                list.add(i + "孔");
            }
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putSerializable("mlist", (Serializable) list);
            toClass(this, DevicePopuActivity.class, bundle);
            finish();
        } else if (bean.getCode() == -10) {
            finish();
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
            finish();
        }
    }
}
