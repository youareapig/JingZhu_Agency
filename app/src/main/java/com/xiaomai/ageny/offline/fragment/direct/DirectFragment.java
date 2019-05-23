package com.xiaomai.ageny.offline.fragment.direct;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
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
    private List<OffDirectDeviceBean.DataBean.ListBean> list;
    private String msgId;

    public DirectFragment(String msgId) {
        this.msgId = msgId;
    }

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new DirectPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strName, strTel, strID, "",msgId);
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getDataFresh(strName, strTel, strID, "",msgId);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        strTel = SharedPreferencesUtil.getInstance(getActivity()).getSP("offzhishuTel");
        strID = SharedPreferencesUtil.getInstance(getActivity()).getSP("offzhishuId");
        strName = SharedPreferencesUtil.getInstance(getActivity()).getSP("offzhishuName");


        mPresenter.getData(strName, strTel, strID, "",msgId);
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

    private void initData(OffDirectDeviceBean bean) {
        if (bean.getCode() == 1) {
            offlineNum.setText(bean.getData().get(0).getCountlinxianbox());
            list = bean.getData().get(0).getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
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
