package com.xiaomai.ageny.device_manage.device_allot.device_allot_list;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.device_manage.device_allot.DeviceAllotZxingActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.DeviceAllotAgencyActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.contract.DeviceAllotListContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.presenter.DeviceAllotListPresenter;
import com.xiaomai.ageny.device_manage.device_withdraw.DeviceWithDrawListActivity;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private List<String> list;
    private Adapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_allot_list;
    }

    @Override
    public void initView() {
        list = new ArrayList<>();
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        list.add("JZCB0191000288");
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new Adapter(R.layout.device_allot_item, list);
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


    @OnClick({R.id.back, R.id.bt_next, R.id.recycler, R.id.bt_saoyisao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                break;
            case R.id.bt_next:
                toClass(this, DeviceAllotAgencyActivity.class);
                break;
            case R.id.recycler:
                break;
            case R.id.bt_saoyisao:
                MPermissions.requestPermissions(this, 4, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
        }
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
        if (requestCode == 3) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Logger.d("解析成功结果:" + result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Logger.d("解析失败");
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
