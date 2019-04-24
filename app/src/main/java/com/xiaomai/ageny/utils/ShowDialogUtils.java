package com.xiaomai.ageny.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xiaomai.ageny.R;
import com.xiaomai.ageny.task.TaskActivity;

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

}
