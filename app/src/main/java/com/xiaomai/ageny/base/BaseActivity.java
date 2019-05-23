package com.xiaomai.ageny.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.utils.BaseUtils;
import com.xiaomai.ageny.utils.NetWorkUtils;
import com.xiaomai.ageny.utils.state_layout.OtherViewHolder;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    public Bundle savedInstanceState;
    public OtherViewHolder mHolder;
    public boolean isNetWork = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutId());
        this.savedInstanceState = savedInstanceState;
        unbinder = ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarColor(R.color.appbar).fitsSystemWindows(true).statusBarDarkFont(false).init();
        //是否有网络
        isNetWork = NetWorkUtils.isNetworkConnected(this);
        //空白页初始化
        mHolder = new OtherViewHolder(this);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        ImmersionBar.with(this).destroy();
    }


    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化视图
     */
    public abstract void initView();

    protected void toClass(Context context, Class<? extends BaseMvpActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    protected void toClass1(Context context, Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

    protected void toClass1(Context context, Class<? extends BaseActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    //带参数
    protected void toClass(Context context, Class<? extends BaseMvpActivity> clazz, Bundle bundle) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    protected void toClass_Empty(Context context, Class<? extends BaseActivity> clazz) {
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    protected void toClass(Context context, Class<? extends BaseMvpActivity> clazz, Bundle bundle, int reuqestCode) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, reuqestCode);
    }

    protected void toClass1(Context context, Class<? extends BaseActivity> clazz, Bundle bundle, int reuqestCode) {
        Intent intent = new Intent(context, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, reuqestCode);
    }
}
