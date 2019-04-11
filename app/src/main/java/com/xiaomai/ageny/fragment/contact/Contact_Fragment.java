package com.xiaomai.ageny.fragment.contact;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addcontact.AddContactActivity;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.details.contactdetails.ContactDetailsActivity;
import com.xiaomai.ageny.filter.contactfilter.ContactFilterActivity;
import com.xiaomai.ageny.fragment.contact.contract.ContactContract;
import com.xiaomai.ageny.fragment.contact.presenter.ContactPresenter;

import java.util.ArrayList;
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
    private Adapter adapter;
    private List<String> list;

    private Bundle bundle;

    @Override
    protected void initView(View view) {
        bundle=new Bundle();
        list = new ArrayList<>();
        list.add("26");
        list.add("27");
        list.add("28");
        list.add("29");
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.contact_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                toClass(view.getContext(), ContactDetailsActivity.class);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.contact_fragment;
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


    @OnClick({R.id.bt_filter, R.id.bt_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_filter:
                toClass(getActivity(), ContactFilterActivity.class);
                break;
            case R.id.bt_add:
                bundle.putInt("isadd",1);
                toClass(getActivity(), AddContactActivity.class,bundle);
                break;
        }
    }
}
