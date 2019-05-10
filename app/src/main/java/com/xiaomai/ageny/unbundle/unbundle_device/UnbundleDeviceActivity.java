package com.xiaomai.ageny.unbundle.unbundle_device;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.VerCodeBean;
import com.xiaomai.ageny.details.contactdetails.ContactDetailsActivity;
import com.xiaomai.ageny.details.shanghudevicedetails.ShanghuDeviceDetailsActivity;
import com.xiaomai.ageny.shanghudevice.ShanghuDeviceActivity;
import com.xiaomai.ageny.unbundle.UnbundleFaileActivity;
import com.xiaomai.ageny.unbundle.UnbundleSuccessActivity;
import com.xiaomai.ageny.unbundle.unbundle_device.contract.UnbundleDeviceContract;
import com.xiaomai.ageny.unbundle.unbundle_device.presenter.UnbundleDevicePresenter;
import com.xiaomai.ageny.utils.CountDownTimerUtils;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.HideUtil;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnbundleDeviceActivity extends BaseMvpActivity<UnbundleDevicePresenter> implements UnbundleDeviceContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_unbundle)
    TextView btUnbundle;
    @BindView(R.id.linktel)
    TextView linktel;
    @BindView(R.id.input_code)
    EditText inputCode;
    @BindView(R.id.bt_getCode)
    TextView btGetCode;

    private String id, tel;
    private String strcode;
    private Bundle bundle;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private CustomDialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbundle_device;
    }

    @Override
    public void initView() {
        bundle = new Bundle();
        id = getIntent().getExtras().getString("id");
        tel = getIntent().getExtras().getString("tel");
        linktel.setText(HideUtil.hideMobile(tel));
        mPresenter = new UnbundleDevicePresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showLoading() {
        dialog = new CustomDialog(this);
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        dialog.dismiss();
    }

    @Override
    public void onSuccess(VerCodeBean bean) {
        if (bean.getCode() == 1) {
            CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(btGetCode, 60000, 1000);
            mCountDownTimerUtils.start();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            ShowDialogUtils.showdialog(this, bean.getMessage());
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    ShanghuDeviceDetailsActivity.instance.finish();
                    ShanghuDeviceActivity.instance.finish();
                    ContactDetailsActivity.instance.finish();
                }
            }, 1000);


        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_unbundle, R.id.bt_getCode})
    public void onViewClicked(View view) {
        strcode = inputCode.getText().toString().trim();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_unbundle:
                if (TextUtils.isEmpty(strcode)) {
                    ToastUtil.showShortToast("请输入验证码");
                } else {
                    keyList.add("deviceid");
                    keyList.add("captca");
                    keyList.add("mobile");

                    valueList.add(id);
                    valueList.add(strcode);
                    valueList.add(tel);

                    mPresenter.getDeviceDelete(MaptoJson.toJsonZero(keyList, valueList));
                }
                break;
            case R.id.bt_getCode:
                mPresenter.getCode(tel);
                break;
        }
    }

}
