package com.xiaomai.ageny.utils;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xiaomai.ageny.bean.daobean.DeviceDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Map转Json字符串工具类
 */
public class MaptoJson {

    public static RequestBody toJsonOne(String s, List<String> keylist, List<String> valulist) {
        Map<String, String> map = new HashMap<>();
        Map<String, Map<String, String>> map1 = new HashMap<>();
        for (int i = 0; i < keylist.size(); i++) {

            map.put(keylist.get(i), valulist.get(i));
        }
        map1.put(s, map);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map1);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        return requestBody;
    }

    public static RequestBody toJsonZero(List<String> keylist, List<String> valulist) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < keylist.size(); i++) {
            map.put(keylist.get(i), valulist.get(i));
        }
        Gson gson = new Gson();
        String jsonStr = gson.toJson(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        return requestBody;
    }

    public static RequestBody toJson(List<DeviceDao> list, String strtel) {
        List<Map<String, String>> mlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put("deviceid", list.get(i).getDeviceId());
            map.put("strandedTime", list.get(i).getStopTime());
            map.put("deviceType", list.get(i).getType());
            map.put("time", list.get(i).getTime());

            mlist.add(map);
        }
        Map<String, Object> map1 = new HashMap<>();
        map1.put("mobile", strtel);
        map1.put("boxlist", mlist);


        Gson gson = new Gson();
        String jsonStr = gson.toJson(map1);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonStr);
        return requestBody;
    }


}
