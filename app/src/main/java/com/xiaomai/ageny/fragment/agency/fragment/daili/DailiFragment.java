package com.xiaomai.ageny.fragment.agency.fragment.daili;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.DailiListBean;
import com.xiaomai.ageny.details.dailidetails.DailiDetailsActivity;
import com.xiaomai.ageny.fragment.agency.Agency_Fragment;
import com.xiaomai.ageny.fragment.agency.fragment.daili.contract.DailiContract;
import com.xiaomai.ageny.fragment.agency.fragment.daili.presenter.DailiPresenter;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.jpush.android.api.JPushInterface;

public class DailiFragment extends BaseMvpFragment<DailiPresenter> implements DailiContract.View {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.addTimeText)
    TextView addTimeText;
    @BindView(R.id.addTimeIcon)
    ImageView addTimeIcon;
    @BindView(R.id.moneyText)
    TextView moneyText;
    @BindView(R.id.moneyIcon)
    ImageView moneyIcon;
    @BindView(R.id.fenrunText)
    TextView fenrunText;
    @BindView(R.id.fenrunIcon)
    ImageView fenrunIcon;
    @BindView(R.id.totle_count)
    TextView totleCount;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    private Adapter adapter;
    private List<DailiListBean.DataBean.ListBean> list = new ArrayList<>();
    private boolean rank_makeMoney = true;
    private boolean rank_addTime = true;
    private boolean rank_fenrun = true;
    private Bundle bundle;
    private String strTel = "", strID = "";
    private int page = 1;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        moneyText.setSelected(true);
        mPresenter = new DailiPresenter();
        mPresenter.attachView(this);
        strTel = SharedPreferencesUtil.getInstance(getActivity()).getSP("feizhishuTel");
        strID = SharedPreferencesUtil.getInstance(getActivity()).getSP("feizhishuId");
        mPresenter.getData(strTel, strID, "", "1", "6", "1", App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strTel, strID, "", "1", "6", "1", App.pageSize);
            }
        });
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                moneyText.setSelected(true);
                moneyIcon.setImageResource(R.mipmap.sort_hover);
                addTimeIcon.setImageResource(R.mipmap.sort_hover_hui);
                addTimeText.setSelected(false);
                fenrunText.setSelected(false);
                fenrunIcon.setImageResource(R.mipmap.sort_hover_hui);
                mPresenter.getData_Fresh(strTel, strID, "", "1", "6", "1", App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getData_LoadMore(strTel, strID, "", "1", "6", page + "", App.pageSize);
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.daili_fragment;
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
    public void onSuccess(DailiListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess_Fresh(DailiListBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccess_LoadMore(DailiListBean bean) {
        refreshLayout.finishLoadMore();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            //延迟更新数据，避免卡顿
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    adapter.notifyItemRangeChanged(0, bean.getData().getList().size());
                }
            }, 500);
            if (bean.getData().getList().size() == 0) {
                ToastUtil.showShortToast("没有更多数据");
            }
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    private void initData(DailiListBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            totleCount.setText("共" + bean.getData().getTotal() + "家");
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherView.showEmptyView();
                refreshLayout.setCanLoadMore(false);
            } else {
                refreshLayout.setCanLoadMore(true);
            }
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.daili_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getId());
                    toClass(view.getContext(), DailiDetailsActivity.class, bundle);
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.addTimeText, R.id.moneyText, R.id.fenrunText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.addTimeText:
                addTimeText.setSelected(true);
                moneyText.setSelected(false);
                fenrunText.setSelected(false);
                moneyIcon.setImageResource(R.mipmap.sort_hover_hui);
                fenrunIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_addTime) {
                    addTimeIcon.setImageResource(R.mipmap.sort_hove);
                    rank_addTime = false;
                    mPresenter.getData_Fresh(strTel, strID, "", "1", "1", "1", App.pageSize);
                } else {
                    addTimeIcon.setImageResource(R.mipmap.sort_hover);
                    rank_addTime = true;
                    mPresenter.getData_Fresh(strTel, strID, "", "1", "2", "1", App.pageSize);
                }
                break;
            case R.id.moneyText:
                addTimeText.setSelected(false);
                moneyText.setSelected(true);
                fenrunText.setSelected(false);
                addTimeIcon.setImageResource(R.mipmap.sort_hover_hui);
                fenrunIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_makeMoney) {
                    moneyIcon.setImageResource(R.mipmap.sort_hove);
                    rank_makeMoney = false;
                    mPresenter.getData_Fresh(strTel, strID, "", "1", "5", "1", App.pageSize);
                } else {
                    moneyIcon.setImageResource(R.mipmap.sort_hover);
                    rank_makeMoney = true;
                    mPresenter.getData_Fresh(strTel, strID, "", "1", "6", "1", App.pageSize);
                }
                break;
            case R.id.fenrunText:
                addTimeText.setSelected(false);
                moneyText.setSelected(false);
                fenrunText.setSelected(true);
                addTimeIcon.setImageResource(R.mipmap.sort_hover_hui);
                moneyIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_fenrun) {
                    fenrunIcon.setImageResource(R.mipmap.sort_hove);
                    rank_fenrun = false;
                    mPresenter.getData_Fresh(strTel, strID, "", "1", "3", "1", App.pageSize);
                } else {
                    fenrunIcon.setImageResource(R.mipmap.sort_hover);
                    rank_fenrun = true;
                    mPresenter.getData_Fresh(strTel, strID, "", "1", "4", "1", App.pageSize);
                }
                break;
        }
    }

}
