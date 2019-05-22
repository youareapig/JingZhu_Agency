package com.xiaomai.ageny.power_manager.power_allot;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.DeviceAllotAgencyActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.DeviceAllotZxingActivity;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.power_manager.power_allot.contract.PowerAllotContract;
import com.xiaomai.ageny.power_manager.power_allot.presenter.PowerAllotPresenter;
import com.xiaomai.ageny.power_manager.power_allot_next.PowerAllotNextActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.PowerAlloteZxingActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.PowerWithdrawZxingActivity;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerAllotActivity extends BaseMvpActivity<PowerAllotPresenter> implements PowerAllotContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_next)
    TextView btNext;
    @BindView(R.id.device_num)
    TextView deviceNum;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.bt_saoyisao)
    TextView btSaoyisao;
    private List<DeviceDao> list;
    private Adapter adapter;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    public static PowerAllotActivity instance;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_allot;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        instance = this;
        daoSession = DaoSessionManager.getInstace()
                .getDaoSession(this);
        //查询所有数据
        deviceDaoDao = daoSession.getDeviceDaoDao();
        list = deviceDaoDao.loadAll();
        if (list.size() == 0) {
            otherview.showEmptyView();
        }

        deviceNum.setText(list.size() + "");
        recycler.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.power_allot_item, list);
        recycler.setNestedScrollingEnabled(false);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                deviceDaoDao.delete(list.get(position));
                list.remove(position);
                adapter.notifyItemRemoved(position);
                deviceNum.setText(list.size() + "");
                if (list.size() == 0) {
                    otherview.showEmptyView();
                }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(93)
    public void openSuccess93() {
        Bundle mBundle = new Bundle();
        mBundle.putString("fromact", "2");
        toClass(this, PowerAlloteZxingActivity.class, mBundle);
        finish();
    }

    @OnClick({R.id.back, R.id.bt_next, R.id.bt_saoyisao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                if (list.size() != 0) {
                    myDialog();
                } else {
                    finish();
                }
                break;
            case R.id.bt_next:
                if (list.size() == 0) {
                    ToastUtil.showShortToast("请添加设备");
                } else {
                    toClass(this, PowerAllotNextActivity.class);
                }
                break;
            case R.id.bt_saoyisao:
                MPermissions.requestPermissions(this, 93, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //点击完返回键，执行的动作
            if (list.size() != 0) {
                myDialog();
            } else {
                finish();
            }
        }
        return true;
    }

    private void myDialog() {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_back, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
                deviceDaoDao.deleteAll();
                finish();
            }
        });
        view.findViewById(R.id.bt_cancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        });

    }
}
