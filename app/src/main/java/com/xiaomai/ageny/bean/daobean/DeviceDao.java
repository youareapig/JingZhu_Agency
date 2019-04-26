package com.xiaomai.ageny.bean.daobean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class DeviceDao {
    @Id(autoincrement = true)
    public Long id;
    private String deviceId;
    private String type;
    private String time;
    private String stopTime;
    public String getStopTime() {
        return this.stopTime;
    }
    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDeviceId() {
        return this.deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1676714960)
    public DeviceDao(Long id, String deviceId, String type, String time,
            String stopTime) {
        this.id = id;
        this.deviceId = deviceId;
        this.type = type;
        this.time = time;
        this.stopTime = stopTime;
    }
    @Generated(hash = 1468206029)
    public DeviceDao() {
    }


}
