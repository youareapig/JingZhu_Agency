package com.xiaomai.ageny.addcontact;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addcontact.contract.AddContactContract;
import com.xiaomai.ageny.addcontact.presenter.AddContactPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddContactActivity extends BaseMvpActivity<AddContactPresenter> implements AddContactContract.View {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.startime)
    RelativeLayout startime;
    @BindView(R.id.endtime)
    RelativeLayout endtime;
    @BindView(R.id.bt_save)
    TextView btSave;
    @BindView(R.id.tx_star_time)
    TextView txStarTime;
    @BindView(R.id.tx_end_time)
    TextView txEndTime;
    @BindView(R.id.title)
    TextView title;

    private TimePickerView timePickerView1, timePickerView2;
    private int isadd;
    private String titleStr;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_contact;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        Bundle bundle = getIntent().getExtras();
        isadd = bundle.getInt("isadd");
        switch (isadd) {
            case 1:
                //添加信息
                titleStr = "添加商户";
                break;
            //修改信息
            case 2:
                titleStr = "资料修改";
                break;
        }
        title.setText(titleStr);
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


    @OnClick({R.id.back, R.id.startime, R.id.endtime, R.id.bt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.startime:
                timePickerView1 = new TimePickerBuilder(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        txStarTime.setText(DateUtils.getTodayDateTime(date));
                    }
                }).build();
                timePickerView1.show();
                break;
            case R.id.endtime:
                timePickerView2 = new TimePickerBuilder(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        txEndTime.setText(DateUtils.getTodayDateTime(date));
                    }
                }).build();
                timePickerView2.show();
                break;
            case R.id.bt_save:
                break;
        }
    }


}
