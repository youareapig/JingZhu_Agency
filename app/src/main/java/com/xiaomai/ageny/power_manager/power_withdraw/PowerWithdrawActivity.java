package com.xiaomai.ageny.power_manager.power_withdraw;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.power_manager.power_allot.PowerAllotActivity;
import com.xiaomai.ageny.power_manager.power_allot_next.PowerAllotNextActivity;
import com.xiaomai.ageny.power_manager.power_withdraw.contract.PowerWithdrawContract;
import com.xiaomai.ageny.power_manager.power_withdraw.presenter.PowerWithdrawPresenter;
import com.xiaomai.ageny.power_manager.power_zxing.power_allote_zxing.PowerAlloteZxingActivity;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.PowerWithdrawZxingActivity;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.SwipeItemLayout;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerWithdrawActivity extends BaseMvpActivity<PowerWithdrawPresenter> implements PowerWithdrawContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_withdraw)
    TextView btWithdraw;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.otherview)
    OtherView otherview;
    @BindView(R.id.bt_saoyisao)
    TextView btSaoyisao;
    @BindView(R.id.device_num)
    TextView deviceNum;

    private Adapter adapter;
    private List<DeviceDao> list;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    private Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_withdraw;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        mPresenter = new PowerWithdrawPresenter();
        mPresenter.attachView(this);
        daoSession = DaoSessionManager.getInstace()
                .getDaoSession(this);
        //查询所有数据
        deviceDaoDao = daoSession.getDeviceDaoDao();
        list = deviceDaoDao.loadAll();
        if (list.size() == 0) {
            otherview.showEmptyView();
        }
        deviceNum.setText(list.size() + "");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        adapter = new Adapter(R.layout.power_withdraw_item, list);
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
        dialog = DialogUtils.showDialog_progressbar(this);
    }

    @Override
    public void hideLoading() {
        DialogUtils.closeDialog(dialog);
    }

    @Override
    public void onError(Throwable throwable) {
        DialogUtils.closeDialog(dialog);
    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            deviceDaoDao.deleteAll();
            ShowDialogUtils.showdialog(this, "充电宝撤回成功");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_withdraw, R.id.bt_saoyisao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                if (list.size() != 0) {
                    myDialog();
                } else {
                    finish();
                }
                break;
            case R.id.bt_withdraw:
                if (list.size() == 0) {
                    ToastUtil.showShortToast("请添加设备");
                } else {
                    sureWithdraw();
                }
                break;
            case R.id.bt_saoyisao:
                MPermissions.requestPermissions(this, 91, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(91)
    public void openSuccess91() {
        Bundle mBundle = new Bundle();
        mBundle.putString("fromact", "2");
        toClass(this, PowerWithdrawZxingActivity.class, mBundle);
        finish();
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

    private void sureWithdraw() {
        final AlertDialog builder = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_power_withdraw, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        TextView content = view.findViewById(R.id.dialog_content);
        content.setText("您已选中" + list.size() + "个充电宝," + "\n" + "是否确认撤回?");
        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
                //确定撤回，调用撤回接口
                mPresenter.getData(MaptoJson.toJson(list, ""));
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
