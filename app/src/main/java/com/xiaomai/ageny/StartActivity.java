package com.xiaomai.ageny;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.gyf.barlibrary.ImmersionBar;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.base.BaseActivity;
import com.xiaomai.ageny.deviceinstalllist.DeviceInstallActivity;
import com.xiaomai.ageny.login.LoginActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ImmersionBar.with(this).statusBarColor(R.color.white).fitsSystemWindows(true).statusBarDarkFont(true).init();
        img = findViewById(R.id.img);
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(3000);
        img.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                    String token = SharedPreferencesUtil.getInstance(StartActivity.this).getSP("token");
                    String role = SharedPreferencesUtil.getInstance(StartActivity.this).getSP("role");
                    if (TextUtils.isEmpty(token)) {
                        startActivity(new Intent(StartActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        if (!TextUtils.isEmpty(role)){
                            if (role.equals("1")){
                                //代理
                                startActivity(new Intent(StartActivity.this, MainActivity.class));
                                finish();
                            }else if (role.equals("2")){
                                //员工
                                startActivity(new Intent(StartActivity.this, DeviceInstallActivity.class));
                                finish();
                            }
                        }else {
                            startActivity(new Intent(StartActivity.this, LoginActivity.class));
                            finish();
                        }

                    }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
