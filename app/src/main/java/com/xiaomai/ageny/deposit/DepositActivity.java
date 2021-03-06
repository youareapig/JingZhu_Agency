package com.xiaomai.ageny.deposit;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addbank.BankActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.deposit.contract.DepositContract;
import com.xiaomai.ageny.deposit.presenter.DepositPresenter;
import com.xiaomai.ageny.update_bank.UpdateBankActivity;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.HideUtil;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class DepositActivity extends BaseMvpActivity<DepositPresenter> implements DepositContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.tv_tixian_money)
    TextView tvTixianMoney;
    @BindView(R.id.tv_tixian_dongjie)
    TextView tvTixianDongjie;
    @BindView(R.id.banktype)
    TextView banktype;
    @BindView(R.id.bankid)
    TextView bankid;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.view_bank)
    LinearLayout viewBank;
    @BindView(R.id.bt_addbank)
    TextView btAddbank;
    @BindView(R.id.view_addbank)
    LinearLayout viewAddbank;
    @BindView(R.id.tx_tixian_yuan)
    TextView txTixianYuan;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.bt_sure)
    TextView btSure;
    @BindView(R.id.service_money)
    TextView serviceMoney;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.updatebank)
    RelativeLayout updateBank;

    private String strprice, strcardid, strbank, strtel, strname;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private Bundle bundle;
    private Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public void initView() {
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        //设置hint字体的大小
        SpannableString ss = new SpannableString("请输入金额");//定义hint的值
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(18, true);//设置字体大小 true表示单位是sp
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        etMoney.setHint(new SpannedString(ss));
        mPresenter = new DepositPresenter();
        mPresenter.attachView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData();
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
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(IndexBean bean) {
        if (bean.getCode() == 1) {
            strcardid = bean.getData().getCreditCard();
            strbank = bean.getData().getBank();
            strtel = bean.getData().getMobile();
            strname = bean.getData().getRealName();
            tvTixianMoney.setText(bean.getData().getUnliquidated());
            tvTixianDongjie.setText(bean.getData().getFreeze_money());

            if (TextUtils.isEmpty(strbank)) {
                viewAddbank.setVisibility(View.VISIBLE);
                viewBank.setVisibility(View.GONE);
            } else {
                viewAddbank.setVisibility(View.GONE);
                viewBank.setVisibility(View.VISIBLE);
                banktype.setText(strbank);
                bankid.setText(HideUtil.hideCardNo(strcardid));
                name.setText(strname);
                tel.setText(HideUtil.hideMobile(strtel));
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessDeposit(HintBean bean) {
        if (bean.getCode() == 1) {
            ShowDialogUtils.showdialog(this, "提现成功~");
            //提现成功后刷新当前界面
            mPresenter.getData();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnTextChanged(R.id.et_money)
    public void onTextChanged(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            serviceMoney.setText("0");
        } else {
            double money = Double.valueOf(text.toString());
            double servicemoney = money * 0.001;
            if (servicemoney < 1) {
                servicemoney = 1;
            }
            serviceMoney.setText(BaseUtils.formatDouble4(servicemoney));
        }

    }

    @OnClick({R.id.back, R.id.bt_addbank, R.id.bt_sure, R.id.updatebank})

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_addbank:
                toClass(this, BankActivity.class);
                break;
            case R.id.bt_sure:
                strprice = etMoney.getText().toString().trim();
                if (TextUtils.isEmpty(strbank)) {
                    ToastUtil.showShortToast("请先添加银行卡");
                } else {
                    if (TextUtils.isEmpty(strprice)) {
                        ToastUtil.showShortToast("请输入提现金额");
                    } else {
                        keyList.add("money");
                        keyList.add("type");
                        keyList.add("credit_card");
                        keyList.add("bank");
                        keyList.add("mobile");
                        keyList.add("real_name");

                        valueList.add(strprice);
                        valueList.add("2");
                        valueList.add(strcardid);
                        valueList.add(strbank);
                        valueList.add(strtel);
                        valueList.add(strname);
                        mPresenter.getDepositBean(MaptoJson.toJsonZero(keyList, valueList));
                    }
                }
                break;
            case R.id.updatebank:
                //修改信息
                bundle.putString("banktype", strbank);
                bundle.putString("bankid", strcardid);
                bundle.putString("name", strname);
                bundle.putString("tel", strtel);
                toClass(this, UpdateBankActivity.class, bundle);
                break;
        }
    }
}
