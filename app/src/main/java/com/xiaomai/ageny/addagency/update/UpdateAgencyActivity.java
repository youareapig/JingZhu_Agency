package com.xiaomai.ageny.addagency.update;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addagency.update.contract.UpdateAgencyContract;
import com.xiaomai.ageny.addagency.update.presenter.UpdateAgencyPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.AgencyUpdateBean;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateAgencyActivity extends BaseMvpActivity<UpdateAgencyPresenter> implements UpdateAgencyContract.View {
    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_person)
    TextView btPerson;
    @BindView(R.id.bt_firm)
    TextView btFirm;
    @BindView(R.id.view_firm)
    RelativeLayout viewFirm;
    @BindView(R.id.agencyId)
    TextView agencyId;
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

    private String id, strFenrun, strLinkName, strLinkTel, strAddress, strFirmName;
    private int isperson;
    private boolean btfirmIsSelect;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_agency;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        strFenrun = bundle.getString("fenrun");
        strLinkName = bundle.getString("linkname");
        strLinkTel = bundle.getString("linktel");
        strAddress = bundle.getString("address");
        strFirmName = bundle.getString("firmname");
        isperson = bundle.getInt("isperson");
        agencyId.setText(id);
        linkname.setText(strLinkName);
        linktel.setText(strLinkTel);
        adress.setText(strAddress);
        fenrun.setText(strFenrun);
        Logger.d("isperson----" + isperson);
        if (isperson == 1) {
            //个人
            btPerson.setSelected(true);
            viewFirm.setVisibility(View.GONE);
            btfirmIsSelect = false;
        }
        if (isperson == 2) {
            //企业
            btFirm.setSelected(true);
            firmName.setText(strFirmName);
            viewFirm.setVisibility(View.VISIBLE);
            btfirmIsSelect = true;
        }
        mPresenter = new UpdateAgencyPresenter();
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
        Logger.d("修改错误");
    }

    @Override
    public void onSuccess(AgencyUpdateBean bean) {
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
//                btPerson.setSelected(true);
//                btFirm.setSelected(false);
//                viewFirm.setVisibility(View.GONE);
//                firmName.setText("");
//                btfirmIsSelect = false;
                break;
            case R.id.bt_firm:
//                btPerson.setSelected(false);
//                btFirm.setSelected(true);
//                viewFirm.setVisibility(View.VISIBLE);
//                btfirmIsSelect = true;
                break;
            case R.id.bt_save:
                id = agencyId.getText().toString().trim();
                strFirmName = firmName.getText().toString().trim();
                strLinkName = linkname.getText().toString().trim();
                strLinkTel = linktel.getText().toString().trim();
                strAddress = adress.getText().toString().trim();
                strFenrun = fenrun.getText().toString().trim();

                keyList.add("id");
                keyList.add("linkman");
                keyList.add("linkmobile");
                keyList.add("area");
                keyList.add("reward");

                valueList.add(id);
                valueList.add(strLinkName);
                valueList.add(strLinkTel);
                valueList.add(strAddress);
                valueList.add(strFenrun);
                Logger.d("btfirmIsSelect---" + btfirmIsSelect);
                if (btfirmIsSelect) {
                    //选中企业，企业不能为空
                    keyList.add("companyName");
                    keyList.add("type");
                    valueList.add(strFirmName);
                    valueList.add("2");
                    if (TextUtils.isEmpty(strLinkName) || TextUtils.isEmpty(strLinkTel) || TextUtils.isEmpty(strAddress) || TextUtils.isEmpty(strFenrun) || TextUtils.isEmpty(strFirmName)) {
                        ToastUtil.showShortToast("请完善资料");
                    } else {
                        mPresenter.getData(MaptoJson.toJsonZero(keyList, valueList));
                    }
                } else {
                    //未选中企业,企业可以为空
                    Logger.d("strFirmName---" + strFirmName + "strFirmName---" + strLinkTel + "strAddress---" + strAddress + "strFenrun---" + strFenrun);
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
