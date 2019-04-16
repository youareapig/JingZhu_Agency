package com.xiaomai.ageny.bean;

import java.util.List;

public class ContactDeviceListBean {

    /**
     * code : 1
     * data : {"list":[{"boxAddress":"金河路467号","details":"2.00","id":"JZCB061901000002","latitude":"30.593151","lixian":"","lixianTime":"","longitude":"103.909187","money":"0.00","state":"1","stock":"6","updateTime":{"date":15,"day":1,"hours":13,"minutes":59,"month":3,"seconds":54,"time":1555307994000,"timezoneOffset":-480,"year":119},"zaixian":""}],"lixianBox":"0","zaixianBox":"1"}
     * message : 设备信息获取成功
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
         * list : [{"boxAddress":"金河路467号","details":"2.00","id":"JZCB061901000002","latitude":"30.593151","lixian":"","lixianTime":"","longitude":"103.909187","money":"0.00","state":"1","stock":"6","updateTime":{"date":15,"day":1,"hours":13,"minutes":59,"month":3,"seconds":54,"time":1555307994000,"timezoneOffset":-480,"year":119},"zaixian":""}]
         * lixianBox : 0
         * zaixianBox : 1
         */

        private String lixianBox;
        private String zaixianBox;
        private List<ListBean> list;

        public String getLixianBox() {
            return lixianBox;
        }

        public void setLixianBox(String lixianBox) {
            this.lixianBox = lixianBox;
        }

        public String getZaixianBox() {
            return zaixianBox;
        }

        public void setZaixianBox(String zaixianBox) {
            this.zaixianBox = zaixianBox;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * boxAddress : 金河路467号
             * details : 2.00
             * id : JZCB061901000002
             * latitude : 30.593151
             * lixian :
             * lixianTime :
             * longitude : 103.909187
             * money : 0.00
             * state : 1
             * stock : 6
             * updateTime : {"date":15,"day":1,"hours":13,"minutes":59,"month":3,"seconds":54,"time":1555307994000,"timezoneOffset":-480,"year":119}
             * zaixian :
             */

            private String boxAddress;
            private String details;
            private String id;
            private String latitude;
            private String lixian;
            private String lixianTime;
            private String longitude;
            private String money;
            private String state;
            private String stock;
            private UpdateTimeBean updateTime;
            private String zaixian;

            public String getBoxAddress() {
                return boxAddress;
            }

            public void setBoxAddress(String boxAddress) {
                this.boxAddress = boxAddress;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLixian() {
                return lixian;
            }

            public void setLixian(String lixian) {
                this.lixian = lixian;
            }

            public String getLixianTime() {
                return lixianTime;
            }

            public void setLixianTime(String lixianTime) {
                this.lixianTime = lixianTime;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public UpdateTimeBean getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(UpdateTimeBean updateTime) {
                this.updateTime = updateTime;
            }

            public String getZaixian() {
                return zaixian;
            }

            public void setZaixian(String zaixian) {
                this.zaixian = zaixian;
            }

            public static class UpdateTimeBean {
                /**
                 * date : 15
                 * day : 1
                 * hours : 13
                 * minutes : 59
                 * month : 3
                 * seconds : 54
                 * time : 1555307994000
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
