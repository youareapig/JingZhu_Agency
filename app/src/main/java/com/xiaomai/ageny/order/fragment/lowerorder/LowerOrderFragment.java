package com.xiaomai.ageny.order.fragment.lowerorder;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.LowerOrderBean;
import com.xiaomai.ageny.bean.MyOrderBean;
import com.xiaomai.ageny.details.orderdetails.lowerorderdetails.LowerOrderDetailsActivity;
import com.xiaomai.ageny.order.fragment.lowerorder.contract.LowerOrderContract;
import com.xiaomai.ageny.order.fragment.lowerorder.presenter.LowerOrderPresenter;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LowerOrderFragment extends BaseMvpFragment<LowerOrderPresenter> implements LowerOrderContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    @BindView(R.id.orderTotleMoney)
    TextView orderTotleMoney;
    @BindView(R.id.earn)
    TextView earn;
    Unbinder unbinder1;
    private List<LowerOrderBean.DataBean.ListBean> list;
    private Adapter adapter;
    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle = new Bundle();
        mPresenter = new LowerOrderPresenter();
        mPresenter.attachView(this);
        mPresenter.getData("", "", "", "");

    }

    @Override
    protected int getLayoutId() {
        return R.layout.lowerorder_fragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(LowerOrderBean bean) {
        if (bean.getCode() == 1) {
            orderTotleMoney.setText(bean.getData().getCountRentPrice());
            earn.setText(bean.getData().getCountEarn());
            list = bean.getData().getList();
            recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            adapter = new Adapter(R.layout.order_item, list);
            recycler.setAdapter(adapter);
            adapter.openLoadAnimation();
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    bundle.putString("id", list.get(position).getOrderid());
                    toClass(view.getContext(), LowerOrderDetailsActivity.class, bundle);
                }
            });
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


}
