package com.xiaomai.ageny.shop_manage.fragment.shopnote;

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
import com.xiaomai.ageny.details.shop_note_details.ShopNoteDetailsActivity;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.contract.ShopNoteContract;
import com.xiaomai.ageny.shop_manage.fragment.shopnote.presenter.ShopNotePresenter;
import com.xiaomai.ageny.shop_manage.goshop.GoShopActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ShopNote_Fragment extends BaseMvpFragment<ShopNotePresenter> implements ShopNoteContract.View {
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_shop)
    TextView btShop;
    Unbinder unbinder;
    private List<String> list;
    private Adapter adapter;

    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        list.add("批次：第一次采购");
        list.add("批次：第一次采购");
        list.add("批次：第一次采购");
        list.add("批次：第一次采购");
        list.add("批次：第一次采购");
        list.add("批次：第一次采购");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.shop_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(), ShopNoteDetailsActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.shopnote_fragment;
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


    @OnClick(R.id.bt_shop)
    public void onViewClicked() {
        toClass(getActivity(),GoShopActivity.class);
    }
}
