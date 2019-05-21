package com.xiaomai.ageny.bean;

import java.util.List;

public class MyPowerListBean {

    /**
     * code : 1
     * data : [{"assginTime":{"date":21,"day":2,"hours":13,"minutes":37,"month":4,"seconds":59,"time":1558417079000,"timezoneOffset":-480,"year":119},"batchId":1,"belongId":7,"createTime":null,"deviceId":0,"exportId":0,"fourId":0,"importId":0,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB91000003","threeId":0,"twoId":0,"updateTime":null},{"assginTime":{"date":21,"day":2,"hours":13,"minutes":58,"month":4,"seconds":4,"time":1558418284000,"timezoneOffset":-480,"year":119},"batchId":1,"belongId":7,"createTime":null,"deviceId":0,"exportId":0,"fourId":0,"importId":0,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB91000327","threeId":0,"twoId":0,"updateTime":null},{"assginTime":{"date":21,"day":2,"hours":13,"minutes":46,"month":4,"seconds":1,"time":1558417561000,"timezoneOffset":-480,"year":119},"batchId":1,"belongId":7,"createTime":null,"deviceId":0,"exportId":0,"fourId":0,"importId":0,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB91000405","threeId":0,"twoId":0,"updateTime":null},{"assginTime":{"date":21,"day":2,"hours":13,"minutes":45,"month":4,"seconds":37,"time":1558417537000,"timezoneOffset":-480,"year":119},"batchId":1,"belongId":7,"createTime":null,"deviceId":0,"exportId":0,"fourId":0,"importId":0,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB91000448","threeId":0,"twoId":0,"updateTime":null},{"assginTime":{"date":21,"day":2,"hours":13,"minutes":58,"month":4,"seconds":25,"time":1558418305000,"timezoneOffset":-480,"year":119},"batchId":1,"belongId":7,"createTime":null,"deviceId":0,"exportId":0,"fourId":0,"importId":0,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB9100575","threeId":0,"twoId":0,"updateTime":null}]
     * message : 7.6我的充电宝接口访问成功
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
         * assginTime : {"date":21,"day":2,"hours":13,"minutes":37,"month":4,"seconds":59,"time":1558417079000,"timezoneOffset":-480,"year":119}
         * batchId : 1
         * belongId : 7
         * createTime : null
         * deviceId : 0
         * exportId : 0
         * fourId : 0
         * importId : 0
         * oneId : 7
         * sellerId : 0
         * status : 1
         * terminalId : JZCB91000003
         * threeId : 0
         * twoId : 0
         * updateTime : null
         */

        private AssginTimeBean assginTime;
        private int batchId;
        private int belongId;
        private Object createTime;
        private int deviceId;
        private int exportId;
        private int fourId;
        private int importId;
        private int oneId;
        private int sellerId;
        private int status;
        private String terminalId;
        private int threeId;
        private int twoId;
        private Object updateTime;

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

        public int getBelongId() {
            return belongId;
        }

        public void setBelongId(int belongId) {
            this.belongId = belongId;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public int getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(int deviceId) {
            this.deviceId = deviceId;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTerminalId() {
            return terminalId;
        }

        public void setTerminalId(String terminalId) {
            this.terminalId = terminalId;
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

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public static class AssginTimeBean {
            /**
             * date : 21
             * day : 2
             * hours : 13
             * minutes : 37
             * month : 4
             * seconds : 59
             * time : 1558417079000
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
