package com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze;

import android.annotation.SuppressLint;
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
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.FreezeBean;
import com.xiaomai.ageny.details.devcie_freeze_details.DeviceFreezDetailsActivity;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.Adapter;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.contract.NoFreezeContract;
import com.xiaomai.ageny.device_manage.device_freeze.fragment.nofreeze.presenter.NoFreezePresenter;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NoFreeze_Fragment extends BaseMvpFragment<NoFreezePresenter> implements NoFreezeContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private Adapter adapter;
    private List<FreezeBean.DataBean.ListBean> list;
    private CallBackListener callBackListener;
    private Bundle bundle;
    private String strId, strState;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        otherView.setHolder(mHolder);
        //初始化接口
        callBackListener = (CallBackListener) getActivity();
        mPresenter = new NoFreezePresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("1", strId, strState);
            }
        });

        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mPresenter.getDataFresh("1", strId, strState);
            }

            @Override
            public void loadMore() {
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        strId = SharedPreferencesUtil.getInstance(getActivity()).getSP("freezed_id");
        strState = SharedPreferencesUtil.getInstance(getActivity()).getSP("freezed_state");
        switch (strState) {
            case "直属":
                strState = "1";
                break;
            case "非直属":
                strState = "0";
                break;
        }
        mPresenter.getData("1", strId, strState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.nofreeze_fragment;
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

    public interface CallBackListener {
        void callback(String nofreeze_device, String nofreeze_momney);
    }

    @Override
    public void onSuccess(FreezeBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(FreezeBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    private void initData(FreezeBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            callBackListener.callback(bean.getData().getCount(), bean.getData().getUnfreeze_money());
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.freeze_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getDeviceid());
                    bundle.putString("state", "1");
                    toClass(view.getContext(), DeviceFreezDetailsActivity.class, bundle);
                }
            });
        }else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

}
