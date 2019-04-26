package com.xiaomai.ageny.bean;

import java.io.Serializable;

public class AllotSecondBean implements Serializable {
    private String deviceid;
    private String strandedTime;
    private String deviceType;
    private String time;



    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getStrandedTime() {
        return strandedTime;
    }

    public void setStrandedTime(String strandedTime) {
        this.strandedTime = strandedTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
