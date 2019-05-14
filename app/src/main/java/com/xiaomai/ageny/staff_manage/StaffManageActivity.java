package com.xiaomai.ageny.staff_manage;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.xiaomai.ageny.MainActivity;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.add_staff.AddStaffActivity;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.StaffBean;
import com.xiaomai.ageny.staff_manage.contract.StaffManageContract;
import com.xiaomai.ageny.staff_manage.presenter.StaffManagePresenter;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.SwipeItemLayout;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StaffManageActivity extends BaseMvpActivity<StaffManagePresenter> implements StaffManageContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_addstaff)
    LinearLayout btAddstaff;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    private Adapter adapter;
    private List<StaffBean.DataBean.ListBean> list;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private AlertDialog builder;
    private int pos;

    @Override
    public int getLayoutId() {
        return R.layout.activity_staff_manage;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        mPresenter = new StaffManagePresenter();
        mPresenter.attachView(this);
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getStaffListBean("", "");
            }
        });
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getStaffListBeanFresh("", "");
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
        mPresenter.getStaffListBean("", "");
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
    public void onSuccess(StaffBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccessFresh(StaffBean bean) {
        initData(bean);
    }

    private void initData(StaffBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData().getList();
            if (list.size() == 0) {
                otherView.showEmptyView();
            }
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setNestedScrollingEnabled(false);
            //左滑删除
            recycler.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
            adapter = new Adapter(R.layout.staff_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    pos = position;
                    myDialog();
                }
            });
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            list.remove(pos);
            adapter.notifyItemRemoved(pos);
            builder.dismiss();
            ToastUtil.showShortToast(bean.getMessage());
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }else {
            ToastUtil.showShortToast(bean.getMessage());
            builder.dismiss();
        }
    }


    @OnClick({R.id.back, R.id.bt_addstaff})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_addstaff:
                toClass(this, AddStaffActivity.class);
                break;
        }
    }

    private void myDialog() {
        builder = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_staff_delete, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        view.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyList.add("id");
                valueList.add(list.get(pos).getId());
                mPresenter.staffDelete(MaptoJson.toJsonZero(keyList, valueList));
            }
        });
        view.findViewById(R.id.bt_think).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        });


    }
}
