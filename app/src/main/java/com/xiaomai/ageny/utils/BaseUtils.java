package com.xiaomai.ageny.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.google.gson.Gson;
import com.xiaomai.ageny.bean.ConfigBean;

import java.util.ArrayList;
import java.util.List;

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
}
