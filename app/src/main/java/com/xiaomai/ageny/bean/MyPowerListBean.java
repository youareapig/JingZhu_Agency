package com.xiaomai.ageny.bean;

import java.util.List;

public class MyPowerListBean {

    /**
     * code : 1
     * data : {"list":[{"assginTime":{"date":23,"day":4,"hours":13,"minutes":50,"month":4,"seconds":58,"time":1558590658000,"timezoneOffset":-480,"year":119},"assginTimeStr":"2019-05-23","batchId":2,"belongId":7,"createTime":{"date":23,"day":4,"hours":13,"minutes":42,"month":4,"seconds":17,"time":1558590137000,"timezoneOffset":-480,"year":119},"deviceId":0,"exportId":201905230143200592,"fourId":0,"importId":201905230153746734,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB91000456","threeId":0,"twoId":0,"updateTime":{"date":23,"day":4,"hours":13,"minutes":50,"month":4,"seconds":58,"time":1558590658000,"timezoneOffset":-480,"year":119}}],"page":1,"pageSize":25,"total":"1"}
     * message : 7.6我的充电宝接口访问成功
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
         * list : [{"assginTime":{"date":23,"day":4,"hours":13,"minutes":50,"month":4,"seconds":58,"time":1558590658000,"timezoneOffset":-480,"year":119},"assginTimeStr":"2019-05-23","batchId":2,"belongId":7,"createTime":{"date":23,"day":4,"hours":13,"minutes":42,"month":4,"seconds":17,"time":1558590137000,"timezoneOffset":-480,"year":119},"deviceId":0,"exportId":201905230143200592,"fourId":0,"importId":201905230153746734,"oneId":7,"sellerId":0,"status":1,"terminalId":"JZCB91000456","threeId":0,"twoId":0,"updateTime":{"date":23,"day":4,"hours":13,"minutes":50,"month":4,"seconds":58,"time":1558590658000,"timezoneOffset":-480,"year":119}}]
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
             * assginTime : {"date":23,"day":4,"hours":13,"minutes":50,"month":4,"seconds":58,"time":1558590658000,"timezoneOffset":-480,"year":119}
             * assginTimeStr : 2019-05-23
             * batchId : 2
             * belongId : 7
             * createTime : {"date":23,"day":4,"hours":13,"minutes":42,"month":4,"seconds":17,"time":1558590137000,"timezoneOffset":-480,"year":119}
             * deviceId : 0
             * exportId : 201905230143200592
             * fourId : 0
             * importId : 201905230153746734
             * oneId : 7
             * sellerId : 0
             * status : 1
             * terminalId : JZCB91000456
             * threeId : 0
             * twoId : 0
             * updateTime : {"date":23,"day":4,"hours":13,"minutes":50,"month":4,"seconds":58,"time":1558590658000,"timezoneOffset":-480,"year":119}
             */

            private AssginTimeBean assginTime;
            private String assginTimeStr;
            private int batchId;
            private int belongId;
            private CreateTimeBean createTime;
            private int deviceId;
            private long exportId;
            private int fourId;
            private long importId;
            private int oneId;
            private int sellerId;
            private int status;
            private String terminalId;
            private int threeId;
            private int twoId;
            private UpdateTimeBean updateTime;

            public AssginTimeBean getAssginTime() {
                return assginTime;
            }

            public void setAssginTime(AssginTimeBean assginTime) {
                this.assginTime = assginTime;
            }

            public String getAssginTimeStr() {
                return assginTimeStr;
            }

            public void setAssginTimeStr(String assginTimeStr) {
                this.assginTimeStr = assginTimeStr;
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

            public CreateTimeBean getCreateTime() {
                return createTime;
            }

            public void setCreateTime(CreateTimeBean createTime) {
                this.createTime = createTime;
            }

            public int getDeviceId() {
                return deviceId;
            }

            public void setDeviceId(int deviceId) {
                this.deviceId = deviceId;
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

            public UpdateTimeBean getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(UpdateTimeBean updateTime) {
                this.updateTime = updateTime;
            }

            public static class AssginTimeBean {
                /**
                 * date : 23
                 * day : 4
                 * hours : 13
                 * minutes : 50
                 * month : 4
                 * seconds : 58
                 * time : 1558590658000
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
                 * day : 4
                 * hours : 13
                 * minutes : 42
                 * month : 4
                 * seconds : 17
                 * time : 1558590137000
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
                 * day : 4
                 * hours : 13
                 * minutes : 50
                 * month : 4
                 * seconds : 58
                 * time : 1558590658000
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
