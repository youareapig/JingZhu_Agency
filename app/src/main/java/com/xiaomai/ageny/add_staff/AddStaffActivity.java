package com.xiaomai.ageny.add_staff;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.add_staff.contract.AddStaffContract;
import com.xiaomai.ageny.add_staff.presenter.AddStaffPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStaffActivity extends BaseMvpActivity<AddStaffPresenter> implements AddStaffContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.bt_save)
    TextView btSave;

    private String strname, strtel;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_staff;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        mPresenter = new AddStaffPresenter();
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
            finish();
        }else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }

    }

    @OnClick({R.id.back, R.id.bt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_save:
                strname = name.getText().toString().trim();
                strtel = tel.getText().toString().trim();
                if (TextUtils.isEmpty(strname) || TextUtils.isEmpty(strtel)) {
                    ToastUtil.showShortToast("请员工完善信息");
                } else {
                    keyList.add("realname");
                    keyList.add("mobile");

                    valueList.add(strname);
                    valueList.add(strtel);

                    mPresenter.addStaff(MaptoJson.toJsonZero(keyList, valueList));

                }
                break;
        }
    }
}
