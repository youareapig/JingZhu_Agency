package com.xiaomai.ageny.utils;


import android.text.TextUtils;

public class HideUtil {
    //银行卡显示格式
    public static String hideCardNo(String cardNo) {
        if (TextUtils.isEmpty(cardNo)) {
            return cardNo;
        } else {
            String substring = cardNo.substring(cardNo.length() - 4, cardNo.length());
            String str = "****   ****   ****   " + substring;

            return str;
        }

    }

    //电话号码显示格式
    public static String hideMobile(String mobile) {
        int length = mobile.length();
        int beforeLength = 3;
        int afterLength = 4;
        //替换字符串，当前使用“*”
        String replaceSymbol = "*";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (i < beforeLength || i >= (length - afterLength)) {
                sb.append(mobile.charAt(i));
            } else {
                sb.append(replaceSymbol);
            }
        }
        return sb.toString();
    }
}
