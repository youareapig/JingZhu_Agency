package com.xiaomai.ageny.bean;

import java.util.List;

public class AllotFirstBean {

    /**
     * mobile :
     * boxlist : [{"deviceid":"","strandedTime":"","deviceType":"","time":""}]
     */

    private String mobile;
    private List<BoxlistBean> boxlist;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<BoxlistBean> getBoxlist() {
        return boxlist;
    }

    public void setBoxlist(List<BoxlistBean> boxlist) {
        this.boxlist = boxlist;
    }

    public static class BoxlistBean {
        /**
         * deviceid :
         * strandedTime :
         * deviceType :
         * time :
         */

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
}
