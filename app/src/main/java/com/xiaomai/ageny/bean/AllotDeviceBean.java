package com.xiaomai.ageny.bean;

import java.util.List;

public class AllotDeviceBean {

    /**
     * code : 1
     * data : {"list":[{"deviceId":"JZCB061901000044","distTime":{"date":18,"day":4,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1555567750000,"timezoneOffset":-480,"year":119},"lingquren":"李四","lingqurenmobile":"110","total":""},{"deviceId":"JZCB061901000002","distTime":{"date":10,"day":3,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1554876550000,"timezoneOffset":-480,"year":119},"lingquren":"张三","lingqurenmobile":"120","total":""}],"page":1,"pageSize":20,"total":"2"}
     * message : 2.28已分配设备列表接口访问成功
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
         * list : [{"deviceId":"JZCB061901000044","distTime":{"date":18,"day":4,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1555567750000,"timezoneOffset":-480,"year":119},"lingquren":"李四","lingqurenmobile":"110","total":""},{"deviceId":"JZCB061901000002","distTime":{"date":10,"day":3,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1554876550000,"timezoneOffset":-480,"year":119},"lingquren":"张三","lingqurenmobile":"120","total":""}]
         * page : 1
         * pageSize : 20
         * total : 2
         */

        private int page;
        private int pageSize;
        private String total;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
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
             * deviceId : JZCB061901000044
             * distTime : {"date":18,"day":4,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1555567750000,"timezoneOffset":-480,"year":119}
             * lingquren : 李四
             * lingqurenmobile : 110
             * total :
             */

            private String deviceId;
            private DistTimeBean distTime;
            private String lingquren;
            private String lingqurenmobile;
            private String total;

            public String getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(String deviceId) {
                this.deviceId = deviceId;
            }

            public DistTimeBean getDistTime() {
                return distTime;
            }

            public void setDistTime(DistTimeBean distTime) {
                this.distTime = distTime;
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

            public String getTotal() {
                return total;
            }

            public void setTotal(String total) {
                this.total = total;
            }

            public static class DistTimeBean {
                /**
                 * date : 18
                 * day : 4
                 * hours : 14
                 * minutes : 9
                 * month : 3
                 * seconds : 10
                 * time : 1555567750000
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
