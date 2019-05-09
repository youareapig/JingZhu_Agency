package com.xiaomai.ageny.jpush;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.R;
import com.xiaomai.ageny.details.devicedetails.directdetails.DirectDetailsActivity;
import com.xiaomai.ageny.details.devicedetails.indirectdetails.IndirectDetailsActivity;
import com.xiaomai.ageny.system_notice.SystemNoticeActivity;
import com.xiaomai.ageny.utils.SharedPreferencesUtil;

import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MyReceiver extends BroadcastReceiver {
    private String deviceId, msgType, msgId;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (null != intent && !TextUtils.isEmpty(intent.getAction())) {
            String action = intent.getAction();
            Logger.d("action----->" + action);

            if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                Logger.d("---------点击了消息----------");
                Bundle bundle = intent.getExtras();
                String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
                try {
                    JSONObject jsonObject = new JSONObject(extras);
                    String s = jsonObject.getString("params");
                    JSONObject object = new JSONObject(s);
                    deviceId = object.getString("deviceId");
                    msgType = object.getString("msgType");
                    msgId = object.getString("msgId");
                    switch (msgType) {
                        case "0":
                            Intent intent0 = new Intent(context, IndirectDetailsActivity.class);
                            intent0.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent0.putExtra("id", deviceId);
                            intent0.putExtra("msgid", msgId);
                            context.startActivity(intent0);
                            break;
                        case "1":
                            Intent intent1 = new Intent(context, IndirectDetailsActivity.class);
                            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent1.putExtra("id", deviceId);
                            intent1.putExtra("msgid", msgId);
                            context.startActivity(intent1);
                            break;
                        case "2":
                            Intent intent2 = new Intent(context, DirectDetailsActivity.class);
                            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent2.putExtra("id", deviceId);
                            intent2.putExtra("msgid", msgId);
                            context.startActivity(intent2);
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

    }

}