package com.xiaomai.ageny.update_bank;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.update_bank.contract.UpdateBankContract;
import com.xiaomai.ageny.update_bank.presenter.UpdateBankPresenter;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateBankActivity extends BaseMvpActivity<UpdateBankPresenter> implements UpdateBankContract.View {


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
    private Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_bank;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        mPresenter = new UpdateBankPresenter();
        mPresenter.attachView(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            strBank = bundle.getString("banktype");
            strBankId = bundle.getString("bankid");
            strName = bundle.getString("name");
            strTel = bundle.getString("tel");
        }
        banktype.setText(strBank);
        bankid.setText(strBankId);
        name.setText(strName);
        tel.setText(strTel);
    }

    @Override
    public void showLoading() {
        dialog = DialogUtils.showDialog_progressbar(this);
    }

    @Override
    public void hideLoading() {
        DialogUtils.closeDialog(dialog);
    }

    @Override
    public void onError(Throwable throwable) {
        DialogUtils.closeDialog(dialog);
    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            ShowDialogUtils.showdialog(this, "资料修改成功~");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }else {
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

                keyList.add("creditCard");
                keyList.add("bank");
                keyList.add("mobile");
                keyList.add("realName");

                valueList.add(strBankId);
                valueList.add(strBank);
                valueList.add(strTel);
                valueList.add(strName);

                mPresenter.updateBank(MaptoJson.toJsonZero(keyList, valueList));
                break;
        }
    }
}
