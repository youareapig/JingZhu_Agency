package com.xiaomai.ageny.shop_manage.goshop;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.shop_manage.goshop.contract.GoShopContract;
import com.xiaomai.ageny.shop_manage.goshop.presenter.GoShopPresenter;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class GoShopActivity extends BaseMvpActivity<GoShopPresenter> implements GoShopContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.input_times)
    EditText inputTimes;
    @BindView(R.id.input_name)
    EditText inputName;
    @BindView(R.id.input_tel)
    EditText inputTel;
    @BindView(R.id.input_adress)
    EditText inputAdress;
    @BindView(R.id.input_small)
    EditText inputSmall;
    @BindView(R.id.input_big)
    EditText inputBig;
    @BindView(R.id.rb_fenqi)
    RadioButton rbFenqi;
    @BindView(R.id.rb_once)
    RadioButton rbOnce;
    @BindView(R.id.input_remark)
    EditText inputRemark;
    @BindView(R.id.bt_submit)
    TextView btSubmit;
    @BindView(R.id.group)
    RadioGroup group;
    private String strTimes, strName, strTel, strAddress, strSmall, strBig, strRemark;
    private int payment = 1;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private CustomDialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_go_shop;
    }

    @Override
    public void initView() {
        mPresenter = new GoShopPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public void showLoading() {
        dialog=new CustomDialog(this);
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
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            finish();
        }
        ToastUtil.showShortToast(bean.getMessage());
    }


    @OnClick({R.id.back, R.id.bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_submit:
                strTimes = inputTimes.getText().toString().trim();
                strName = inputName.getText().toString().trim();
                strTel = inputTel.getText().toString().trim();
                strAddress = inputAdress.getText().toString().trim();
                strSmall = inputSmall.getText().toString().trim();
                strBig = inputBig.getText().toString().trim();
                strRemark = inputRemark.getText().toString().trim();
                if (TextUtils.isEmpty(strTimes) || TextUtils.isEmpty(strName) || TextUtils.isEmpty(strTel)
                        || TextUtils.isEmpty(strAddress) || TextUtils.isEmpty(strSmall) || TextUtils.isEmpty(strBig) || TextUtils.isEmpty(strRemark)) {
                    ToastUtil.showShortToast("请完善资料");
                } else {
                    keyList.add("receiptName");
                    keyList.add("receiptAddress");
                    keyList.add("receiptMobile");
                    keyList.add("batch");
                    keyList.add("devicesmall");
                    keyList.add("devicesmallcount");
                    keyList.add("payment");
                    keyList.add("details");
                    keyList.add("devicebig");
                    keyList.add("devicebigcount");

                    valueList.add(strName);
                    valueList.add(strAddress);
                    valueList.add(strTel);
                    valueList.add(strTimes);
                    valueList.add("6口5台");
                    valueList.add(strSmall);
                    valueList.add(payment == 1 ? "分期付款" : "一次性付款");
                    valueList.add(strRemark);
                    valueList.add("12口11台");
                    valueList.add(strBig);
                    mPresenter.getData(MaptoJson.toJsonZero(keyList, valueList));

                }
                break;
        }
    }


    @OnCheckedChanged({R.id.rb_fenqi, R.id.rb_once})
    public void onRadioCheck(CompoundButton view, boolean ischanged) {
        //1表示分期，2表示一次性
        switch (view.getId()) {
            case R.id.rb_fenqi:
                if (ischanged) {
                    payment = 1;
                }
                break;
            case R.id.rb_once:
                if (ischanged) {
                    payment = 2;
                }
                break;
        }
    }
}
