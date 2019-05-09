package com.xiaomai.ageny.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.task.TaskActivity;

import cn.jpush.android.api.JPushInterface;

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

//    private static  void restLoginDialog(Activity activity) {
//        final AlertDialog builder = new AlertDialog.Builder(activity).create();
//        LayoutInflater layoutInflater = activity.getLayoutInflater();
//        View view = layoutInflater.inflate(R.layout.dialog_other_login, null);
//        builder.setView(view);
//        builder.setCancelable(false);
//        builder.show();
//        view.findViewById(R.id.bt_sure).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SharedPreferencesUtil.getInstance(activity).putSP("token", "");
//                toClass_Empty(activity, LoginActivity.class);
//                activity.finish();
//                JPushInterface.deleteAlias(activity, 1);
//                builder.dismiss();
//            }
//        });
//    }

}
