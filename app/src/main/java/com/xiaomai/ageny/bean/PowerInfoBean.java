package com.xiaomai.ageny.bean;

import java.util.List;

public class PowerInfoBean {

    /**
     * code : 1
     * data : [{"deviceType":"","deviceid":"JZCB91000448","strandedTime":"03时59分57秒","time":"2019-05-21 17:44:47"}]
     * message : 7.8数据回显成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * deviceType :
         * deviceid : JZCB91000448
         * strandedTime : 03时59分57秒
         * time : 2019-05-21 17:44:47
         */

        private String deviceType;
        private String deviceid;
        private String strandedTime;
        private String time;

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
