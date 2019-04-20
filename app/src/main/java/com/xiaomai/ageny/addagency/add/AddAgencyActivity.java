package com.xiaomai.ageny.addagency.add;

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
import com.xiaomai.ageny.utils.MaptoJson;
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
    private String strFenrun, strLinkName, strLinkTel, strAddress, strFirmName;
    private boolean btfirmIsSelect = true;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_agency;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        //默认选中企业
        btFirm.setSelected(true);
        mPresenter = new AddAgencyPresenter();
        mPresenter.attachView(this);
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
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            ToastUtil.showShortToast(bean.getMessage());
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }


    @OnClick({R.id.back, R.id.bt_person, R.id.bt_firm, R.id.bt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
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
                    //选中企业
                    keyList.add("companyName");
                    keyList.add("type");
                    valueList.add(strFirmName);
                    valueList.add("2");
                    Logger.d("strFirmName---" + strFirmName + "strLinkTel---" + strLinkTel + "strAddress---" + strAddress + "strFenrun---" + strFenrun + "strLinkName---" + strLinkName);
                    if (TextUtils.isEmpty(strLinkName) || TextUtils.isEmpty(strLinkTel) || TextUtils.isEmpty(strAddress) || TextUtils.isEmpty(strFenrun) || TextUtils.isEmpty(strFirmName)) {
                        ToastUtil.showShortToast("请完善资料");
                    } else {
                        mPresenter.getData(MaptoJson.toJsonZero(keyList, valueList));
                    }
                } else {
                    //选中个人
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
