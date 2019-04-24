package com.xiaomai.ageny.unbundle.unbundle_shanghu;

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
import com.xiaomai.ageny.unbundle.UnbundleFaileActivity;
import com.xiaomai.ageny.unbundle.UnbundleSuccessActivity;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.contract.UnbundleShanghuContract;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.presenter.UnbundleShanghuPresenter;
import com.xiaomai.ageny.utils.CountDownTimerUtils;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.HideUtil;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UnbundleShanghuActivity extends BaseMvpActivity<UnbundleShanghuPresenter> implements UnbundleShanghuContract.View {


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
    @BindView(R.id.storename)
    TextView storename;
    @BindView(R.id.reason)
    EditText reason;

    private String id, name, tel;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private Bundle bundle;
    private CustomDialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbundle_shanghu;
    }

    @Override
    public void initView() {
        bundle = new Bundle();
        mPresenter = new UnbundleShanghuPresenter();
        mPresenter.attachView(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("sellerId");
            name = bundle.getString("sellerName");
            tel = bundle.getString("mobile");
            linktel.setText(HideUtil.hideMobile(tel));
            storename.setText(name);
        }
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
                    ContactDetailsActivity.instance.finish();
                }
            }, 1000);

        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_unbundle, R.id.bt_getCode})
    public void onViewClicked(View view) {
        String strvercode = inputCode.getText().toString().trim();
        String strReson = reason.getText().toString().trim();
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_unbundle:
                if (TextUtils.isEmpty(strvercode) || TextUtils.isEmpty(strReson)) {
                    TextUtils.isEmpty("请输入验证码或者解绑原因");
                } else {
                    keyList.add("sellerId");
                    keyList.add("sellerName");
                    keyList.add("captca");
                    keyList.add("mobile");
                    keyList.add("unbundlingReason");

                    valueList.add(id);
                    valueList.add(name);
                    valueList.add(strvercode);
                    valueList.add(tel);
                    valueList.add(strReson);

                    mPresenter.unbundleContanctBean(MaptoJson.toJsonZero(keyList, valueList));
                }
                break;
            case R.id.bt_getCode:
                //获取验证码
                mPresenter.getCode(tel);
                break;
        }
    }

}
