package com.xiaomai.ageny.bean;

import java.util.List;

public class NoAllotDeviceBean {

    /**
     * code : 1
     * data : [{"assginTime":{"date":17,"day":5,"hours":11,"minutes":54,"month":4,"seconds":29,"time":1558065269000,"timezoneOffset":-480,"year":119},"batchId":1,"batchName":"","belongId":1064,"belongType":0,"createTime":{"date":17,"day":5,"hours":10,"minutes":59,"month":4,"seconds":31,"time":1558061971000,"timezoneOffset":-480,"year":119},"createUserId":7,"description":"","deviceId":"JZCB061901000359","deviceType":6,"exportId":201905160854069771,"fourId":0,"importId":201905160898432944,"installTime":{"date":17,"day":5,"hours":11,"minutes":43,"month":4,"seconds":40,"time":1558064620000,"timezoneOffset":-480,"year":119},"installedId":0,"oneId":1032,"orderNum":5,"realPaySum":1000,"rentPriceSum":1000,"sellerId":0,"sellerType":0,"state":1,"storageTime":{"date":17,"day":5,"hours":10,"minutes":59,"month":4,"seconds":31,"time":1558061971000,"timezoneOffset":-480,"year":119},"threeId":0,"twoId":1064,"updateTime":{"date":17,"day":5,"hours":11,"minutes":54,"month":4,"seconds":29,"time":1558065269000,"timezoneOffset":-480,"year":119},"updateUserId":7}]
     * message : 2.18未分配设备列表接口访问成功
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
         * assginTime : {"date":17,"day":5,"hours":11,"minutes":54,"month":4,"seconds":29,"time":1558065269000,"timezoneOffset":-480,"year":119}
         * batchId : 1
         * batchName :
         * belongId : 1064
         * belongType : 0
         * createTime : {"date":17,"day":5,"hours":10,"minutes":59,"month":4,"seconds":31,"time":1558061971000,"timezoneOffset":-480,"year":119}
         * createUserId : 7
         * description :
         * deviceId : JZCB061901000359
         * deviceType : 6
         * exportId : 201905160854069771
         * fourId : 0
         * importId : 201905160898432944
         * installTime : {"date":17,"day":5,"hours":11,"minutes":43,"month":4,"seconds":40,"time":1558064620000,"timezoneOffset":-480,"year":119}
         * installedId : 0
         * oneId : 1032
         * orderNum : 5
         * realPaySum : 1000
         * rentPriceSum : 1000
         * sellerId : 0
         * sellerType : 0
         * state : 1
         * storageTime : {"date":17,"day":5,"hours":10,"minutes":59,"month":4,"seconds":31,"time":1558061971000,"timezoneOffset":-480,"year":119}
         * threeId : 0
         * twoId : 1064
         * updateTime : {"date":17,"day":5,"hours":11,"minutes":54,"month":4,"seconds":29,"time":1558065269000,"timezoneOffset":-480,"year":119}
         * updateUserId : 7
         */

        private AssginTimeBean assginTime;
        private int batchId;
        private String batchName;
        private int belongId;
        private int belongType;
        private CreateTimeBean createTime;
        private int createUserId;
        private String description;
        private String deviceId;
        private int deviceType;
        private long exportId;
        private int fourId;
        private long importId;
        private InstallTimeBean installTime;
        private int installedId;
        private int oneId;
        private int orderNum;
        private int realPaySum;
        private int rentPriceSum;
        private int sellerId;
        private int sellerType;
        private int state;
        private StorageTimeBean storageTime;
        private int threeId;
        private int twoId;
        private UpdateTimeBean updateTime;
        private int updateUserId;

        public AssginTimeBean getAssginTime() {
            return assginTime;
        }

        public void setAssginTime(AssginTimeBean assginTime) {
            this.assginTime = assginTime;
        }

        public int getBatchId() {
            return batchId;
        }

        public void setBatchId(int batchId) {
            this.batchId = batchId;
        }

        public String getBatchName() {
            return batchName;
        }

        public void setBatchName(String batchName) {
            this.batchName = batchName;
        }

        public int getBelongId() {
            return belongId;
        }

        public void setBelongId(int belongId) {
            this.belongId = belongId;
        }

        public int getBelongType() {
            return belongType;
        }

        public void setBelongType(int belongType) {
            this.belongType = belongType;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public int getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(int deviceType) {
            this.deviceType = deviceType;
        }

        public long getExportId() {
            return exportId;
        }

        public void setExportId(long exportId) {
            this.exportId = exportId;
        }

        public int getFourId() {
            return fourId;
        }

        public void setFourId(int fourId) {
            this.fourId = fourId;
        }

        public long getImportId() {
            return importId;
        }

        public void setImportId(long importId) {
            this.importId = importId;
        }

        public InstallTimeBean getInstallTime() {
            return installTime;
        }

        public void setInstallTime(InstallTimeBean installTime) {
            this.installTime = installTime;
        }

        public int getInstalledId() {
            return installedId;
        }

        public void setInstalledId(int installedId) {
            this.installedId = installedId;
        }

        public int getOneId() {
            return oneId;
        }

        public void setOneId(int oneId) {
            this.oneId = oneId;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public int getRealPaySum() {
            return realPaySum;
        }

        public void setRealPaySum(int realPaySum) {
            this.realPaySum = realPaySum;
        }

        public int getRentPriceSum() {
            return rentPriceSum;
        }

        public void setRentPriceSum(int rentPriceSum) {
            this.rentPriceSum = rentPriceSum;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public int getSellerType() {
            return sellerType;
        }

        public void setSellerType(int sellerType) {
            this.sellerType = sellerType;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public StorageTimeBean getStorageTime() {
            return storageTime;
        }

        public void setStorageTime(StorageTimeBean storageTime) {
            this.storageTime = storageTime;
        }

        public int getThreeId() {
            return threeId;
        }

        public void setThreeId(int threeId) {
            this.threeId = threeId;
        }

        public int getTwoId() {
            return twoId;
        }

        public void setTwoId(int twoId) {
            this.twoId = twoId;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public int getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(int updateUserId) {
            this.updateUserId = updateUserId;
        }

        public static class AssginTimeBean {
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

        public static class CreateTimeBean {
            /**
             * date : 17
             * day : 5
             * hours : 10
             * minutes : 59
             * month : 4
             * seconds : 31
             * time : 1558061971000
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

        public static class InstallTimeBean {
            /**
             * date : 17
             * day : 5
             * hours : 11
             * minutes : 43
             * month : 4
             * seconds : 40
             * time : 1558064620000
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

        public static class StorageTimeBean {
            /**
             * date : 17
             * day : 5
             * hours : 10
             * minutes : 59
             * month : 4
             * seconds : 31
             * time : 1558061971000
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
