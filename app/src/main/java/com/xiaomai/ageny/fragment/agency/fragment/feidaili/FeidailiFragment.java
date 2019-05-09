package com.xiaomai.ageny.fragment.agency.fragment.feidaili;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.details.feidailidetails.FeiDailiDetailsActivity;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.contract.FeidailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.feidaili.presenter.FeidailiPresenter;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jpush.android.api.JPushInterface;

public class FeidailiFragment extends BaseMvpFragment<FeidailiPresenter> implements FeidailiContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    private Adapter adapter;
    private List<DailiListBean.DataBean.ListBean> list;
    private Bundle bundle;
    private String strLev = "", strID = "";

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        mPresenter = new FeidailiPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", strID, strLev, "0", "");
            }
        });

        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getData_Fresh("", strID, strLev, "0", "");
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
    public void onStart() {
        super.onStart();
        strLev = SharedPreferencesUtil.getInstance(getActivity()).getSP("zhishuLev");
        strID = SharedPreferencesUtil.getInstance(getActivity()).getSP("zhishuId");

        mPresenter.getData("", strID, strLev, "0", "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.feidaili_fragment;
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
    public void onSuccess(DailiListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess_Fresh(DailiListBean bean) {
        initData(bean);
    }

    private void initData(DailiListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.feidaili_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getId());
                    toClass(view.getContext(), FeiDailiDetailsActivity.class, bundle);
                }
            });
        } else if (bean.getCode() == -10) {
            restLoginDialog();
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    //重新登录
    private void restLoginDialog() {
        final AlertDialog builder = new AlertDialog.Builder(getActivity()).create();
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_other_login, null);
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();
        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtil.getInstance(getActivity()).putSP("token", "");
                toClass_Empty(getActivity(), LoginActivity.class);
                getActivity().finish();
                JPushInterface.deleteAlias(getActivity(), 1);
                builder.dismiss();
            }
        });
    }
}
