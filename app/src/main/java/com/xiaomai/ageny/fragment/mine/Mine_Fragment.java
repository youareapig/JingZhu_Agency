package com.xiaomai.ageny.fragment.mine;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.UserInfoBean;
import com.xiaomai.ageny.deposit_list.DepositListActivity;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.device_popu.DevicePopuActivity;
import com.xiaomai.ageny.device_popu.DevicePopuZxingActivity;
import com.xiaomai.ageny.fragment.mine.contract.MineContract;
import com.xiaomai.ageny.fragment.mine.presenter.MinePresenter;
import com.xiaomai.ageny.mybill.MyBillActivity;
import com.xiaomai.ageny.setting.SettingActivity;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Mine_Fragment extends BaseMvpFragment<MinePresenter> implements MineContract.View {
    @BindView(R.id.bt_device_manage)
    RelativeLayout btDeviceManage;
    @BindView(R.id.bt_deposit_list)
    RelativeLayout btDepositList;
    @BindView(R.id.bt_myorder)
    RelativeLayout btMyorder;
    @BindView(R.id.bt_popup)
    RelativeLayout btPopup;
    @BindView(R.id.bt_setting)
    RelativeLayout btSetting;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.userlevel)
    TextView userlevel;
    @BindView(R.id.userid)
    TextView userid;
    @BindView(R.id.usertel)
    TextView usertel;
    @BindView(R.id.usertype)
    TextView usertype;
    @BindView(R.id.userscale)
    TextView userscale;
    @BindView(R.id.otherview)
    OtherView otherView;

    @Override
    protected void initView(View view) {
        otherView.setHolder(mHolder);
        mPresenter = new MinePresenter();
        mPresenter.attachView(this);
        mPresenter.getData();
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine_fragment;
    }

    @Override
    public void showLoading() {
        otherView.showLoadingView();
    }

    @Override
    public void hideLoading() {
        otherView.showContentView();
    }

    @Override
    public void onError(Throwable throwable) {
        otherView.showRetryView();
    }

    @Override
    public void onSuccess(UserInfoBean bean) {
        if (bean.getCode() == 1) {
            UserInfoBean.DataBean data = bean.getData();
            username.setText(data.getRealname());
            userlevel.setText(data.getLevel_name());
            userid.setText("编号：" + data.getAgent_number());
            usertel.setText("绑定手机：" + data.getMobile());
            usertype.setText(data.getParent_name());
            userscale.setText(data.getReward());
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.bt_device_manage, R.id.bt_deposit_list, R.id.bt_myorder, R.id.bt_popup, R.id.bt_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_device_manage:
                toClass(getActivity(), DeviceManageActivity.class);
                break;
            case R.id.bt_deposit_list:
                toClass(getActivity(), DepositListActivity.class);
                break;
            case R.id.bt_myorder:
                toClass(getActivity(), MyBillActivity.class);
                break;
            case R.id.bt_popup:
                MPermissions.requestPermissions(this, 4, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE);
                break;
            case R.id.bt_setting:
                toClass(getActivity(), SettingActivity.class);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(4)
    public void requestCameraSuccess_4() {
        Intent intent = new Intent(getActivity(), DevicePopuZxingActivity.class);
        startActivityForResult(intent, 4);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 4) {
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    toClass(getActivity(), DevicePopuActivity.class);
                    Logger.d("解析成功结果:" + result);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Logger.d("解析失败");
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
