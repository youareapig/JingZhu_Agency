package com.xiaomai.ageny.device_popu;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_popu.contract.DevicePopuContract;
import com.xiaomai.ageny.device_popu.presenter.DevicePopuPresenter;
import com.xiaomai.ageny.utils.SpacesItemDecoration;
import com.xiaomai.ageny.utils.SpacesItemDecoration_left;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

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
    @BindView(R.id.otherview)
    OtherView otherView;
    private List<String> list;
    private Adapter adapter;
    private String id;
    private int slotId=1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_popu;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        otherView.setHolder(mHolder);
        mPresenter = new DevicePopuPresenter();
        mPresenter.attachView(this);
        mPresenter.getData(id);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {
        Logger.d("错误");
    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            finish();
        }
        ToastUtil.showShortToast(bean.getMessage());

    }

    @Override
    public void onSuccess(final ShowHoleBean bean) {
        if (bean.getCode() == 1) {
            list = new ArrayList<>();
            int kongcount = bean.getData();
            for (int i = 1; i <= kongcount; i++) {
                list.add(i + "孔");
            }

        }
        recycler.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recycler.addItemDecoration(new SpacesItemDecoration_left(90));
        recycler.setNestedScrollingEnabled(false);
        adapter = new Adapter(R.layout.device_pop_item, list);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter1, View view, int position) {
                slotId = position + 1;
                adapter.setSelectItem(position);
                adapter.notifyDataSetChanged();
            }
        });
    }


    @OnClick({R.id.back, R.id.bt_sure_pop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_sure_pop:
                mPresenter.popu(id, slotId + "");
                break;
        }
    }
}
