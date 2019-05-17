package com.xiaomai.ageny.bean;

import java.util.List;

public class AllotDeviceBean {


    /**
     * code : 1
     * data : [{"agentId":1064,"agentLevel":"2","agentMobile":"","agentName":"一代个人1","details":"","deviceId":"JZCB061901000359","deviceType":"6口5槽","distTime":{"date":17,"day":5,"hours":11,"minutes":54,"month":4,"seconds":29,"time":1558065269000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1032,"id":291,"lingquren":"二代个人1","lingqurenmobile":"13880898866","state":"1","strandedTime":null},{"agentId":1064,"agentLevel":"1","agentMobile":"","agentName":"徐碧","details":"","deviceId":"JZCB061901000690","deviceType":"6口5槽","distTime":{"date":17,"day":5,"hours":15,"minutes":24,"month":4,"seconds":29,"time":1558077869000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1032,"id":297,"lingquren":"一代直商1","lingqurenmobile":"17032224444","state":"1","strandedTime":null}]
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
         * agentId : 1064
         * agentLevel : 2
         * agentMobile :
         * agentName : 一代个人1
         * details :
         * deviceId : JZCB061901000359
         * deviceType : 6口5槽
         * distTime : {"date":17,"day":5,"hours":11,"minutes":54,"month":4,"seconds":29,"time":1558065269000,"timezoneOffset":-480,"year":119}
         * fenpeiagentId : 1032
         * id : 291
         * lingquren : 二代个人1
         * lingqurenmobile : 13880898866
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
        private int fenpeiagentId;
        private int id;
        private String lingquren;
        private String lingqurenmobile;
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

        public int getFenpeiagentId() {
            return fenpeiagentId;
        }

        public void setFenpeiagentId(int fenpeiagentId) {
            this.fenpeiagentId = fenpeiagentId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLingquren() {
            return lingquren;
        }

        public void setLingquren(String lingquren) {
            this.lingquren = lingquren;
        }

        public String getLingqurenmobile() {
            return lingqurenmobile;
        }

        public void setLingqurenmobile(String lingqurenmobile) {
            this.lingqurenmobile = lingqurenmobile;
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
             * date : 17
             * day : 5
             * hours : 11
             * minutes : 54
             * month : 4
             * seconds : 29
             * time : 1558065269000
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
