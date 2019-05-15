package com.xiaomai.ageny.utils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.widget.TextView;

import com.xiaomai.ageny.R;


/**
 * Created by Administrator on 2016/12/4 0004.
 */
public class CountDownTimerUtilsPop extends CountDownTimer {
    private TextView mTextView;

    /**
     * 60s后获取验证码
     */
    public CountDownTimerUtilsPop(TextView mTextView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = mTextView;

    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        mTextView.setText(millisUntilFinished / 1000 + "s");  //设置倒计时时间
        mTextView.setTextColor(Color.parseColor("#ffffff"));
        mTextView.setBackgroundResource(R.drawable.goshop_button); //设置按钮为灰色，这时是不能点击的
        SpannableString spannableString = new SpannableString(mTextView.getText().toString());
        // ForegroundColorSpan span = new ForegroundColorSpan(Color.WHITE);
        //spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("确认弹出");
        //必须使用6位颜色码
        mTextView.setTextColor(Color.parseColor("#ffffff"));
        mTextView.setClickable(true);//重新获得点击
        mTextView.setBackgroundResource(R.drawable.tixian_button);  //还原背景色
    }
}
