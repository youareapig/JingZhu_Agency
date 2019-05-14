package com.xiaomai.ageny.addbank;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addbank.contract.BankContract;
import com.xiaomai.ageny.addbank.presenter.BankPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BankActivity extends BaseMvpActivity<BankPresenter> implements BankContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.banktype)
    EditText banktype;
    @BindView(R.id.bankid)
    EditText bankid;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.bt_save)
    TextView btSave;

    private String strBank, strBankId, strName, strTel;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_back;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        mPresenter = new BankPresenter();
        mPresenter.attachView(this);
    }

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
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            ToastUtil.showShortToast(bean.getMessage());
            finish();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_save:
                strBank = banktype.getText().toString().trim();
                strBankId = bankid.getText().toString().trim();
                strName = name.getText().toString().trim();
                strTel = tel.getText().toString().trim();
                if (TextUtils.isEmpty(strBank) || TextUtils.isEmpty(strBankId) || TextUtils.isEmpty(strName) || TextUtils.isEmpty(strTel)) {
                    ToastUtil.showShortToast("请完善资料");
                } else {
                    keyList.add("creditCard");
                    keyList.add("bank");
                    keyList.add("mobile");
                    keyList.add("realName");

                    valueList.add(strBankId);
                    valueList.add(strBank);
                    valueList.add(strTel);
                    valueList.add(strName);
                    mPresenter.addBank(MaptoJson.toJsonZero(keyList, valueList));
                }
                break;
        }
    }
}
