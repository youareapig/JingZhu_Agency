package com.xiaomai.ageny.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.task.TaskActivity;

import cn.jpush.android.api.JPushInterface;

import static android.app.Notification.EXTRA_CHANNEL_ID;
import static android.provider.Settings.EXTRA_APP_PACKAGE;

public class ShowDialogUtils {
    public static void showdialog(Activity context, String title) {
        final AlertDialog builder = new AlertDialog.Builder(context).create();
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_sucess, null);
        TextView mtitle = view.findViewById(R.id.sucesse_text);
        mtitle.setText(title);
        builder.setView(view);
        builder.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                builder.dismiss();
            }
        }, 1000);
    }

    //单点登录提示框
    public static void restLoginDialog(Activity activity) {
        final AlertDialog builder = new AlertDialog.Builder(activity).create();
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_other_login, null);
        builder.setView(view);
        builder.setCancelable(false);
        builder.show();
        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesUtil.getInstance(activity).putSP("token", "");
                Intent intent = new Intent(activity, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                activity.startActivity(intent);
                activity.finish();
                JPushInterface.deleteAlias(activity, 1);
                builder.dismiss();
            }
        });
    }

    //单点登录提示框
    public static void openNotice(Activity activity) {
        final AlertDialog builder = new AlertDialog.Builder(activity).create();
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_open_notice, null);
        builder.setView(view);
        builder.setCanceledOnTouchOutside(false);
        builder.show();
        SharedPreferencesUtil.getInstance(activity).putSP("opennotice", "0");
        view.findViewById(R.id.bt_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //android 8.0引导
                if (Build.VERSION.SDK_INT >= 26) {
                    intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                    intent.putExtra(EXTRA_APP_PACKAGE, activity.getPackageName());
                    intent.putExtra(EXTRA_CHANNEL_ID, activity.getApplicationInfo().uid);
                }
                //android 5.0-7.0
                if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("app_package", activity.getPackageName());
                    intent.putExtra("app_uid", activity.getApplicationInfo().uid);
                }
                //其他
                if (Build.VERSION.SDK_INT < 21) {
                    intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                }
                activity.startActivity(intent);
                builder.dismiss();
            }
        });
        view.findViewById(R.id.bt_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.dismiss();
            }
        });

    }
}
