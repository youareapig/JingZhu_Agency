package com.xiaomai.ageny.details.devcie_freeze_details;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.bean.FreezeDetailsBean;
import com.xiaomai.ageny.details.devcie_freeze_details.contract.DeviceFreezeDetailsContract;
import com.xiaomai.ageny.details.devcie_freeze_details.presenter.DeviceFreezeDetailsPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceFreezDetailsActivity extends BaseMvpActivity<DeviceFreezeDetailsPresenter> implements DeviceFreezeDetailsContract.View {
    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.deviceId)
    TextView deviceId;
    @BindView(R.id.storename)
    TextView storename;
    @BindView(R.id.devicestate)
    TextView devicestate;
    @BindView(R.id.chiyouren)
    TextView chiyouren;
    @BindView(R.id.installman)
    TextView installman;
    @BindView(R.id.freeze_money)
    TextView freezeMoney;
    @BindView(R.id.freezedmoney)
    TextView freezedmoney;
    @BindView(R.id.nofreezemoney)
    TextView nofreezemoney;
    @BindView(R.id.freezetime)
    TextView freezetime;
    @BindView(R.id.returntime)
    TextView returntime;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    private String id, state;
    private List<FreezeDetailsBean.DataBean.ListBean> list;
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_freez_details;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        id = getIntent().getExtras().getString("id");
        state = getIntent().getExtras().getString("state");
        mPresenter = new DeviceFreezeDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);
        mPresenter.getData(state, id, "");
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
    public void onSuccess(FreezeDetailsBean bean) {
        //代理关系列表
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.device_freeze_details_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccess(FreezeBean bean) {
        //基本资料
        if (bean.getCode() == 1) {
            FreezeBean.DataBean.ListBean data = bean.getData().getList().get(0);
            deviceId.setText(data.getDeviceid());
            storename.setText(data.getSellerName());
            devicestate.setText(data.getIsFreeze().endsWith("1") ? "未解冻" : (data.getIsFreeze().endsWith("2") ? "已解冻" : "已回款"));
            chiyouren.setText(data.getSellerName());
            installman.setText(data.getInstallMan());
            freezeMoney.setText(data.getFreezeMoney() + "元");
            freezedmoney.setText(data.getUnfreezeMoney() + "元");
            nofreezemoney.setText(data.getNofreezeMoney() + "元");
            freezetime.setText(data.getUnfreezeTime());
            returntime.setText(data.getRemitTime());

        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
