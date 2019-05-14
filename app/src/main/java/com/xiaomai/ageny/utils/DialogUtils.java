package com.xiaomai.ageny.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.xiaomai.ageny.R;

/**
 * Created by EDZ on 2019/4/25.
 */

public class DialogUtils {

    public static Dialog showDialog_progressbar(Context context) {
        final AlertDialog dialog = new AlertDialog.Builder(context, R.style.MyCustomDialog).create();
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_view, null, false);
        dialog.setView(view);
        dialog.setCanceledOnTouchOutside(false);
        //背景透明
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();

        return dialog;
    }

    public static void closeDialog(Dialog mDialogUtils) {
        if (mDialogUtils != null && mDialogUtils.isShowing()) {
            mDialogUtils.dismiss();
        }
    }

}
