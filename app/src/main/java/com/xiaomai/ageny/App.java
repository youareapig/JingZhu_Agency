package com.xiaomai.ageny;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class App extends Application {
    public static Context context;
    public static String pageSize="15";
    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  //是否选择显示线程信息，默认为true
                .methodCount(1)         //方法数显示多少行，默认2行
                .methodOffset(7)        //隐藏方法内部调用到偏移量，默认5
                .tag("tag")   //自定义TAG全部标签，默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//初始化zxing
        ZXingLibrary.initDisplayOpinion(this);
    }
}
