package com.xiaomai.ageny.device_popu;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_popu.contract.DevicePopuContract;
import com.xiaomai.ageny.device_popu.presenter.DevicePopuPresenter;
import com.xiaomai.ageny.utils.SpacesItemDecoration;
import com.xiaomai.ageny.utils.SpacesItemDecoration_left;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DevicePopuActivity extends BaseMvpActivity<DevicePopuPresenter> implements DevicePopuContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_sure_pop)
    TextView btSurePop;
    private List<String> list;
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_popu;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("1孔");
        list.add("2孔");
        list.add("3孔");
        list.add("4孔");
        list.add("5孔");
        list.add("6孔");
        list.add("7孔");
        list.add("8孔");
        list.add("9孔");
        list.add("10孔");
        list.add("11孔");
        list.add("12孔");
        recycler.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration_left(90));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.device_pop_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
            }
        });
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


    @OnClick({R.id.back, R.id.bt_sure_pop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_sure_pop:
                break;
        }
    }
}
