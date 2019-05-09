package com.xiaomai.ageny.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.gson.Gson;
import com.xiaomai.ageny.bean.ConfigBean;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class BaseUtils {
    //分割字符串
    public static String[] spliteUtils(String str, String tag) {
        String[] arr = str.split(tag);
        return arr;
    }

    //截取后面字符串
    public static String subBehindString(String str, String tag) {
        return str.substring(str.indexOf(tag) + 1);
    }

    //截取前面字符串
    public static String subFrontString(String str, String tag) {
        return str.substring(0, str.indexOf(tag));
    }

    //截取后面几位
    public static String subsubBehindNumString(String str, int num) {
        return str.substring(str.length() - num);
    }

    //获取价格集合带小时
    public static List<String> getPriceList(String json) {
        Gson gson = new Gson();
        ConfigBean bean = gson.fromJson(json, ConfigBean.class);
        List<String> priceList = bean.getData().getPrice();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < priceList.size(); i++) {
            double doublePrice = (Double.valueOf(priceList.get(i)));
            list.add(doublePrice + "/小时");
        }
        return list;
    }

    //获取价格集合不带小时
    public static List<String> getPriceList1(String json) {
        Gson gson = new Gson();
        ConfigBean bean = gson.fromJson(json, ConfigBean.class);
        List<String> priceList = bean.getData().getPrice();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < priceList.size(); i++) {
            double doublePrice = (Double.valueOf(priceList.get(i)));
            list.add(doublePrice + "");
        }
        return list;
    }

    //获取当前版本号
    public static int getLocationCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //隐藏键盘
    public static void hideInput(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
        View v = activity.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }

    }

    //保留两位小数并四舍五入
    public static String formatDouble4(double d) {
        DecimalFormat df = new DecimalFormat("#.00");

        return df.format(d);
    }

}
