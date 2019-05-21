package com.xiaomai.ageny.power_manager.power_withdraw;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.DeviceAllotZxingActivity;
import com.xiaomai.ageny.power_manager.power_withdraw.contract.PowerWithdrawContract;
import com.xiaomai.ageny.power_manager.power_withdraw.presenter.PowerWithdrawPresenter;
import com.xiaomai.ageny.power_manager.power_zxing.power_withdraw_zxing.PowerWithdrawZxingActivity;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.util.ArrayList;
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

    private List<String> list = new ArrayList<>();
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_withdraw;
    }

    @Override
    public void initView() {
        otherview.setHolder(mHolder);
        list.add("张三");
        list.add("张三");
        list.add("张三");
        adapter = new Adapter(R.layout.power_withdraw_item, list);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                list.remove(position);
                adapter.notifyItemRemoved(position);
                if (list.size() == 0) {
                    otherview.showEmptyView();
                }
            }
        });
        recycler.setNestedScrollingEnabled(false);
        recycler.setAdapter(adapter);
        adapter.openLoadAnimation();
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


    @OnClick({R.id.back, R.id.bt_withdraw, R.id.bt_saoyisao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                myDialog();
                break;
            case R.id.bt_withdraw:
                sureWithdraw();
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
        toClass(this, PowerWithdrawZxingActivity.class);
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
        View view = layoutInflater.inflate(R.layout.dialog_back, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
                //确定撤回，调用撤回接口
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
