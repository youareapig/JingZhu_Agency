package com.xiaomai.ageny.details.orderdetails.lowerorderdetails;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.LowerOrderDetailsBean;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.contract.LowerOrderDetailsContract;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.presenter.LowerOrderDetailsPresenter;
import com.xiaomai.ageny.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LowerOrderDetailsActivity extends BaseMvpActivity<LowerOrderDetailsPresenter> implements LowerOrderDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.orderId)
    TextView orderId;
    @BindView(R.id.orderstate)
    TextView orderstate;
    @BindView(R.id.earn)
    TextView earn;
    @BindView(R.id.rentname)
    TextView rentname;
    @BindView(R.id.returnname)
    TextView returnname;
    @BindView(R.id.renttime)
    TextView renttime;
    @BindView(R.id.returntime)
    TextView returntime;
    @BindView(R.id.rentadress)
    TextView rentadress;
    @BindView(R.id.returnadress)
    TextView returnadress;
    @BindView(R.id.rentdeviceId)
    TextView rentdeviceId;
    @BindView(R.id.returndeviceId)
    TextView returndeviceId;
    @BindView(R.id.zhishuname)
    TextView zhishuname;
    @BindView(R.id.zhishutel)
    TextView zhishutel;
    @BindView(R.id.suoshuname)
    TextView suoshuname;
    @BindView(R.id.suoshulevel)
    TextView suoshulevel;
    @BindView(R.id.rentduration)
    TextView rentduration;
    @BindView(R.id.rentmoney)
    TextView rentmoney;
    @BindView(R.id.discounts)
    TextView discounts;
    @BindView(R.id.pay)
    TextView pay;
    @BindView(R.id.creattime)
    TextView creattime;
    @BindView(R.id.paytime)
    TextView paytime;
    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_lower_order_details;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        mPresenter = new LowerOrderDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);
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
    public void onSuccess(LowerOrderDetailsBean bean) {
        if (bean.getCode() == 1) {
            LowerOrderDetailsBean.DataBean data = bean.getData();
            orderId.setText(data.getOrderid());
            // state 0为已完成 1进行中 -1待支付
            if (data.getState().equals("0")) {
                orderstate.setText("已完成");
            }
            if (data.getState().equals("1")) {
                orderstate.setText("进行中");
            }
            if (data.getState().equals("-1")) {
                orderstate.setText("待支付");
            }
            earn.setText(data.getEarn());
            rentname.setText(data.getSellername());
            returnname.setText(data.getReturnsellername());
            renttime.setText(data.getRenttime());
            returntime.setText(data.getReturntime());
            rentadress.setText(data.getRentaddress());
            returnadress.setText(data.getReturnaddress());
            rentdeviceId.setText(data.getDeviceid());
            returndeviceId.setText(data.getReturnboxid());
            rentduration.setText(data.getLeasetime());
            rentmoney.setText(data.getRentprice()+"元");
            discounts.setText(data.getDiscountprice()+"元");
            pay.setText(data.getRealpayment()+"元");
            creattime.setText(data.getRenttime());
            paytime.setText(data.getUpdTime());
            zhishuname.setText(data.getRealname());
            zhishutel.setText(data.getAgentmobile());
            suoshuname.setText(data.getAgentname());
            suoshulevel.setText(data.getLevel());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
