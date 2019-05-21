package com.xiaomai.ageny.details.feidailidetails;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.AgencyDetailsBean;
import com.xiaomai.ageny.bean.AgencyUserInfoBean;
import com.xiaomai.ageny.bean.HisSellerBean;
import com.xiaomai.ageny.details.feidailidetails.contract.FeiDailiDetailsContract;
import com.xiaomai.ageny.details.feidailidetails.presenter.FeiDailiDetailsPresenter;
import com.xiaomai.ageny.order.order_list.OrderListActivity;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.XiaJiSH_ListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeiDailiDetailsActivity extends BaseMvpActivity<FeiDailiDetailsPresenter> implements FeiDailiDetailsContract.View {


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
    @BindView(R.id.today_money)
    TextView todayMoney;
    @BindView(R.id.month_money)
    TextView monthMoney;
    @BindView(R.id.storeCount)
    TextView storeCount;
    @BindView(R.id.orderCount)
    TextView orderCount;
    @BindView(R.id.orderMoney)
    TextView orderMoney;
    @BindView(R.id.agencyId)
    TextView agencyId;
    @BindView(R.id.linkname)
    TextView linkname;
    @BindView(R.id.add_time)
    TextView addTime;
    @BindView(R.id.all_money)
    TextView allMoney;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.index_device_allcount)
    TextView indexDeviceAllcount;
    @BindView(R.id.bt_lookorder)
    TextView btLookOrder;
    private String id;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_fei_daili_details;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        id = getIntent().getExtras().getString("id");
        mPresenter = new FeiDailiDetailsPresenter();
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
            agencyId.setText("编号：" + id);
            linkname.setText("联系人：" + bean.getData().getRealname());
            addTime.setText("添加时间：" + bean.getData().getCreateTimeStr());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.back, R.id.device_more, R.id.shanghu_more, R.id.updateuserinfo, R.id.bt_lookorder})
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
                break;
            case R.id.bt_lookorder:
                bundle.putString("id", id);
                toClass(this, OrderListActivity.class, bundle);
                break;
        }
    }

}
