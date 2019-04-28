package com.xiaomai.ageny.fragment.index;

import android.Manifest;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.orhanobut.logger.Logger;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpFragment;
import com.xiaomai.ageny.bean.ConfigBean;
import com.xiaomai.ageny.bean.IndexBean;
import com.xiaomai.ageny.bean.UpdateBean;
import com.xiaomai.ageny.deposit.DepositActivity;
import com.xiaomai.ageny.device_manage.DeviceManageActivity;
import com.xiaomai.ageny.deviceinstalllist.DeviceInstallActivity;
import com.xiaomai.ageny.fragment.index.contract.IndexContract;
import com.xiaomai.ageny.fragment.index.presenter.IndexPresenter;
import com.xiaomai.ageny.mybill.MyBillActivity;
import com.xiaomai.ageny.offline.OfflineActivity;
import com.xiaomai.ageny.order.OrderActivity;
import com.xiaomai.ageny.task.TaskActivity;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ToastUtil;
import com.xiaomai.ageny.utils.state_layout.OtherView;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;
import com.xiaomai.ageny.utils.update.UpdateAppHttpUtil;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Index_Fragment extends BaseMvpFragment<IndexPresenter> implements IndexContract.View {
    @BindView(R.id.yesterday_money)
    TextView yesterdayMoney;
    @BindView(R.id.all_money)
    TextView allMoney;
    @BindView(R.id.month_money)
    TextView monthMoney;
    @BindView(R.id.today_money)
    TextView todayMoney;
    @BindView(R.id.tx_index_money)
    TextView txIndexMoney;
    @BindView(R.id.bt_index_tixian)
    TextView btIndexTixian;
    @BindView(R.id.deposit_money)
    TextView depositMoney;

    @BindView(R.id.off_line)
    TextView offLine;
    @BindView(R.id.on_line)
    TextView onLine;
    @BindView(R.id.bt_index_bill)
    LinearLayout btIndexBill;
    @BindView(R.id.bt_index_devicemanager)
    LinearLayout btIndexDevicemanager;
    @BindView(R.id.bt_index_devicemake)
    LinearLayout btIndexDevicemake;
    @BindView(R.id.bt_index_order)
    LinearLayout btIndexOrder;
    @BindView(R.id.bt_off_line)
    RelativeLayout btOffLine;
    @BindView(R.id.otherview)
    OtherView otherView;
    @BindView(R.id.taskCenter)
    RelativeLayout tastCenter;
    @BindView(R.id.num)
    TextView Num;
    @BindView(R.id.refresh)
    PullToRefreshLayout refreshLayout;

    public AMapLocationClient mLocationClient = null;
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    public AMapLocationClientOption mLocationOption = null;
    @BindView(R.id.index_device_allcount)
    TextView indexDeviceAllcount;
    private String strTaskNum;
    private boolean ISSHOW = true;
    private int locatinVercode;

    @Override
    protected void initView(View view) {
        locatinVercode = BaseUtils.getLocationCode(getActivity());
        otherView.setHolder(mHolder);
        mPresenter = new IndexPresenter();
        mPresenter.attachView(this);
        mPresenter.getData();
        mPresenter.getConfigBean();
        mPresenter.getUpdate();
        mHolder.setOnListener(new OtherViewHolder.RetryBtnListener() {
            @Override
            public void onListener() {
                mPresenter.getData();
            }
        });
        MPermissions.requestPermissions(Index_Fragment.this, 10, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
        refreshLayout.setCanLoadMore(false);
        refreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPresenter.getData_Fresh();
                        refreshLayout.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(10)
    public void getLocation() {
        getPositioning();
    }


    class MyAMapLocationListener implements AMapLocationListener {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {

                    SharedPreferencesUtil.getInstance(getActivity()).putSP("lat", aMapLocation.getLatitude() + "");
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("lng", aMapLocation.getLongitude() + "");
                    SharedPreferencesUtil.getInstance(getActivity()).putSP("city", aMapLocation.getCity() + "");
                }

            }

        }
    }

    // 高德定位
    public void getPositioning() {
        mLocationClient = new AMapLocationClient(getActivity());
        mLocationClient.setLocationListener(mLocationListener);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setOnceLocationLatest(true);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setNeedAddress(true);
        mLocationOption.setMockEnable(true);
        mLocationOption.setInterval(5000);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationClient.startLocation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.index_fragment;
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
    public void onSuccess(IndexBean bean) {
        initData(bean);

    }

    @Override
    public void onSuccess(ConfigBean bean) {
        if (bean.getCode() == 1) {
            Gson gson = new Gson();
            String jsonConfig = gson.toJson(bean);
            SharedPreferencesUtil.getInstance(getActivity()).putSP("config", jsonConfig);
        }
    }


    @Override
    public void onSuccess_Fresh(IndexBean bean) {
        initData(bean);
    }

    @Override
    public void onSuccess(UpdateBean bean) {
        int nowVercode = Integer.valueOf(bean.getNewVersion());
        Logger.d("当前版本" + locatinVercode + "最新版本" + nowVercode);
        if (locatinVercode < nowVercode) {
            Logger.d("-----更新-------");
            update();
        }
    }

    private void initData(IndexBean bean) {
        if (bean.getCode() == 1) {
            IndexBean.DataBean data = bean.getData();
            strTaskNum = data.getCountTask();

            yesterdayMoney.setText(data.getYestoday_earn());
            todayMoney.setText(data.getDay_earn());
            allMoney.setText(data.getTotal_earn());
            monthMoney.setText(data.getMonth_earn());
            txIndexMoney.setText(data.getUnliquidated());
            depositMoney.setText("已提现金额：" + data.getFreeze_money());
            offLine.setText(data.getOffLineCount());
            onLine.setText(data.getOnLineCount());
            indexDeviceAllcount.setText((Integer.valueOf(data.getOnLineCount()) + Integer.valueOf(data.getOffLineCount())) + "");
            if (TextUtils.isEmpty(strTaskNum) || strTaskNum.equals("0")) {
                tastCenter.setVisibility(View.GONE);
            } else {
                if (ISSHOW) {
                    showDialog();
                }
                tastCenter.setVisibility(View.VISIBLE);
                Num.setText(strTaskNum);
            }
        } else {
            ToastUtil.showShortToast(bean.getMessage());
        }
    }

    @OnClick({R.id.bt_index_tixian, R.id.bt_index_bill, R.id.bt_index_devicemanager, R.id.bt_index_devicemake, R.id.bt_index_order, R.id.bt_off_line, R.id.taskCenter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_index_tixian:
                toClass(getActivity(), DepositActivity.class);
                break;
            case R.id.bt_index_bill:
                toClass(getActivity(), MyBillActivity.class);
                break;
            case R.id.bt_index_devicemanager:
                toClass(getActivity(), DeviceManageActivity.class);
                break;
            case R.id.bt_index_devicemake:
                toClass(getActivity(), DeviceInstallActivity.class);
                break;
            case R.id.bt_index_order:
                toClass(getActivity(), OrderActivity.class);
                break;
            case R.id.bt_off_line:
                toClass(getActivity(), OfflineActivity.class);
                break;
            case R.id.taskCenter:
                toClass1(getActivity(), TaskActivity.class);
                break;
        }
    }

    private void showDialog() {
        final AlertDialog dialog = new AlertDialog.Builder(getActivity(), R.style.FullScreenDialog).create();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.offline_dialog, null);
        TextView taskNum = v.findViewById(R.id.task_num);
        taskNum.setText(strTaskNum);
        dialog.setCancelable(false);
        v.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        v.findViewById(R.id.deal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toClass1(view.getContext(), TaskActivity.class);
                dialog.cancel();
            }
        });
        dialog.setView(v);
        dialog.show();
        ISSHOW = false;
    }

    private void update() {
        new UpdateAppManager.Builder()
                .setActivity(getActivity())
                .setUpdateUrl("http://192.168.0.81:8080/agentCenter/account/version/update")
                .setHttpManager(new UpdateAppHttpUtil())
                .setTopPic(R.mipmap.top_8)
                .build()
                .checkNewApp(new UpdateCallback() {
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        UpdateAppBean updateAppBean = new UpdateAppBean();
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            updateAppBean
                                    //（必须）是否更新Yes,No
                                    .setUpdate(jsonObject.optString("udate"))
                                    //（必须）新版本号，
                                    .setNewVersion(jsonObject.optString("newVersion"))
                                    //（必须）下载地址
                                    .setApkFileUrl(jsonObject.optString("apkFileUrl"))
                                    //（必须）更新内容
                                    .setUpdateLog(jsonObject.optString("updateLog"))
                                    //大小，不设置不显示大小，可以不设置
                                    .setTargetSize(jsonObject.optString("targetSize"))
                                    //是否强制更新，可以不设置constraint
                                    .setConstraint(jsonObject.optBoolean("cons"))
                                    //设置md5，可以不设置
                                    .setNewMd5(jsonObject.optString("newMd5"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return updateAppBean;
                    }

                });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //停止定位
        mLocationClient.stopLocation();
    }
}
