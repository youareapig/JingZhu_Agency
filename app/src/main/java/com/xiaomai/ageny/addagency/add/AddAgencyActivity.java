package com.xiaomai.ageny.addagency.add;

import android.app.Dialog;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addagency.add.contract.AddAgencyContract;
import com.xiaomai.ageny.addagency.add.presenter.AddAgencyPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.utils.DialogUtils;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class AddAgencyActivity extends BaseMvpActivity<AddAgencyPresenter> implements AddAgencyContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_person)
    TextView btPerson;
    @BindView(R.id.bt_firm)
    TextView btFirm;
    @BindView(R.id.view_firm)
    RelativeLayout viewFirm;
    @BindView(R.id.firmName)
    EditText firmName;
    @BindView(R.id.linkname)
    EditText linkname;
    @BindView(R.id.linktel)
    EditText linktel;
    @BindView(R.id.adress)
    EditText adress;
    @BindView(R.id.fenrun)
    EditText fenrun;
    @BindView(R.id.bt_save)
    TextView btSave;
    @BindView(R.id.maxfenrun)
    TextView maxFenrun;
    private String strFenrun, strLinkName, strLinkTel, strAddress, strFirmName;
    private boolean btfirmIsSelect = false;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private Dialog dialog;
    private String reward;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_agency;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        //默认选中个人
        btPerson.setSelected(true);
        viewFirm.setVisibility(View.GONE);
        mPresenter = new AddAgencyPresenter();
        mPresenter.attachView(this);
        reward = SharedPreferencesUtil.getInstance(this).getSP("reward");
        maxFenrun.setText(reward);
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
            ShowDialogUtils.showdialog(this, "添加代理成功");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        }else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


    @OnClick({R.id.back, R.id.bt_person, R.id.bt_firm, R.id.bt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_person:
                btPerson.setSelected(true);
                btFirm.setSelected(false);
                viewFirm.setVisibility(View.GONE);
                btfirmIsSelect = false;
                break;
            case R.id.bt_firm:
                btPerson.setSelected(false);
                btFirm.setSelected(true);
                viewFirm.setVisibility(View.VISIBLE);
                btfirmIsSelect = true;
                break;
            case R.id.bt_save:
                strFirmName = firmName.getText().toString().trim();
                strLinkName = linkname.getText().toString().trim();
                strLinkTel = linktel.getText().toString().trim();
                strAddress = adress.getText().toString().trim();
                strFenrun = fenrun.getText().toString().trim();

                keyList.add("linkman");
                keyList.add("linkmobile");
                keyList.add("area");
                keyList.add("reward");

                valueList.add(strLinkName);
                valueList.add(strLinkTel);
                valueList.add(strAddress);
                valueList.add(strFenrun);

                if (btfirmIsSelect) {
                    //选中企业1
                    keyList.add("companyName");
                    keyList.add("type");
                    valueList.add(strFirmName);
                    valueList.add("1");
                    Logger.d("strFirmName---" + strFirmName + "strLinkTel---" + strLinkTel + "strAddress---" + strAddress + "strFenrun---" + strFenrun + "strLinkName---" + strLinkName);
                    if (TextUtils.isEmpty(strLinkName) || TextUtils.isEmpty(strLinkTel) || TextUtils.isEmpty(strAddress) || TextUtils.isEmpty(strFenrun) || TextUtils.isEmpty(strFirmName)) {
                        ToastUtil.showShortToast("请完善资料");
                    } else {
                        mPresenter.getData(MaptoJson.toJsonZero(keyList, valueList));
                    }
                } else {
                    //选中个人0
                    if (TextUtils.isEmpty(strLinkName) || TextUtils.isEmpty(strLinkTel) || TextUtils.isEmpty(strAddress) || TextUtils.isEmpty(strFenrun)) {
                        ToastUtil.showShortToast("请完善资料");
                    } else {
                        mPresenter.getData(MaptoJson.toJsonZero(keyList, valueList));
                    }
                }
                break;
        }
    }

}
