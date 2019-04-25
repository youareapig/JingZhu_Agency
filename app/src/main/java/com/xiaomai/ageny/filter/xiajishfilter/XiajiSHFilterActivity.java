package com.xiaomai.ageny.filter.xiajishfilter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.filter.xiajishfilter.contract.XiajiSHFilterContract;
import com.xiaomai.ageny.filter.xiajishfilter.presenter.XiajiSHFilterPresenter;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiajiSHFilterActivity extends BaseMvpActivity<XiajiSHFilterPresenter> implements XiajiSHFilterContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    @BindView(R.id.id)
    EditText id;
    private List<String> list;
    private List<String> priceList = new ArrayList<>();
    private Adapter adapter;
    private String strId = "", strPrice = "";
    private int price = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_xiaji_shfilter;
    }

    @Override
    public void initView() {
        strId = SharedPreferencesUtil.getInstance(this).getSP("xiajiId");
        id.setText(strId);

        String configJson = SharedPreferencesUtil.getInstance(this).getSP("config");
        list = BaseUtils.getPriceList1(configJson);
        priceList.add("全部");
        priceList.addAll(list);

        recycler.setLayoutManager(new GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration(30));
        adapter = new Adapter(R.layout.myorderfilter_item, priceList);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                price = position;
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


    @OnClick({R.id.back, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.filter_bt_reset:
                id.setText("");
                adapter.setSelectItem(0);
                adapter.notifyDataSetChanged();
                break;
            case R.id.filter_bt_submit:
                strId = id.getText().toString().trim();
                SharedPreferencesUtil.getInstance(this).putSP("xiajiId", strId);
                SharedPreferencesUtil.getInstance(this).putSP("xiajiPrice", price == 0 ? "" : priceList.get(price));
                finish();
                break;
        }
    }
}
