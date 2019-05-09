package com.xiaomai.ageny.bean;

import java.util.List;

public class SystemNoticeBean {

    /**
     * code : 1
     * data : {"list":[{"address":"成都京猪办公室","agentId":1,"createTime":{"date":7,"day":2,"hours":17,"minutes":57,"month":4,"seconds":21,"time":1557223041000,"timezoneOffset":-480,"year":119},"deviceId":"JZCB061901000288","id":1,"message":"设备遗失","sellerId":0,"sellername":"","sellertel":"","state":1,"type":0,"updTime":""}],"page":1,"pageSize":25,"total":"1"}
     * message : 2.23系统消息获取成功
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
         * list : [{"address":"成都京猪办公室","agentId":1,"createTime":{"date":7,"day":2,"hours":17,"minutes":57,"month":4,"seconds":21,"time":1557223041000,"timezoneOffset":-480,"year":119},"deviceId":"JZCB061901000288","id":1,"message":"设备遗失","sellerId":0,"sellername":"","sellertel":"","state":1,"type":0,"updTime":""}]
         * page : 1
         * pageSize : 25
         * total : 1
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
             * address : 成都京猪办公室
             * agentId : 1
             * createTime : {"date":7,"day":2,"hours":17,"minutes":57,"month":4,"seconds":21,"time":1557223041000,"timezoneOffset":-480,"year":119}
             * deviceId : JZCB061901000288
             * id : 1
             * message : 设备遗失
             * sellerId : 0
             * sellername :
             * sellertel :
             * state : 1
             * type : 0
             * updTime :
             */

            private String address;
            private int agentId;
            private CreateTimeBean createTime;
            private String deviceId;
            private int id;
            private String message;
            private int sellerId;
            private String sellername;
            private String sellertel;
            private int state;
            private int type;
            private String updTime;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getAgentId() {
                return agentId;
            }

            public void setAgentId(int agentId) {
                this.agentId = agentId;
            }

            public CreateTimeBean getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeBean createTime) {
                this.createTime = createTime;
            }

            public String getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(String deviceId) {
                this.deviceId = deviceId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public String getSellername() {
                return sellername;
            }

            public void setSellername(String sellername) {
                this.sellername = sellername;
            }

            public String getSellertel() {
                return sellertel;
            }

            public void setSellertel(String sellertel) {
                this.sellertel = sellertel;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUpdTime() {
                return updTime;
            }

            public void setUpdTime(String updTime) {
                this.updTime = updTime;
            }

            public static class CreateTimeBean {
                /**
                 * date : 7
                 * day : 2
                 * hours : 17
                 * minutes : 57
                 * month : 4
                 * seconds : 21
                 * time : 1557223041000
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
