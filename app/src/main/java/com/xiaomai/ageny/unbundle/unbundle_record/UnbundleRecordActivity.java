package com.xiaomai.ageny.unbundle.unbundle_record;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.UnbindRecordBean;
import com.xiaomai.ageny.filter.unbundle_record_filter.UnbundleRecordFilterActivity;
import com.xiaomai.ageny.unbundle.unbundle_record.contract.UnbundleRecordContract;
import com.xiaomai.ageny.unbundle.unbundle_record.presenter.UnbundleRecordPresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnbundleRecordActivity extends BaseMvpActivity<UnbundleRecordPresenter> implements UnbundleRecordContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    private Adapter adapter;
    private List<UnbindRecordBean.DataBean> list;
    private String strName = "", strTel = "";
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_unbundle_record;
    }

    @Override
    public void initView() {
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        mPresenter = new UnbundleRecordPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", "", strName, strTel);
            }
        });

        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getDataFresh("", "", strName, strTel);
                        refreshLayout.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData("", "", strName, strTel);
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
    public void onSuccess(UnbindRecordBean bean) {
        initData(bean);

    }

    @Override
    public void onSuccessFresh(UnbindRecordBean bean) {
        initData(bean);
    }

    private void initData(UnbindRecordBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.unbundle_record_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }else {
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
                bundle.putString("name", strName);
                bundle.putString("tel", strTel);
                toClass1(this, UnbundleRecordFilterActivity.class, bundle, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            strName = data.getStringExtra("name");
            strTel = data.getStringExtra("tel");
        }
    }
}
