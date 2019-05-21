package com.xiaomai.ageny.bean;

import java.util.List;

public class PowerAllotedBean {

    /**
     * code : 1
     * data : [{"assaginTime":"195-21 13:58:25","belongid":"831","deviceId":"JZCB91000575","lingquren":"郑磊","lingqurenMobile":"15983302246"}]
     * message : 7.5已分配设备列表接口访问成功
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
         * assaginTime : 195-21 13:58:25
         * belongid : 831
         * deviceId : JZCB91000575
         * lingquren : 郑磊
         * lingqurenMobile : 15983302246
         */

        private String assaginTime;
        private String belongid;
        private String deviceId;
        private String lingquren;
        private String lingqurenMobile;

        public String getAssaginTime() {
            return assaginTime;
        }

        public void setAssaginTime(String assaginTime) {
            this.assaginTime = assaginTime;
        }

        public String getBelongid() {
            return belongid;
        }

        public void setBelongid(String belongid) {
            this.belongid = belongid;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getLingquren() {
            return lingquren;
        }

        public void setLingquren(String lingquren) {
            this.lingquren = lingquren;
        }

        public String getLingqurenMobile() {
            return lingqurenMobile;
        }

        public void setLingqurenMobile(String lingqurenMobile) {
            this.lingqurenMobile = lingqurenMobile;
        }
    }
}
