package com.xiaomai.ageny.details.contactdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.MainActivity;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addcontact.AddContactActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ContactDetailsBean;
import com.xiaomai.ageny.bean.ContactUserInfoBean;
import com.xiaomai.ageny.details.contactdetails.contract.ContactDetailsContract;
import com.xiaomai.ageny.details.contactdetails.presenter.ContactDetailsPresenter;
import com.xiaomai.ageny.shanghudevice.ShanghuDeviceActivity;
import com.xiaomai.ageny.unbundle.unbundle_shanghu.UnbundleShanghuActivity;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ContactDetailsActivity extends BaseMvpActivity<ContactDetailsPresenter> implements ContactDetailsContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_unbundle)
    TextView btUnbundle;
    @BindView(R.id.bt_shanghudevice)
    RelativeLayout btShanghudevice;
    @BindView(R.id.rent)
    TextView rent;
    @BindView(R.id.rentting)
    TextView rentting;
    @BindView(R.id.off_line)
    TextView offLine;
    @BindView(R.id.on_line)
    TextView onLine;
    @BindView(R.id.updateuserinfo)
    RelativeLayout updateuserinfo;
    @BindView(R.id.yesterday_money)
    TextView yesterdayMoney;
    @BindView(R.id.all_money)
    TextView allMoney;
    @BindView(R.id.month_money)
    TextView monthMoney;
    @BindView(R.id.today_money)
    TextView todayMoney;
    @BindView(R.id.deviceId)
    TextView deviceId;
    @BindView(R.id.storename)
    TextView storename;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.addtime)
    TextView addtime;
    @BindView(R.id.otherview)
    OtherView otherView;

    private Bundle bundle;
    private String id, strStorename, strLinkName, strLinkTel, strAdress, strYingye, strPersoncount;
    public static ContactDetailsActivity instance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_contact_details;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        instance=this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        bundle = new Bundle();
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        id = getIntent().getExtras().getString("id");
        Logger.d("id-----"+id);
        mPresenter = new ContactDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);
        mPresenter.getUserInfo(id, "");
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(id);
                mPresenter.getUserInfo(id, "");
            }
        });
    }

    @Override
    public void showLoading() {
        otherView.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherView.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(ContactDetailsBean bean) {
        if (bean.getCode() == 1) {
            ContactDetailsBean.DataBean data = bean.getData();
            allMoney.setText(data.getTotal_earn());
            yesterdayMoney.setText(data.getYestoday_earn());
            todayMoney.setText(data.getDay_earn());
            monthMoney.setText(data.getMonth_earn());
            rent.setText("待租借：" + data.getNoRentCount() + "个");
            rentting.setText("租借中：" + data.getRentCount() + "个");
            offLine.setText("离线：" + data.getOffLineCount() + "台");
            onLine.setText("在线：" + data.getOnLineCount() + "台");
            deviceId.setText("编号：" + id);

        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccess(ContactUserInfoBean userInfoBean) {
        if (userInfoBean.getCode() == 1) {
            strStorename = userInfoBean.getData().getName();
            strLinkName = userInfoBean.getData().getLinkman();
            strLinkTel = userInfoBean.getData().getLinktel();
            strAdress = userInfoBean.getData().getAddress();
            strYingye = userInfoBean.getData().getOpenTime();
            strPersoncount = userInfoBean.getData().getPersonCost();

            storename.setText("商户名称：" + strStorename);
            name.setText("联系人：" + strLinkName);
            tel.setText("联系方式：" + strLinkTel);
            addtime.setText("添加时间：" + userInfoBean.getData().getCreateTimestr());
        }else {
            ToastUtil.showShortToast(userInfoBean.getMessage());
        }

    }


    @OnClick({R.id.back, R.id.bt_shanghudevice, R.id.bt_unbundle, R.id.updateuserinfo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_shanghudevice:
                bundle.putString("id", id);
                toClass(this, ShanghuDeviceActivity.class, bundle);
                break;
            case R.id.bt_unbundle:
                bundle.putString("sellerId", id);
                bundle.putString("sellerName", strStorename);
                bundle.putString("mobile", strLinkTel);

                toClass(this, UnbundleShanghuActivity.class, bundle);
                break;
            case R.id.updateuserinfo:
                bundle.putInt("isadd", 2);
                bundle.putString("id", id);
                bundle.putString("storename", strStorename);
                bundle.putString("strLinkName", strLinkName);
                bundle.putString("strLinkTel", strLinkTel);
                bundle.putString("strAdress", strAdress);
                bundle.putString("strYingye", strYingye);
                bundle.putString("strPersoncount", strPersoncount);
                toClass(this, AddContactActivity.class, bundle);
                break;
        }
    }

}
