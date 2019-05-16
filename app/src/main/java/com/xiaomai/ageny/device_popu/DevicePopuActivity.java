package com.xiaomai.ageny.device_popu;

import android.app.Dialog;
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
import com.xiaomai.ageny.bean.PopDeviceBean;
import com.xiaomai.ageny.bean.ShowHoleBean;
import com.xiaomai.ageny.device_manage.device_withdraw.DeviceWithDrawListActivity;
import com.xiaomai.ageny.device_popu.contract.DevicePopuContract;
import com.xiaomai.ageny.device_popu.presenter.DevicePopuPresenter;
import com.xiaomai.ageny.utils.CountDownTimerUtilsPop;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.SpacesItemDecoration_left;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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
    @BindView(R.id.deviceId)
    TextView deviceId;
    private List<String> list;
    private Adapter adapter;
    private String id;
    private int slotId = 1;
    private Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_popu;
    }

    @Override
    public void initView() {
        id = getIntent().getExtras().getString("id");
        list = (List<String>) getIntent().getExtras().getSerializable("mlist");
        Logger.d("孔数集合" + list.size());
        deviceId.setText("设备编号：" + id);
        otherView.setHolder(mHolder);
        mPresenter = new DevicePopuPresenter();
        mPresenter.attachView(this);
        initData();
    }

    private void initData() {
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

    @Override
    public void showLoading() {
        dialog = DialogUtils.showDialog_progressbar(this);
    }

    @Override
    public void hideLoading() {
        DialogUtils.closeDialog(dialog);
    }

    @Override
    public void onError(Throwable throwable) {
        DialogUtils.closeDialog(dialog);
        Logger.d("错误");
    }

    @Override
    public void onSuccess(PopDeviceBean bean) {
        if (bean.getCode() == 1) {
            ShowDialogUtils.showdialog(this, "弹出指令已发出，请稍等~");
            CountDownTimerUtilsPop mCountDownTimerUtils = new CountDownTimerUtilsPop(btSurePop, 10000, 1000);
            mCountDownTimerUtils.start();

        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

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
