package com.xiaomai.ageny.details.dailidetails;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addagency.update.UpdateAgencyActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.details.dailidetails.contract.DailiDetailsContract;
import com.xiaomai.ageny.details.dailidetails.presenter.DailiDetailsPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.XiaJiSH_ListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DailiDetailsActivity extends BaseMvpActivity<DailiDetailsPresenter> implements DailiDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.device_more)
    RelativeLayout deviceMore;
    @BindView(R.id.off_line)
    TextView offLine;
    @BindView(R.id.on_line)
    TextView onLine;
    @BindView(R.id.shanghu_more)
    RelativeLayout shanghuMore;
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
    @BindView(R.id.storeCount)
    TextView storeCount;
    @BindView(R.id.orderCount)
    TextView orderCount;
    @BindView(R.id.orderMoney)
    TextView orderMoney;
    @BindView(R.id.tag_go1)
    ImageView tagGo1;
    @BindView(R.id.agencyId)
    TextView agencyId;
    @BindView(R.id.fenrun)
    TextView fenrun;
    @BindView(R.id.linkname)
    TextView linkname;
    @BindView(R.id.linktel)
    TextView linktel;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.add_time)
    TextView addTime;
    @BindView(R.id.firmName)
    TextView firmName;
    @BindView(R.id.firmView)
    LinearLayout firmView;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.index_device_allcount)
    TextView indexDeviceAllcount;
    @BindView(R.id.bt_lookorder)
    TextView btLookOrder;
    private String id, strFenrun, strLinkName, strLinkTel, strAddress, strAddTime, strFirmName;
    private int isperson;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_daili_details;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        id = getIntent().getExtras().getString("id");
        mPresenter = new DailiDetailsPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(id);
                mPresenter.getHisSeller(id);
                mPresenter.getAgencyUserInfo(id);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData(id);
        mPresenter.getHisSeller(id);
        mPresenter.getAgencyUserInfo(id);
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
    public void onSuccess(AgencyDetailsBean bean) {
        if (bean.getCode() == 1) {
            AgencyDetailsBean.DataBean data = bean.getData();
            yesterdayMoney.setText(data.getYestoday_earn());
            allMoney.setText(data.getTotal_earn());
            monthMoney.setText(data.getMonth_earn());
            todayMoney.setText(data.getDay_earn());
            offLine.setText(data.getOffLineCount());
            onLine.setText(data.getOnLineCount());
            indexDeviceAllcount.setText((Integer.valueOf(data.getOnLineCount()) + Integer.valueOf(data.getOffLineCount())) + "");
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @Override
    public void onSuccess(HisSellerBean bean) {
        if (bean.getCode() == 1) {
            storeCount.setText("商户总数：" + bean.getData().getSellercount() + "家");
            orderCount.setText("订单总量：" + bean.getData().getOrdercount() + "个");
            orderMoney.setText("订单总金额：" + bean.getData().getMoney() + "元");
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @Override
    public void onSuccess(AgencyUserInfoBean bean) {
        if (bean.getCode() == 1) {
            AgencyUserInfoBean.DataBean data = bean.getData();
            strFenrun = data.getReward() + "";
            strLinkName = data.getRealname();
            strLinkTel = data.getMobile();
            strAddress = data.getArea();
            strAddTime = data.getCreateTimeStr();
            strFirmName = data.getCompanyName();

            agencyId.setText("编号：" + id);
            fenrun.setText("分润比例：" + strFenrun + "%");
            linkname.setText("联系人：" + strLinkName);
            linktel.setText("联系方式：" + strLinkTel);
            address.setText("负责区域：" + strAddress);
            addTime.setText("添加时间：" + strAddTime);

            if (data.getUserType() == 0) {
                //个人
                firmView.setVisibility(View.GONE);
                isperson = 1;
            } else {
                //企业
                firmName.setText("企业名称：" + strFirmName);
                firmView.setVisibility(View.VISIBLE);
                isperson = 2;
            }
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.device_more, R.id.shanghu_more, R.id.updateuserinfo,R.id.bt_lookorder})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.device_more:
                bundle.putString("id", id);
                toClass(this, XiaJiSH_ListActivity.class, bundle);
                break;
            case R.id.shanghu_more:
                bundle.putString("id", id);
                toClass(this, XiaJiSH_ListActivity.class, bundle);
                break;
            case R.id.updateuserinfo:
                bundle.putString("id", id);
                bundle.putString("fenrun", strFenrun);
                bundle.putString("linkname", strLinkName);
                bundle.putString("linktel", strLinkTel);
                bundle.putString("address", strAddress);
                bundle.putString("firmname", strFirmName);
                bundle.putInt("isperson", isperson);
                toClass(this, UpdateAgencyActivity.class, bundle);
                break;
            case R.id.bt_lookorder:
                break;
        }
    }

}
