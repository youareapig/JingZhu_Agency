package com.xiaomai.ageny.device_manage.device_noallot;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.NoAllotDeviceBean;
import com.xiaomai.ageny.device_manage.device_noallot.contract.DeviceNoAllotContract;
import com.xiaomai.ageny.device_manage.device_noallot.presenter.DeviceNoAllotPresenter;
import com.xiaomai.ageny.filter.device_noallot_filter.DeviceNoAllotFilterActivity;
import com.xiaomai.ageny.utils.DateUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceNoAllotActivity extends BaseMvpActivity<DeviceNoAllotPresenter> implements DeviceNoAllotContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.device_all_num)
    TextView deviceAllNum;
    @BindView(R.id.device_noallot)
    TextView deviceNoallot;
    @BindView(R.id.device_allot)
    TextView deviceAllot;
    @BindView(R.id.otherview1)
    OtherView otherview1;
    @BindView(R.id.otherview)
    OtherView otherview;
    private List<NoAllotDeviceBean.DataBean> list;
    private Adapter adapter;
    private String strAll, strAllot, strNoallot;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_no_allot;
    }

    @Override
    public void initView() {

        Bundle bundle = getIntent().getExtras();
        strAll = bundle.getString("all");
        strAllot = bundle.getString("allot");
        strNoallot = bundle.getString("noallot");
        deviceAllNum.setText(strAll);
        deviceAllot.setText(strAllot);
        deviceNoallot.setText(strNoallot);

        OtherViewHolder holder = new OtherViewHolder(this);
        otherview.setHolder(mHolder);
        otherview1.setHolder(holder);
        mPresenter = new DeviceNoAllotPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("");
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("");
            }
        });
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
    public void onSuccess(NoAllotDeviceBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherview1.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.device_no_allot_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


    @OnClick({R.id.back, R.id.bt_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_filter:
                toClass(this, DeviceNoAllotFilterActivity.class);
                break;
        }
    }

}
