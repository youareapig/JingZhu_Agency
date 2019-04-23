package com.xiaomai.ageny.details.shop_note_details;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.ShopBean;
import com.xiaomai.ageny.details.shop_note_details.contract.ShopNoteDetailsContract;
import com.xiaomai.ageny.details.shop_note_details.presenter.ShopNoteDetailsPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopNoteDetailsActivity extends BaseMvpActivity<ShopNoteDetailsPresenter> implements ShopNoteDetailsContract.View {

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
    @BindView(R.id.small_num_fahuo)
    TextView smallNumFahuo;
    @BindView(R.id.small_num_weifahuo)
    TextView smallNumWeifahuo;
    @BindView(R.id.big_num_fahuo)
    TextView bigNumFahuo;
    @BindView(R.id.big_num_weifahuo)
    TextView bigNumWeifahuo;
    @BindView(R.id.paytype)
    TextView paytype;
    @BindView(R.id.remark)
    TextView remark;
    @BindView(R.id.otherview)
    OtherView otherview;

    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_note_details;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        otherview.setHolder(mHolder);
        mPresenter = new ShopNoteDetailsPresenter();
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
            smallNumFahuo.setText(data.getDeviceSmallDelivery());
            smallNumWeifahuo.setText(data.getDeviceSmallNodelivery());
            bigNumFahuo.setText(data.getDeviceBigDelivery());
            bigNumWeifahuo.setText(data.getDeviceBigNodelivery());
            paytype.setText(data.getPayment());
            remark.setText(data.getExamination());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
