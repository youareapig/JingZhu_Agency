package com.xiaomai.ageny.order.fragment.myorder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.order.fragment.myorder.contract.MyOrderContract;
import com.xiaomai.ageny.order.fragment.myorder.presenter.MyOrderPresenter;
import com.xiaomai.ageny.details.orderdetails.myorderdetails.MyOrderDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class MyOderFragment extends BaseMvpFragment<MyOrderPresenter> implements MyOrderContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;

    private List<String> list;
    private Adapter adapter;

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.order_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(), MyOrderDetailsActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.myorder_fragment;
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

}
