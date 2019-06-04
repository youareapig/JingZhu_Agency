package com.xiaomai.ageny.offline.fragment.direct;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.OffDirectDeviceBean;
import com.xiaomai.ageny.offline.fragment.direct.adapter.Adapter;
import com.xiaomai.ageny.offline.fragment.direct.contract.DirectContract;
import com.xiaomai.ageny.offline.fragment.direct.presenter.DirectPresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class DirectFragment extends BaseMvpFragment<DirectPresenter> implements DirectContract.View {
    @BindView(R.id.offline_num)
    TextView offlineNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private String strTel = "", strID = "", strName = "";
    private Adapter adapter;
    private List<OffDirectDeviceBean.DataBean.ListBeanX.ListBean> list = new ArrayList<>();
    private String msgId;
    private int page = 1;

    public DirectFragment(String msgId) {
        this.msgId = msgId;
    }

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new DirectPresenter();
        mPresenter.attachView(this);
        strTel = SharedPreferencesUtil.getInstance(getActivity()).getSP("offzhishuTel");
        strID = SharedPreferencesUtil.getInstance(getActivity()).getSP("offzhishuId");
        strName = SharedPreferencesUtil.getInstance(getActivity()).getSP("offzhishuName");

        mPresenter.getData(strName, strTel, strID, "", msgId, "1", App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strName, strTel, strID, "", msgId, "1", App.pageSize);
            }
        });
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                mPresenter.getDataFresh(strName, strTel, strID, "", msgId, "1", App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getDataLoadMore(strName, strTel, strID, "", msgId, page + "", App.pageSize);
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.direct_fragment;
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
        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(OffDirectDeviceBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(OffDirectDeviceBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccessLoadMore(OffDirectDeviceBean bean) {
        refreshLayout.finishLoadMore();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList().get(0).getList());
            //延迟更新数据，避免卡顿
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyItemRangeChanged(0, bean.getData().getList().get(0).getList().size());
                }
            }, 500);
            if (bean.getData().getList().get(0).getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    private void initData(OffDirectDeviceBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().getList().get(0).getCountlinxianbox());
            list.addAll(bean.getData().getList().get(0).getList());
            if (list.size() == 0) {
                otherView.showEmptyView();
                refreshLayout.setCanLoadMore(false);
            } else {
                refreshLayout.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.direct_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }
}
