package com.xiaomai.ageny.deposit;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addbank.DepositSuccessActivity;
import com.xiaomai.ageny.addbank.BankActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.deposit.contract.DepositContract;
import com.xiaomai.ageny.deposit.presenter.DepositPresenter;

import butterknife.BindView;
import butterknife.OnClick;

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

    @Override
    public int getLayoutId() {
        return R.layout.activity_deposit;
    }

    @Override
    public void initView() {
        //设置hint字体的大小
        SpannableString ss = new SpannableString("请输入金额");//定义hint的值
        AbsoluteSizeSpan ass = new AbsoluteSizeSpan(18, true);//设置字体大小 true表示单位是sp
        ss.setSpan(ass, 0, ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        etMoney.setHint(new SpannedString(ss));
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


    @OnClick({R.id.back, R.id.bt_addbank, R.id.bt_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_addbank:
                toClass(this, BankActivity.class);
                break;
            case R.id.bt_sure:
                toClass1(this, DepositSuccessActivity.class);
                break;
        }
    }
}
