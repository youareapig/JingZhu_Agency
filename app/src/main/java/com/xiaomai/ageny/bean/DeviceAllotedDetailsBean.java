package com.xiaomai.ageny.bean;

import java.util.List;

public class DeviceAllotedDetailsBean {

    /**
     * code : 1
     * data : {"bushu":"已部署","fenpeitime":"2019-05-10 15:41:54","lingquren":"田英俊","lingqurenmobile":"17360054510","list":[{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":10,"month":4,"seconds":23,"time":1557713423000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":5,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":18,"month":4,"seconds":50,"time":1557713930000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":6,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":45,"month":4,"seconds":50,"time":1557715550000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":8,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":55,"month":4,"seconds":0,"time":1557716100000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":9,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":59,"month":4,"seconds":35,"time":1557716375000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":10,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":11,"minutes":1,"month":4,"seconds":51,"time":1557716511000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":11,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":16,"minutes":40,"month":4,"seconds":56,"time":1557736856000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":72,"state":"2","strandedTime":null}],"zhiliutime":""}
     * message : 2.19设备管理--已分配设备--设备详情
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
         * bushu : 已部署
         * fenpeitime : 2019-05-10 15:41:54
         * lingquren : 田英俊
         * lingqurenmobile : 17360054510
         * list : [{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":10,"month":4,"seconds":23,"time":1557713423000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":5,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":18,"month":4,"seconds":50,"time":1557713930000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":6,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":45,"month":4,"seconds":50,"time":1557715550000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":8,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":55,"month":4,"seconds":0,"time":1557716100000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":9,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":10,"minutes":59,"month":4,"seconds":35,"time":1557716375000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":10,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":11,"minutes":1,"month":4,"seconds":51,"time":1557716511000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":11,"state":"2","strandedTime":null},{"agentId":0,"agentLevel":"1","agentMobile":"17360054510","agentName":"田英俊","details":"","deviceId":"JZCB061901000288","deviceType":"","distTime":{"date":13,"day":1,"hours":16,"minutes":40,"month":4,"seconds":56,"time":1557736856000,"timezoneOffset":-480,"year":119},"fenpeiagentId":1028,"id":72,"state":"2","strandedTime":null}]
         * zhiliutime :
         */

        private String bushu;
        private String fenpeitime;
        private String lingquren;
        private String lingqurenmobile;
        private String zhiliutime;
        private List<ListBean> list;

        public String getBushu() {
            return bushu;
        }

        public void setBushu(String bushu) {
            this.bushu = bushu;
        }

        public String getFenpeitime() {
            return fenpeitime;
        }

        public void setFenpeitime(String fenpeitime) {
            this.fenpeitime = fenpeitime;
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

        public String getZhiliutime() {
            return zhiliutime;
        }

        public void setZhiliutime(String zhiliutime) {
            this.zhiliutime = zhiliutime;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * agentId : 0
             * agentLevel : 1
             * agentMobile : 17360054510
             * agentName : 田英俊
             * details :
             * deviceId : JZCB061901000288
             * deviceType :
             * distTime : {"date":13,"day":1,"hours":10,"minutes":10,"month":4,"seconds":23,"time":1557713423000,"timezoneOffset":-480,"year":119}
             * fenpeiagentId : 1028
             * id : 5
             * state : 2
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
                 * date : 13
                 * day : 1
                 * hours : 10
                 * minutes : 10
                 * month : 4
                 * seconds : 23
                 * time : 1557713423000
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
}
