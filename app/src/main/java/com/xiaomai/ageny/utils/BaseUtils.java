package com.xiaomai.ageny.utils;

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
}
