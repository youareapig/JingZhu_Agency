package com.xiaomai.ageny.device_manage.device_allot.device_allot_list;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.AllotFirstBean;
import com.xiaomai.ageny.bean.AllotSecondBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_zxing.DeviceAllotZxingActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.DeviceAllotAgencyActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.contract.DeviceAllotListContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.presenter.DeviceAllotListPresenter;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.SwipeItemLayout;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;


public class DeviceAllotListActivity extends BaseMvpActivity<DeviceAllotListPresenter> implements DeviceAllotListContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_next)
    TextView btNext;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.bt_saoyisao)
    TextView btSaoyisao;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.otherview)
    OtherView otherView;
    private List<DeviceDao> list;
    private Adapter adapter;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    public static DeviceAllotListActivity instance;
    private AlertDialog builder;
    private int pos;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_allot_list;
    }

    @Override
    public void initView() {
        otherView.setHolder(mHolder);
        instance = this;
        daoSession = DaoSessionManager.getInstace()
                .getDaoSession(this);
        //查询所有数据
        deviceDaoDao = daoSession.getDeviceDaoDao();
        list = deviceDaoDao.loadAll();
        if (list.size() == 0) {
            otherView.showEmptyView();
        }
        num.setText(list.size() + "");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        adapter = new Adapter(R.layout.device_allot_item, list);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                pos = position;
                myDialog1();
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

    @OnClick({R.id.back, R.id.bt_next, R.id.bt_saoyisao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                myDialog();
                break;
            case R.id.bt_next:
                if (list.size() == 0) {
                    ToastUtil.showShortToast("请添加设备");
                } else {
                    toClass(this, DeviceAllotAgencyActivity.class);
                }

                break;

            case R.id.bt_saoyisao:
                MPermissions.requestPermissions(this, 4, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //点击完返回键，执行的动作
            myDialog();
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
                //删除所有数据
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(4)
    public void requestCameraSuccess_2() {
        Intent intent = new Intent(this, DeviceAllotZxingActivity.class);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //继续扫描
//        if (requestCode == 3) {
//            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Logger.d("解析成功结果:" + result);
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Logger.d("解析失败");
//                }
//            }
//        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void myDialog1() {
        builder = new AlertDialog.Builder(this).create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_staff_delete, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        view.findViewById(R.id.bt_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deviceDaoDao.delete(list.get(pos));

                list.remove(pos);
                adapter.notifyItemRemoved(pos);
                if (list.size() == 0) {
                    otherView.showEmptyView();
                }
                builder.dismiss();
            }
        });
        view.findViewById(R.id.bt_think).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        });


    }
}
