package com.xiaomai.ageny.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.TextView;

import com.xiaomai.ageny.R;

public class CustomDialog extends ProgressDialog {

    public CustomDialog(Context context) {
        super(context, R.style.MyCustomDialog);

        setCanceledOnTouchOutside(false);
        getWindow().setDimAmount(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.dialog_view);
    }

}