package com.xiaomai.ageny.deploy;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.xiaomai.ageny.App;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.base.BaseMvpActivity;
import com.xiaomai.ageny.bean.HintBean;
import com.xiaomai.ageny.bean.JsonBean;
import com.xiaomai.ageny.bean.TelToNameBean;
import com.xiaomai.ageny.deploy.contract.DeployContract;
import com.xiaomai.ageny.deploy.presenter.DeployPresenter;
import com.xiaomai.ageny.fragment.index.Index_Fragment;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.CustomDialog;
import com.xiaomai.ageny.utils.GetJsonDataUtil;
import com.xiaomai.ageny.utils.MaptoJson;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;
import com.xiaomai.ageny.utils.ShowDialogUtils;
import com.xiaomai.ageny.utils.ToastUtil;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionGrant;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import okhttp3.RequestBody;

public class DeployActivity extends BaseMvpActivity<DeployPresenter> implements DeployContract.View {
    @BindView(R.id.back)
    RelativeLayout back;
    @BindView(R.id.bt_saoyisao)
    TextView btSaoyisao;
    @BindView(R.id.bt_choosecity)
    RelativeLayout btChoosecity;
    @BindView(R.id.bt_getlocation)
    ImageView btGetlocation;
    @BindView(R.id.bt_sure)
    TextView btSure;
    @BindView(R.id.city_name)
    TextView cityName;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.choose_price)
    RelativeLayout choosePrice;
    @BindView(R.id.deviceId)
    TextView deviceId;
    @BindView(R.id.lat)
    TextView latandlng;
    @BindView(R.id.adress)
    EditText adress;
    @BindView(R.id.tel)
    EditText tel;
    @BindView(R.id.fenrun)
    EditText fenrun;
    @BindView(R.id.isfrezze)
    CheckBox isfrezze;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.personname)
    TextView personName;
    @BindView(R.id.maxfenrun)
    TextView maxFenrun;
    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;
    private boolean isShow = true;
    private List<String> priceList;
    private String strId, strlatandlng, strcity, stradress, strprice, strtel, strfenrun, strisfreeze, strlat, strlng, strDeviceid, strmaxFenrun;
    private List<String> keyList = new ArrayList<>();
    private List<String> valueList = new ArrayList<>();
    public static DeployActivity instance;
    private CustomDialog dialog;


    @Override
    public int getLayoutId() {
        return R.layout.activity_deploy;
    }

    @Override
    public void initView() {
        strDeviceid = getIntent().getExtras().getString("deviceId");
        deviceId.setText(strDeviceid);
        strmaxFenrun = SharedPreferencesUtil.getInstance(this).getSP("reward");
        maxFenrun.setText(strmaxFenrun);
        instance = this;
        mPresenter = new DeployPresenter();
        mPresenter.attachView(this);
        String configJson = SharedPreferencesUtil.getInstance(this).getSP("config");
        priceList = BaseUtils.getPriceList1(configJson);
        //TODO 城市选择三级联动
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);
        MPermissions.requestPermissions(this, 21, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
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

    //验证电话号码结果
    @Override
    public void onSuccess(TelToNameBean bean) {
        if (bean.getCode() == 1) {
            personName.setText(bean.getData().getName());
        } else if (bean.getCode() == -10) {
            ShowDialogUtils.restLoginDialog(this);
        } else {
            personName.setText(bean.getMessage());
        }

    }

    //获取当前定位结果
    @Override
    public void locationSuccess(AMapLocation aMapLocation) {
        strlat = aMapLocation.getLatitude() + "";
        strlng = aMapLocation.getLongitude() + "";
        latandlng.setText(strlat + "," + strlng);
        cityName.setText(aMapLocation.getProvince() + aMapLocation.getCity() + aMapLocation.getDistrict());
        adress.setText(aMapLocation.getStreet() + aMapLocation.getStreetNum());
        location.setText(aMapLocation.getStreet() + aMapLocation.getStreetNum());
    }

    //部署返回结果
    @Override
    public void onDeploy(HintBean bean) {
        if (bean.getCode() == 1) {
            ShowDialogUtils.showdialog(this, "设备部署成功");
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


    @OnClick({R.id.back, R.id.bt_saoyisao, R.id.bt_choosecity, R.id.bt_getlocation, R.id.bt_sure, R.id.choose_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.bt_saoyisao:

                break;
            case R.id.bt_choosecity:
//                if (isShow) {
//                    showPickerView();
//                }
                break;
            case R.id.bt_getlocation:
                MPermissions.requestPermissions(this, 20, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION);
                break;
            case R.id.choose_price:
                initNoLinkOptionsPicker();
                break;
            case R.id.bt_sure:
                if (isfrezze.isChecked()) {
                    //冻结
                    strisfreeze = "1";
                } else {
                    //未冻结
                    strisfreeze = "0";
                }
                strId = deviceId.getText().toString().trim();
                strlatandlng = latandlng.getText().toString().trim();
                strcity = cityName.getText().toString().trim();
                stradress = adress.getText().toString().trim();
                strprice = price.getText().toString().trim();
                strtel = tel.getText().toString().trim();
                strfenrun = fenrun.getText().toString().trim();
                if (TextUtils.isEmpty(strId) || TextUtils.isEmpty(strlatandlng) || TextUtils.isEmpty(strcity) || TextUtils.isEmpty(stradress)
                        || TextUtils.isEmpty(strprice) || TextUtils.isEmpty(strtel) || TextUtils.isEmpty(strfenrun)) {
                    ToastUtil.showShortToast("请完善资料");
                } else {
                    keyList.add("id");
                    keyList.add("address");
                    keyList.add("unit_price");
                    keyList.add("longitude");
                    keyList.add("latitude");
                    keyList.add("mobile");
                    keyList.add("reward");
                    keyList.add("is_freeze");

                    valueList.add(strId);
                    valueList.add(strcity + stradress);
                    valueList.add(strprice);
                    valueList.add(strlng);
                    valueList.add(strlat);
                    valueList.add(strtel);
                    valueList.add(strfenrun);
                    valueList.add(strisfreeze);

                    mPresenter.getDeploy(MaptoJson.toJsonZero(keyList, valueList));
                }

                break;
        }
    }

    @OnTextChanged(R.id.tel)
    public void onTextChanged(CharSequence text) {
        Logger.d("文本内容" + text);
        if (text.length() == 11) {
            mPresenter.getData(text.toString());
        } else {
            personName.setText("");
        }
    }


    @PermissionGrant(20)
    public void getLocation() {
        //获取当前定位
        mPresenter.getLocation();
    }

    @PermissionGrant(21)
    public void getLocation21() {
        //获取当前定位
        mPresenter.getLocation();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {//如果已创建就不再重新创建子线程了

                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 子线程中解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    isShow = true;
                    break;

                case MSG_LOAD_FAILED:
                    break;
            }
        }
    };

    private void initJsonData() {
        String JsonData = new GetJsonDataUtil().getJson(this, "province.json");//获取assets目录下的json文件数据
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体
        options1Items = jsonBean;
        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）
            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String cityName = jsonBean.get(i).getCityList().get(c).getName();
                cityList.add(cityName);//添加城市
                ArrayList<String> city_AreaList = new ArrayList<>();//该城市的所有地区列表
                city_AreaList.addAll(jsonBean.get(i).getCityList().get(c).getArea());
                province_AreaList.add(city_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);
    }

    public ArrayList<JsonBean> parseData(String result) {
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    private void showPickerView() {
        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";

                String opt2tx = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2) : "";

                String opt3tx = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3) : "";

                String tx = opt1tx + opt2tx + opt3tx;
                cityName.setText(tx);
            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    //单项选择
    private void initNoLinkOptionsPicker() {
        BaseUtils.hideInput(this);
        OptionsPickerView pvNoLinkOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {

            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                price.setText(priceList.get(options1));
            }
        }).build();
        pvNoLinkOptions.setNPicker(priceList, null, null);
        pvNoLinkOptions.setSelectOptions(0);
        pvNoLinkOptions.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mPresenter.stopLocation();
    }
}
