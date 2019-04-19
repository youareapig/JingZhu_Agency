package com.xiaomai.ageny.details.devicedetails.indirectdetails;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.OffIndirectDeivceDetailsBean;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.adapter.Adapter;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.contract.IndirectDetailsContract;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.presenter.IndirectDetailsPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndirectDetailsActivity extends BaseMvpActivity<IndirectDetailsPresenter> implements IndirectDetailsContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.deviceId)
    TextView deviceId;
    @BindView(R.id.getname)
    TextView getname;
    @BindView(R.id.tel)
    TextView tel;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.liuzhuanView)
    LinearLayout liuzhuanView;
    private Adapter adapter;
    private List<OffIndirectDeivceDetailsBean.DataBean.ListBean> list;
    private String id;

    @Override
    public int getLayoutId() {
        return R.layout.activity_indirect_details;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        id = getIntent().getStringExtra("id");
        mPresenter = new IndirectDetailsPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);
        Logger.d("id---" + id);

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

    }

    @Override
    public void onSuccess(OffIndirectDeivceDetailsBean bean) {
        if (bean.getCode() == 1) {
            deviceId.setText(id);
            getname.setText(bean.getData().getLingquren());
            tel.setText(bean.getData().getLingqurenmobile());
            time.setText(bean.getData().getFenpeitime());

            list = bean.getData().getList();
            if (list.size()==0){
                liuzhuanView.setVisibility(View.GONE);
            }else {
                liuzhuanView.setVisibility(View.VISIBLE);
                recycler.setNestedScrollingEnabled(false);
                recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                adapter = new Adapter(R.layout.indirectdetails_item, list);
                recycler.setAdapter(adapter);
                adapter.openLoadAnimation();
            }

        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
