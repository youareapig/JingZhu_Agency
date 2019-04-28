package com.xiaomai.ageny;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends BaseActivity {


    @BindView(R.id.img)
    ImageView img;

    @Override
    public int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    public void initView() {
        ImmersionBar.with(this).transparentBar().fitsSystemWindows(false).statusBarDarkFont(false).init();
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(3000);
        img.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                try {
                    String token = SharedPreferencesUtil.getInstance(StartActivity.this).getSP("token");
                    Logger.d("ttttt"+token);
                    if (TextUtils.isEmpty(token)) {
                        toClass1(StartActivity.this, LoginActivity.class);
                        finish();
                    } else {
                        toClass1(StartActivity.this, MainActivity.class);
                        finish();
                    }
                } catch (Exception e) {
                    toClass1(StartActivity.this, LoginActivity.class);
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


}
