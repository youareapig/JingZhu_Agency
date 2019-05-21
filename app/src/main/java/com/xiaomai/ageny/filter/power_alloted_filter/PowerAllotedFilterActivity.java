package com.xiaomai.ageny.filter.power_alloted_filter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.DateUtils;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PowerAllotedFilterActivity extends BaseActivity {


    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.powerid)
    EditText powerid;
    @BindView(R.id.startime)
    TextView startime;
    @BindView(R.id.endtime)
    TextView endtime;
    @BindView(R.id.filter_bt_reset)
    TextView filterBtReset;
    @BindView(R.id.filter_bt_submit)
    TextView filterBtSubmit;
    private Bundle bundle;
    private String strId, strStart, strEnd;
    private TimePickerView pvCustomTime;

    @Override
    public int getLayoutId() {
        return R.layout.activity_power_alloted_filter;
    }

    @Override
    public void initView() {
        bundle = getIntent().getExtras();
        strId = bundle.getString("id");
        strStart = bundle.getString("start");
        strEnd = bundle.getString("end");
        powerid.setText(strId);
        startime.setText(strStart);
        endtime.setText(strEnd);
    }


    @OnClick({R.id.back, R.id.startime, R.id.endtime, R.id.filter_bt_reset, R.id.filter_bt_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.startime:
                initCustomTimePickerStart();
                break;
            case R.id.endtime:
                initCustomTimePickerEnd();
                break;
            case R.id.filter_bt_reset:
                powerid.setText("");
                startime.setText("");
                endtime.setText("");
                break;
            case R.id.filter_bt_submit:
                strId = powerid.getText().toString().trim();
                strStart = startime.getText().toString().trim();
                strEnd = endtime.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra("id", strId);
                intent.putExtra("start", strStart);
                intent.putExtra("end", strEnd);
                setResult(2, intent);
                finish();
                break;
        }
    }

    private void initCustomTimePickerStart() {
        //时间选择器 ，自定义布局
        //隐藏软键盘
        BaseUtils.hideInput(this);
        pvCustomTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                startime.setText(DateUtils.getTodayDateTime(date));
            }
        })

                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.2f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .build();
        pvCustomTime.show();
    }

    private void initCustomTimePickerEnd() {
        //时间选择器 ，自定义布局
        BaseUtils.hideInput(this);
        pvCustomTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                endtime.setText(DateUtils.getTodayDateTime(date));
            }
        })

                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setContentTextSize(18)
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.2f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .build();
        pvCustomTime.show();
    }
}
