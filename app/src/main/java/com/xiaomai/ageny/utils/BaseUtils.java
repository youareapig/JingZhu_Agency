package com.xiaomai.ageny.utils;

public class BaseUtils {
    public static String[] spliteUtils(String str, String tag) {
        String[] arr = str.split(tag);
        return arr;
    }
}
