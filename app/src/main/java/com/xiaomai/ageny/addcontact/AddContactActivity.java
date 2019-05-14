package com.xiaomai.ageny.addcontact;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.addcontact.contract.AddContactContract;
import com.xiaomai.ageny.addcontact.presenter.AddContactPresenter;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.DateUtils;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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
    @BindView(R.id.idview)
    RelativeLayout idview;
    @BindView(R.id.storename)
    EditText storename;
    @BindView(R.id.linkname)
    EditText linkname;
    @BindView(R.id.linktel)
    EditText linktel;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.xiaofei)
    EditText xiaofei;
    @BindView(R.id.storeId)
    TextView storeId;
    @BindView(R.id.otherview)
    OtherView otherView;

    private int isadd;
    private String titleStr;
    private String id, strStorename, strLinkName, strLinkTel, strAdress, strYingye, strPersoncount, strStartTime, strEndTime;
    private TimePickerView pvCustomTime;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    private CustomDialog dialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_contact;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        otherView.setHolder(mHolder);
        Bundle bundle = getIntent().getExtras();
        isadd = bundle.getInt("isadd");
        switch (isadd) {
            case 1:
                //添加信息
                titleStr = "添加商户";
                idview.setVisibility(View.GONE);
                break;
            //修改信息
            case 2:
                titleStr = "资料修改";
                idview.setVisibility(View.VISIBLE);

                id = bundle.getString("id");

                storeId.setText(id);
                strStorename = bundle.getString("storename");
                strLinkName = bundle.getString("strLinkName");
                strLinkTel = bundle.getString("strLinkTel");
                strAdress = bundle.getString("strAdress");
                strYingye = bundle.getString("strYingye");
                strPersoncount = bundle.getString("strPersoncount");

                storeId.setText(id);
                storename.setText(strStorename);
                linkname.setText(strLinkName);
                linktel.setText(strLinkTel);
                address.setText(strAdress);
                if (!TextUtils.isEmpty(strYingye)) {
                    txStarTime.setText(BaseUtils.spliteUtils(strYingye, "-")[0]);
                    txEndTime.setText(BaseUtils.spliteUtils(strYingye, "-")[1]);
                }
                xiaofei.setText(strPersoncount);

                break;
        }
        title.setText(titleStr);
    }

    @Override
    public void showLoading() {
        dialog = new CustomDialog(this);
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        dialog.dismiss();
    }

    @Override
    public void onSuccess(HintBean bean) {
        if (bean.getCode() == 1) {
            ShowDialogUtils.showdialog(this, bean.getMessage());
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                }
            }, 1000);
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }


    @OnClick({R.id.back, R.id.startime, R.id.endtime, R.id.bt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.startime:
                initCustomTimePickerStart();
//                timePickerView1 = new TimePickerBuilder(this, new OnTimeSelectListener() {
//                    @Override
//                    public void onTimeSelect(Date date, View v) {
//                        txStarTime.setText(DateUtils.getTodayDateTime(date));
//                    }
//                }).build();
//                timePickerView1.show();
                break;
            case R.id.endtime:
//                timePickerView2 = new TimePickerBuilder(this, new OnTimeSelectListener() {
//                    @Override
//                    public void onTimeSelect(Date date, View v) {
//                        txEndTime.setText(DateUtils.getTodayDateTime(date));
//                    }
//                }).build();
//                timePickerView2.show();
                initCustomTimePickerEnd();
                break;
            case R.id.bt_save:
                Logger.d("isadd----" + isadd);
                id = storeId.getText().toString().trim();
                strStorename = storename.getText().toString().trim();
                strLinkName = linkname.getText().toString().trim();
                strLinkTel = linktel.getText().toString().trim();
                strAdress = address.getText().toString().trim();
                strStartTime = txStarTime.getText().toString().trim();
                strEndTime = txEndTime.getText().toString().trim();
                strPersoncount = xiaofei.getText().toString().trim();
                switch (isadd) {
                    case 1:
                        //添加商户
                        Logger.d("添加");
                        if (TextUtils.isEmpty(strStorename) || TextUtils.isEmpty(strLinkName) || TextUtils.isEmpty(strLinkTel) || TextUtils.isEmpty(strAdress) || TextUtils.isEmpty(strStartTime) || TextUtils.isEmpty(strEndTime) || TextUtils.isEmpty(strPersoncount)) {
                            ToastUtil.showShortToast("请完善信息");
                        } else {
                            keyList.add("name");
                            keyList.add("linkman");
                            keyList.add("linkmobile");
                            keyList.add("openTime");
                            keyList.add("area");
                            keyList.add("personCount");
                            valueList.add(strStorename);
                            valueList.add(strLinkName);
                            valueList.add(strLinkTel);
                            valueList.add(strStartTime + "-" + strEndTime);
                            valueList.add(strAdress);
                            valueList.add(strPersoncount);

                            mPresenter = new AddContactPresenter();
                            mPresenter.attachView(this);
                            mPresenter.AddContanct(MaptoJson.toJsonZero(keyList, valueList));
                        }
                        break;
                    case 2:
                        //修改资料
                        Logger.d("更新");
                        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(strStorename) || TextUtils.isEmpty(strLinkName) || TextUtils.isEmpty(strLinkTel) || TextUtils.isEmpty(strAdress) || TextUtils.isEmpty(strStartTime) || TextUtils.isEmpty(strEndTime) || TextUtils.isEmpty(strPersoncount)) {
                            ToastUtil.showShortToast("请完善信息");
                        } else {
                            keyList.add("id");
                            keyList.add("name");
                            keyList.add("linkman");
                            keyList.add("linkmobile");
                            keyList.add("openTime");
                            keyList.add("area");
                            keyList.add("personCount");
                            valueList.add(id);
                            valueList.add(strStorename);
                            valueList.add(strLinkName);
                            valueList.add(strLinkTel);
                            valueList.add(strStartTime + "-" + strEndTime);
                            valueList.add(strAdress);
                            valueList.add(strPersoncount);

                            mPresenter = new AddContactPresenter();
                            mPresenter.attachView(this);
                            mPresenter.getData(MaptoJson.toJsonZero(keyList, valueList));
                        }
                        break;
                }

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
                txStarTime.setText(DateUtils.getHM(date));
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
                .setType(new boolean[]{false, false, false, true, true, false})
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
        pvCustomTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                txEndTime.setText(DateUtils.getHM(date));
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
                .setType(new boolean[]{false, false, false, true, true, false})
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setLineSpacingMultiplier(1.2f)
                .setTextXOffset(0, 0, 0, 40, 0, -40)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(0xFF24AD9D)
                .build();
        pvCustomTime.show();
    }

}
