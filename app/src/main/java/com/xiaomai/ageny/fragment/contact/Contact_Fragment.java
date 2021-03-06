package com.xiaomai.ageny.fragment.contact;

import android.app.AlertDialog;
import android.content.Intent;
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
import com.xiaomai.ageny.addcontact.AddContactActivity;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.details.contactdetails.ContactDetailsActivity;
import com.xiaomai.ageny.filter.contactfilter.ContactFilterActivity;
import com.xiaomai.ageny.fragment.contact.contract.ContactContract;
import com.xiaomai.ageny.fragment.contact.presenter.ContactPresenter;
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

public class Contact_Fragment extends BaseMvpFragment<ContactPresenter> implements ContactContract.View {
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.add_time)
    TextView addTime;
    @BindView(R.id.make_money)
    TextView makeMoney;
    @BindView(R.id.totle_count)
    TextView totleCount;
    @BindView(R.id.add_icon)
    ImageView addIcon;
    @BindView(R.id.make_money_icon)
    ImageView makeMoneyIcon;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;
    private String strFilter_ID = "", strFilter_Tel = "";
    private static final int RECODE = 1;
    private Adapter adapter;
    private List<ContactListBean.DataBean.ListBean> list = new ArrayList<>();

    private Bundle bundle;
    private boolean rank_makeMoney = true;
    private boolean rank_addTime = true;
    private int page = 1;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        makeMoney.setSelected(true);
        makeMoneyIcon.setImageResource(R.mipmap.sort_hover);

        bundle = new Bundle();
        mPresenter = new ContactPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(strFilter_Tel, strFilter_ID, "4", "1", App.pageSize);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData(strFilter_Tel, strFilter_ID, "4", "1", App.pageSize);
            }
        });
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                page = 1;
                makeMoney.setSelected(true);
                makeMoneyIcon.setImageResource(R.mipmap.sort_hover);
                addTime.setSelected(false);
                addIcon.setImageResource(R.mipmap.sort_hover_hui);
                mPresenter.getData_Fresh(strFilter_Tel, strFilter_ID, "4", "1", App.pageSize);
            }

            @Override
            public void loadMore() {
                page++;
                mPresenter.getData_LoadMore(strFilter_Tel, strFilter_ID, "4", page + "", App.pageSize);
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.contact_fragment;
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
    public void onSuccess(ContactListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess_Fresh(ContactListBean bean) {
        refreshLayout.finishRefresh();
        initData(bean);
    }

    @Override
    public void onSuccess_LoadMore(ContactListBean bean) {
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

    private void initData(ContactListBean bean) {
        list.clear();
        if (bean.getCode() == 1) {
            list.addAll(bean.getData().getList());
            if (list.size() == 0) {
                otherView.showEmptyView();
                refreshLayout.setCanLoadMore(false);
            } else {
                refreshLayout.setCanLoadMore(true);
            }
            totleCount.setText("共：" + bean.getData().getTotal() + "家");
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            adapter = new Adapter(R.layout.contact_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getId());
                    toClass(view.getContext(), ContactDetailsActivity.class, bundle);
                }
            });

        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(getActivity());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.bt_filter, R.id.bt_add, R.id.add_time, R.id.make_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_filter:
                bundle.putString("tel", strFilter_Tel);
                bundle.putString("id", strFilter_ID);
                toClass(getActivity(), ContactFilterActivity.class, bundle, RECODE);
                break;
            case R.id.bt_add:
                bundle.putInt("isadd", 1);
                toClass(getActivity(), AddContactActivity.class, bundle, RECODE);
                break;
            case R.id.add_time:
                addTime.setSelected(true);
                makeMoney.setSelected(false);
                makeMoneyIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_addTime) {
                    addIcon.setImageResource(R.mipmap.sort_hove);
                    mPresenter.getData_Fresh(strFilter_Tel, strFilter_ID, "2", "1", App.pageSize);
                    rank_addTime = false;
                } else {
                    addIcon.setImageResource(R.mipmap.sort_hover);
                    mPresenter.getData_Fresh(strFilter_Tel, strFilter_ID, "1", "1", App.pageSize);
                    rank_addTime = true;
                }
                break;
            case R.id.make_money:
                addTime.setSelected(false);
                makeMoney.setSelected(true);
                addIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_makeMoney) {
                    makeMoneyIcon.setImageResource(R.mipmap.sort_hove);
                    mPresenter.getData_Fresh(strFilter_Tel, strFilter_ID, "3", "1", App.pageSize);
                    rank_makeMoney = false;
                } else {
                    makeMoneyIcon.setImageResource(R.mipmap.sort_hover);
                    mPresenter.getData_Fresh(strFilter_Tel, strFilter_ID, "4", "1", App.pageSize);
                    rank_makeMoney = true;
                }

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        page = 1;
        if (requestCode == RECODE && resultCode == 2) {
            strFilter_ID = data.getStringExtra("id");
            strFilter_Tel = data.getStringExtra("tel");
            mPresenter.getData(strFilter_Tel, strFilter_ID, "4", "1", App.pageSize);
            Logger.d("返回值" + strFilter_Tel + "  " + strFilter_ID);
        } else if (requestCode == RECODE && resultCode == 3) {
            mPresenter.getData(strFilter_Tel, strFilter_ID, "4", "1", App.pageSize);
        }
    }


}
