package com.xiaomai.ageny.bean;

import java.util.List;

public class PowerAllotedBean {

    /**
     * code : 1
     * data : {"list":[{"assaginTime":"2019-05-23 15:08:14","belongid":"834","deviceId":"JZCB91000327","lingquren":"二代个1","lingqurenMobile":"13908081053"}],"page":1,"page_size":25,"total":"1"}
     * message : 7.5已分配设备列表接口访问成功
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
         * list : [{"assaginTime":"2019-05-23 15:08:14","belongid":"834","deviceId":"JZCB91000327","lingquren":"二代个1","lingqurenMobile":"13908081053"}]
         * page : 1
         * page_size : 25
         * total : 1
         */

        private int page;
        private int page_size;
        private String total;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
            this.page_size = page_size;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * assaginTime : 2019-05-23 15:08:14
             * belongid : 834
             * deviceId : JZCB91000327
             * lingquren : 二代个1
             * lingqurenMobile : 13908081053
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
}
