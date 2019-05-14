package com.xiaomai.ageny.details.device_alloted_details;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigman.wmzx.customcardview.library.CardView;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.DeviceAllotedDetailsBean;
import com.xiaomai.ageny.details.device_alloted_details.contract.DeviceAllotedDetailsContract;
import com.xiaomai.ageny.details.device_alloted_details.presenter.DeviceAllotedDetailsPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceAllotedDetailsActivity extends BaseMvpActivity<DeviceAllotedDetailsPresenter> implements DeviceAllotedDetailsContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.deviceId)
    TextView deviceId;
    @BindView(R.id.getname)
    TextView getname;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.device_state)
    TextView deviceState;
    @BindView(R.id.stoptime)
    TextView stoptime;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.liuzhuanView)
    CardView liuzhuanView;
    @BindView(R.id.otherview)
    OtherView otherview;
    private Adapter adapter;
    private String id;
    private List<DeviceAllotedDetailsBean.DataBean.ListBean> list;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_alloted_details;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        id = getIntent().getStringExtra("id");
        mPresenter = new DeviceAllotedDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);
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
    public void onSuccess(DeviceAllotedDetailsBean bean) {
        if (bean.getCode()==1){
            deviceId.setText(id);
            getname.setText(bean.getData().getLingquren());
            tel.setText(bean.getData().getLingqurenmobile());
            time.setText(bean.getData().getFenpeitime());
            deviceState.setText(bean.getData().getBushu());
            stoptime.setText(bean.getData().getZhiliutime());

            list = bean.getData().getList();
            if (list.size() == 0) {
                liuzhuanView.setVisibility(View.GONE);
            } else {
                liuzhuanView.setVisibility(View.VISIBLE);
                recycler.setNestedScrollingEnabled(false);
                recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                adapter = new Adapter(R.layout.indirectdetails_item, list);
                recycler.setAdapter(adapter);
                adapter.openLoadAnimation();
            }
        }else if (bean.getCode()==-10){
            ShowDialogUtils.restLoginDialog(this);
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }

}


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
