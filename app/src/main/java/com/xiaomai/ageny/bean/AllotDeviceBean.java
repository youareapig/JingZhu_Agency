package com.xiaomai.ageny.bean;

import java.util.List;

public class AllotDeviceBean {

    /**
     * code : 1
     * data : [{"agentId":1,"agentLevel":"1","agentMobile":"","agentName":"吴凯","details":"","deviceId":"JZCB061901000044","deviceType":"","distTime":{"date":19,"day":5,"hours":11,"minutes":44,"month":3,"seconds":19,"time":1555645459000,"timezoneOffset":-480,"year":119},"id":1,"state":"1","strandedTime":null},{"agentId":1,"agentLevel":"2","agentMobile":"","agentName":"张兴凯","details":"","deviceId":"JZCB061901000044","deviceType":"","distTime":{"date":19,"day":5,"hours":11,"minutes":44,"month":3,"seconds":49,"time":1555645489000,"timezoneOffset":-480,"year":119},"id":2,"state":"1","strandedTime":null},{"agentId":1,"agentLevel":"1","agentMobile":"","agentName":"周琪帆","details":"","deviceId":"JZCB061901000044","deviceType":"","distTime":{"date":19,"day":5,"hours":11,"minutes":45,"month":3,"seconds":12,"time":1555645512000,"timezoneOffset":-480,"year":119},"id":3,"state":"1","strandedTime":null}]
     * message : 2.28已分配设备列表接口访问成功
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
         * agentId : 1
         * agentLevel : 1
         * agentMobile :
         * agentName : 吴凯
         * details :
         * deviceId : JZCB061901000044
         * deviceType :
         * distTime : {"date":19,"day":5,"hours":11,"minutes":44,"month":3,"seconds":19,"time":1555645459000,"timezoneOffset":-480,"year":119}
         * id : 1
         * state : 1
         * strandedTime : null
         */

        private int agentId;
        private String agentLevel;
        private String agentMobile;
        private String agentName;
        private String details;
        private String deviceId;
        private String deviceType;
        private DistTimeBean distTime;
        private int id;
        private String state;
        private Object strandedTime;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public String getAgentLevel() {
            return agentLevel;
        }

        public void setAgentLevel(String agentLevel) {
            this.agentLevel = agentLevel;
        }

        public String getAgentMobile() {
            return agentMobile;
        }

        public void setAgentMobile(String agentMobile) {
            this.agentMobile = agentMobile;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public DistTimeBean getDistTime() {
            return distTime;
        }

        public void setDistTime(DistTimeBean distTime) {
            this.distTime = distTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Object getStrandedTime() {
            return strandedTime;
        }

        public void setStrandedTime(Object strandedTime) {
            this.strandedTime = strandedTime;
        }

        public static class DistTimeBean {
            /**
             * date : 19
             * day : 5
             * hours : 11
             * minutes : 44
             * month : 3
             * seconds : 19
             * time : 1555645459000
             * timezoneOffset : -480
             * year : 119
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
