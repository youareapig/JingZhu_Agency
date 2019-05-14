package com.xiaomai.ageny.device_manage.device_allot.device_allot_agency;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.TelBean;
import com.xiaomai.ageny.bean.daobean.DeviceDao;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.device_manage.device_allot.DeviceAllotSuccessActivity;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.contract.DeviceAllotAgencyContract;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_agency.presenter.DeviceAllotAgencyPresenter;
import com.xiaomai.ageny.device_manage.device_allot.device_allot_list.DeviceAllotListActivity;
import com.xiaomai.ageny.greendao.gen.DaoSession;
import com.xiaomai.ageny.greendao.gen.DeviceDaoDao;
import com.xiaomai.ageny.utils.DaoSessionManager;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class DeviceAllotAgencyActivity extends BaseMvpActivity<DeviceAllotAgencyPresenter> implements DeviceAllotAgencyContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.bt_sure_allot)
    TextView btSureAllot;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.num)
    TextView num;
    private DaoSession daoSession;
    private DeviceDaoDao deviceDaoDao;
    private List<DeviceDao> list;
    private Dialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_allot_agency;
    }

    @Override
    public void initView() {
        daoSession = DaoSessionManager.getInstace()
                .getDaoSession(this);
        //查询所有数据
        deviceDaoDao = daoSession.getDeviceDaoDao();
        list = deviceDaoDao.loadAll();
        num.setText(list.size() + "");

        mPresenter = new DeviceAllotAgencyPresenter();
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
    public void onSuccess(TelBean bean) {
        if (bean.getCode() == 1) {
            name.setText(bean.getData());
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            name.setText(bean.getMessage());
        }

    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
//            toClass1(this, DeviceAllotSuccessActivity.class);
            deviceDaoDao.deleteAll();
            ShowDialogUtils.showdialog(this, "设备分配成功");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    DeviceAllotListActivity.instance.finish();
//                    DeviceManageActivity.instance.finish();
                }
            }, 1000);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @OnTextChanged(R.id.tel)
    public void onTextChanged(CharSequence text) {
        if (text.length() == 11) {
            mPresenter.sureTel(text.toString());
        } else {
            name.setText("");
        }
    }

    @OnClick({R.id.back, R.id.bt_sure_allot})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_sure_allot:
                String strtel = tel.getText().toString().trim();
                if (TextUtils.isEmpty(strtel)) {
                    ToastUtil.showShortToast("请输入电话号码");
                } else {
                    mPresenter.getData(MaptoJson.toJson(list, strtel));
                }
                break;
        }
    }


}
