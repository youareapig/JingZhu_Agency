package com.xiaomai.ageny.fragment.contact;

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
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addcontact.AddContactActivity;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ContactListBean;
import com.xiaomai.ageny.details.contactdetails.ContactDetailsActivity;
import com.xiaomai.ageny.filter.contactfilter.ContactFilterActivity;
import com.xiaomai.ageny.fragment.contact.contract.ContactContract;
import com.xiaomai.ageny.fragment.contact.presenter.ContactPresenter;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Contact_Fragment extends BaseMvpFragment<ContactPresenter> implements ContactContract.View {
    @BindView(R.id.bt_filter)
    TextView btFilter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    Unbinder unbinder;
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

    private Adapter adapter;
    private List<ContactListBean.DataBean.ListBean> list;

    private Bundle bundle;
    private boolean rank_makeMoney = true;
    private boolean rank_addTime = true;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        makeMoney.setSelected(true);
        makeMoneyIcon.setImageResource(R.mipmap.sort_hover);

        bundle = new Bundle();
        mPresenter = new ContactPresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData("", "", "4");
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        makeMoney.setSelected(true);
                        makeMoneyIcon.setImageResource(R.mipmap.sort_hover);
                        addTime.setSelected(false);
                        addIcon.setImageResource(R.mipmap.sort_hover_hui);
                        mPresenter.getData_Fresh("", "", "");
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
        mPresenter.getData("", "", "4");
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
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(ContactListBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess_Fresh(ContactListBean bean) {
        initData(bean);
    }

    private void initData(ContactListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            totleCount.setText("共：" + list.size() + "家");
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

        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.bt_filter, R.id.bt_add, R.id.add_time, R.id.make_money})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_filter:
                toClass(getActivity(), ContactFilterActivity.class);
                break;
            case R.id.bt_add:
                bundle.putInt("isadd", 1);
                toClass(getActivity(), AddContactActivity.class, bundle);
                break;
            case R.id.add_time:
                addTime.setSelected(true);
                makeMoney.setSelected(false);
                makeMoneyIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_addTime) {
                    addIcon.setImageResource(R.mipmap.sort_hove);
                    mPresenter.getData_Fresh("", "", "2");
                    rank_addTime = false;
                } else {
                    addIcon.setImageResource(R.mipmap.sort_hover);
                    mPresenter.getData_Fresh("", "", "1");
                    rank_addTime = true;
                }
                break;
            case R.id.make_money:
                addTime.setSelected(false);
                makeMoney.setSelected(true);
                addIcon.setImageResource(R.mipmap.sort_hover_hui);
                if (rank_makeMoney) {
                    makeMoneyIcon.setImageResource(R.mipmap.sort_hove);
                    mPresenter.getData_Fresh("", "", "3");
                    rank_makeMoney = false;
                } else {
                    makeMoneyIcon.setImageResource(R.mipmap.sort_hover);
                    mPresenter.getData_Fresh("", "", "4");
                    rank_makeMoney = true;
                }

                break;
        }
    }

}
