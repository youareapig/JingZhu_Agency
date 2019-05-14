package com.xiaomai.ageny.system_notice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.BillListBean;
import com.xiaomai.ageny.bean.SystemNoticeBean;
import com.xiaomai.ageny.details.devicedetails.directdetails.DirectDetailsActivity;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.IndirectDetailsActivity;
import com.xiaomai.ageny.system_notice.contract.SystemNoticeContract;
import com.xiaomai.ageny.system_notice.presenter.SystemNoticePresenter;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SystemNoticeActivity extends BaseMvpActivity<SystemNoticePresenter> implements SystemNoticeContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private List<SystemNoticeBean.DataBean.ListBean> list = new ArrayList<>();
    private Adapter adapter;
    private int page = 1;
    private Bundle bundle = new Bundle();

    @Override
    public int getLayoutId() {
        return R.layout.activity_system_notice;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mPresenter = new SystemNoticePresenter();
        mPresenter.attachView(this);
        mPresenter.getData("1", App.pageSize);

        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("1", App.pageSize);
            }
        });
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getData("1", App.pageSize);
                        refreshLayout.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        mPresenter.getDataFresh(page + "", App.pageSize);
                        refreshLayout.finishLoadMore();
                    }
                }, 1000);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getData("1", App.pageSize);
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
    public void onSuccess(SystemNoticeBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherview.showEmptyView();
                refreshLayout.setCanLoadMore(false);
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.system_notice_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    //type 0遗失  1找回  2离线  3下级代理遗失  4下级代理找回
                    int type = list.get(position).getType();
                    Intent intent = new Intent();
                    if (list.get(position).getMessage().indexOf("下级") > 0) {
                        //标题包含下级  跳转非直属详情
                        intent.setClass(view.getContext(), IndirectDetailsActivity.class);
                    } else {
                        //不包含下级   跳转直属详情
                        intent.setClass(view.getContext(), DirectDetailsActivity.class);
                    }
                    intent.putExtra("id", list.get(position).getDeviceId());
                    intent.putExtra("msgid", list.get(position).getId() + "");
                    view.getContext().startActivity(intent);
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @Override
    public void onSuccessFresh(SystemNoticeBean bean) {
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
            if (bean.getData().getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            } else {
                ToastUtil.showShortToast(bean.getMessage());
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }


}
