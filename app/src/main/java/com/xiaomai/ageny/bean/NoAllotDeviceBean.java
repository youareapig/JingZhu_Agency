package com.xiaomai.ageny.bean;

import java.util.List;

public class NoAllotDeviceBean {

    /**
     * code : 1
     * data : [{"assginTime":{"date":18,"day":4,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1555567750000,"timezoneOffset":-480,"year":119},"batchId":1,"batchName":"","belongType":0,"createTime":{"date":23,"day":2,"hours":15,"minutes":54,"month":3,"seconds":50,"time":1556006090000,"timezoneOffset":-480,"year":119},"createUserId":0,"description":"","deviceId":"JZCB061901000005","deviceType":6,"exportId":1,"fourId":0,"importId":1,"installTime":null,"oneId":1,"sellerId":0,"sellerType":0,"state":1,"storageTime":{"date":23,"day":2,"hours":15,"minutes":54,"month":3,"seconds":50,"time":1556006090000,"timezoneOffset":-480,"year":119},"threeId":0,"twoId":0,"updateTime":{"date":23,"day":2,"hours":15,"minutes":54,"month":3,"seconds":50,"time":1556006090000,"timezoneOffset":-480,"year":119},"updateUserId":0}]
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
         * assginTime : {"date":18,"day":4,"hours":14,"minutes":9,"month":3,"seconds":10,"time":1555567750000,"timezoneOffset":-480,"year":119}
         * batchId : 1
         * batchName :
         * belongType : 0
         * createTime : {"date":23,"day":2,"hours":15,"minutes":54,"month":3,"seconds":50,"time":1556006090000,"timezoneOffset":-480,"year":119}
         * createUserId : 0
         * description :
         * deviceId : JZCB061901000005
         * deviceType : 6
         * exportId : 1
         * fourId : 0
         * importId : 1
         * installTime : null
         * oneId : 1
         * sellerId : 0
         * sellerType : 0
         * state : 1
         * storageTime : {"date":23,"day":2,"hours":15,"minutes":54,"month":3,"seconds":50,"time":1556006090000,"timezoneOffset":-480,"year":119}
         * threeId : 0
         * twoId : 0
         * updateTime : {"date":23,"day":2,"hours":15,"minutes":54,"month":3,"seconds":50,"time":1556006090000,"timezoneOffset":-480,"year":119}
         * updateUserId : 0
         */

        private AssginTimeBean assginTime;
        private int batchId;
        private String batchName;
        private int belongType;
        private CreateTimeBean createTime;
        private int createUserId;
        private String description;
        private String deviceId;
        private int deviceType;
        private int exportId;
        private int fourId;
        private int importId;
        private Object installTime;
        private int oneId;
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

        public int getExportId() {
            return exportId;
        }

        public void setExportId(int exportId) {
            this.exportId = exportId;
        }

        public int getFourId() {
            return fourId;
        }

        public void setFourId(int fourId) {
            this.fourId = fourId;
        }

        public int getImportId() {
            return importId;
        }

        public void setImportId(int importId) {
            this.importId = importId;
        }

        public Object getInstallTime() {
            return installTime;
        }

        public void setInstallTime(Object installTime) {
            this.installTime = installTime;
        }

        public int getOneId() {
            return oneId;
        }

        public void setOneId(int oneId) {
            this.oneId = oneId;
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

        public static class CreateTimeBean {
            /**
             * date : 23
             * day : 2
             * hours : 15
             * minutes : 54
             * month : 3
             * seconds : 50
             * time : 1556006090000
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
             * date : 23
             * day : 2
             * hours : 15
             * minutes : 54
             * month : 3
             * seconds : 50
             * time : 1556006090000
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
             * date : 23
             * day : 2
             * hours : 15
             * minutes : 54
             * month : 3
             * seconds : 50
             * time : 1556006090000
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
