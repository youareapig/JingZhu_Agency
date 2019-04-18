package com.xiaomai.ageny.xiajishanghu.xiajishanghulist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.AgencySellerListBean;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.xiajishanghu.xiajishanghu_devicelist.XiajiSHDeviceListActivity;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.contract.XiajiSHContract;
import com.xiaomai.ageny.xiajishanghu.xiajishanghulist.presenter.XiajiSHPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiaJiSH_ListActivity extends BaseMvpActivity<XiajiSHPresenter> implements XiajiSHContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherView;

    private List<AgencySellerListBean.DataBean> list;
    private Adapter adapter;
    private String id;
    private Bundle bundle;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xia_ji_sh__list;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        bundle = new Bundle();
        id = getIntent().getExtras().getString("id");
        mPresenter = new XiajiSHPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);

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

    }

    @Override
    public void onSuccess(AgencySellerListBean bean) {
        if (bean.getCode() == 1) {
            list = bean.getData();
            adapter = new Adapter(R.layout.xiaji_item, list);
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getSellerId());
                    toClass(view.getContext(), XiajiSHDeviceListActivity.class, bundle);
                }
            });
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


    @OnClick(R.id.back)
    public void onViewClicked() {
    }
}
