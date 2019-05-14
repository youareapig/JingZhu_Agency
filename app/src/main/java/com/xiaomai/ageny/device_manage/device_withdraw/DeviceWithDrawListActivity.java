package com.xiaomai.ageny.device_manage.device_withdraw;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.device_manage.device_withdraw.contract.DeviceWithDrawListContract;
import com.xiaomai.ageny.device_manage.device_withdraw.presenter.DeviceWithDrawListPresenter;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceWithDrawListActivity extends BaseMvpActivity<DeviceWithDrawListPresenter> implements DeviceWithDrawListContract.View {

    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_sure_withdraw)
    TextView btSureWithdraw;
    @BindView(R.id.id)
    TextView id;
    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.tel)
    TextView tel;

    private String strid, strname, strtel, strtype;
    private Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_with_draw_list;
    }

    @Override
    public void initView() {
        strid = getIntent().getExtras().getString("id");
        strname = getIntent().getExtras().getString("name");
        strtel = getIntent().getExtras().getString("tel");
        strtype = getIntent().getExtras().getString("type");
        id.setText(strid);
        name.setText(strname);
        tel.setText(strtel);
        type.setText(strtype);
        mPresenter = new DeviceWithDrawListPresenter();
        mPresenter.attachView(this);
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
            ShowDialogUtils.showdialog(this, "设备撤回成功");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
//                    DeviceManageActivity.instance.finish();
                }
            }, 1000);

        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.bt_sure_withdraw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_sure_withdraw:
                mPresenter.getData(strid);
                break;
        }
    }


}
