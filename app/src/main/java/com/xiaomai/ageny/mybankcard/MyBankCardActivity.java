package com.xiaomai.ageny.mybankcard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addbank.BankActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.MyBankBean;
import com.xiaomai.ageny.mybankcard.contract.MyBankCardContract;
import com.xiaomai.ageny.mybankcard.presenter.MyBankCardPresenter;
import com.xiaomai.ageny.update_bank.UpdateBankActivity;
import com.xiaomai.ageny.utils.HideUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBankCardActivity extends BaseMvpActivity<MyBankCardPresenter> implements MyBankCardContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.banktype)
    TextView banktype;
    @BindView(R.id.bt_alterinfo)
    TextView btAlterinfo;
    @BindView(R.id.bankid)
    TextView bankid;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.bt_addbank)
    TextView btAddbank;
    @BindView(R.id.view_addbank)
    LinearLayout viewAddbank;
    @BindView(R.id.view_bank)
    RelativeLayout viewBank;

    private String strBank, strBankId, strName, strTel;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_bank_card;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        bundle = new Bundle();
        otherview.setHolder(mHolder);
        mPresenter = new MyBankCardPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData();
    }

    @Override
    public void showLoading() {
        otherview.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherview.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        otherview.showRetryView();
    }

    @Override
    public void onSuccess(MyBankBean bean) {
        if (bean.getCode() == 1) {
            if (TextUtils.isEmpty(bean.getData().getBank())) {
                viewBank.setVisibility(View.GONE);
                viewAddbank.setVisibility(View.VISIBLE);
            } else {
                strBank = bean.getData().getBank();
                strBankId = bean.getData().getCreditCard();
                strName = bean.getData().getRealName();
                strTel = bean.getData().getMobile();

                viewBank.setVisibility(View.VISIBLE);
                viewAddbank.setVisibility(View.GONE);
                banktype.setText(strBank);
                bankid.setText(HideUtil.hideCardNo(strBankId));
                name.setText(strName);
                tel.setText(HideUtil.hideMobile(strTel));
            }
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_alterinfo, R.id.bt_addbank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_alterinfo:
                //修改信息
                bundle.putString("banktype", strBank);
                bundle.putString("bankid", strBankId);
                bundle.putString("name", strName);
                bundle.putString("tel", strTel);
                toClass(this, UpdateBankActivity.class, bundle);
                break;
            case R.id.bt_addbank:
                //添加银行卡
                toClass(this, BankActivity.class);
                break;
        }
    }

}
