package com.xiaomai.ageny.bean;

import java.util.List;

public class XiajiListBean {

    /**
     * code : 1
     * data : [{"agentId":16,"boxAddress":"武兴一路118号","canRent":true,"canReturn":false,"createTime":{"date":24,"day":4,"hours":16,"minutes":41,"month":0,"seconds":58,"time":1548319318000,"timezoneOffset":-480,"year":119},"details":"2.00","employeeId":0,"freezeMoney":0,"freezeTime":null,"iccid":"","id":"JZCB061901000003","isFreeze":0,"latitude":30.631752,"lixianTime":"","longitude":103.994537,"name":"","remitTime":{"date":28,"day":4,"hours":17,"minutes":1,"month":2,"seconds":3,"time":1553763663000,"timezoneOffset":-480,"year":119},"sellerId":"27","sellerReward":0,"slot":"[1,1,1,1,1,1]","state":1,"stock":6,"unfreezeMoney":0,"updateTime":{"date":16,"day":2,"hours":0,"minutes":10,"month":3,"seconds":54,"time":1555344654000,"timezoneOffset":-480,"year":119}}]
     * message : 越级获取商户设备列表成功
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
         * agentId : 16
         * boxAddress : 武兴一路118号
         * canRent : true
         * canReturn : false
         * createTime : {"date":24,"day":4,"hours":16,"minutes":41,"month":0,"seconds":58,"time":1548319318000,"timezoneOffset":-480,"year":119}
         * details : 2.00
         * employeeId : 0
         * freezeMoney : 0
         * freezeTime : null
         * iccid :
         * id : JZCB061901000003
         * isFreeze : 0
         * latitude : 30.631752
         * lixianTime :
         * longitude : 103.994537
         * name :
         * remitTime : {"date":28,"day":4,"hours":17,"minutes":1,"month":2,"seconds":3,"time":1553763663000,"timezoneOffset":-480,"year":119}
         * sellerId : 27
         * sellerReward : 0
         * slot : [1,1,1,1,1,1]
         * state : 1
         * stock : 6
         * unfreezeMoney : 0
         * updateTime : {"date":16,"day":2,"hours":0,"minutes":10,"month":3,"seconds":54,"time":1555344654000,"timezoneOffset":-480,"year":119}
         */

        private int agentId;
        private String boxAddress;
        private boolean canRent;
        private boolean canReturn;
        private CreateTimeBean createTime;
        private String details;
        private int employeeId;
        private int freezeMoney;
        private Object freezeTime;
        private String iccid;
        private String id;
        private int isFreeze;
        private double latitude;
        private String lixianTime;
        private double longitude;
        private String name;
        private RemitTimeBean remitTime;
        private String sellerId;
        private int sellerReward;
        private String slot;
        private int state;
        private int stock;
        private int unfreezeMoney;
        private UpdateTimeBean updateTime;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public String getBoxAddress() {
            return boxAddress;
        }

        public void setBoxAddress(String boxAddress) {
            this.boxAddress = boxAddress;
        }

        public boolean isCanRent() {
            return canRent;
        }

        public void setCanRent(boolean canRent) {
            this.canRent = canRent;
        }

        public boolean isCanReturn() {
            return canReturn;
        }

        public void setCanReturn(boolean canReturn) {
            this.canReturn = canReturn;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public int getFreezeMoney() {
            return freezeMoney;
        }

        public void setFreezeMoney(int freezeMoney) {
            this.freezeMoney = freezeMoney;
        }

        public Object getFreezeTime() {
            return freezeTime;
        }

        public void setFreezeTime(Object freezeTime) {
            this.freezeTime = freezeTime;
        }

        public String getIccid() {
            return iccid;
        }

        public void setIccid(String iccid) {
            this.iccid = iccid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsFreeze() {
            return isFreeze;
        }

        public void setIsFreeze(int isFreeze) {
            this.isFreeze = isFreeze;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getLixianTime() {
            return lixianTime;
        }

        public void setLixianTime(String lixianTime) {
            this.lixianTime = lixianTime;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public RemitTimeBean getRemitTime() {
            return remitTime;
        }

        public void setRemitTime(RemitTimeBean remitTime) {
            this.remitTime = remitTime;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public int getSellerReward() {
            return sellerReward;
        }

        public void setSellerReward(int sellerReward) {
            this.sellerReward = sellerReward;
        }

        public String getSlot() {
            return slot;
        }

        public void setSlot(String slot) {
            this.slot = slot;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public int getUnfreezeMoney() {
            return unfreezeMoney;
        }

        public void setUnfreezeMoney(int unfreezeMoney) {
            this.unfreezeMoney = unfreezeMoney;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public static class CreateTimeBean {
            /**
             * date : 24
             * day : 4
             * hours : 16
             * minutes : 41
             * month : 0
             * seconds : 58
             * time : 1548319318000
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

        public static class RemitTimeBean {
            /**
             * date : 28
             * day : 4
             * hours : 17
             * minutes : 1
             * month : 2
             * seconds : 3
             * time : 1553763663000
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

        public static class UpdateTimeBean {
            /**
             * date : 16
             * day : 2
             * hours : 0
             * minutes : 10
             * month : 3
             * seconds : 54
             * time : 1555344654000
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
