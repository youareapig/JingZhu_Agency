package com.xiaomai.ageny.details.record_details;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.details.record_details.contract.RecordDetailsContract;
import com.xiaomai.ageny.details.record_details.presenter.RecordDetailsPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordDetailsActivity extends BaseMvpActivity<RecordDetailsPresenter> implements RecordDetailsContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.adress)
    TextView adress;
    @BindView(R.id.times)
    TextView times;
    @BindView(R.id.small_num)
    TextView smallNum;
    @BindView(R.id.big_num)
    TextView bigNum;
    @BindView(R.id.remark)
    TextView remark;
    @BindView(R.id.state)
    TextView state;
    @BindView(R.id.info)
    TextView info;
    @BindView(R.id.otherview)
    OtherView otherview;

    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_record_details;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        otherview.setHolder(mHolder);
        mPresenter = new RecordDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(id);
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
    public void onSuccess(ShopBean bean) {
        if (bean.getCode() == 1) {
            ShopBean.DataBean data = bean.getData();
            name.setText(data.getReceiptName());
            tel.setText(data.getReceiptMobile());
            adress.setText(data.getReceiptAddress());
            times.setText(data.getBatch());
            smallNum.setText(data.getDeviceSmallcount() + "台");
            bigNum.setText(data.getDeviceBigcount() + "台");
            remark.setText(data.getDetails());
            state.setText(data.getState().equals("1") ? "已通过" : (data.getState().equals("0") ? "审核中" : "未通过"));
            info.setText(data.getExamination());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
