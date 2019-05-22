package com.xiaomai.ageny.bean;

public class PowerWithDrawInfoBean {

    /**
     * code : 1
     * data : {"deviceID":"JZCB91000327","deviceType":"","mobile":"15983302246","userAgentName":"郑磊"}
     * message : 撤回信息回显成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * deviceID : JZCB91000327
         * deviceType :
         * mobile : 15983302246
         * userAgentName : 郑磊
         */

        private String deviceID;
        private String deviceType;
        private String mobile;
        private String userAgentName;

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserAgentName() {
            return userAgentName;
        }

        public void setUserAgentName(String userAgentName) {
            this.userAgentName = userAgentName;
        }
    }
}
