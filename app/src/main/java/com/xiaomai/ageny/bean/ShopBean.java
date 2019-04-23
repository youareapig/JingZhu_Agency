package com.xiaomai.ageny.bean;

public class ShopBean {

    /**
     * code : 1
     * data : {"agentId":1,"applyTime":{"date":22,"day":1,"hours":13,"minutes":47,"month":3,"seconds":58,"time":1555912078000,"timezoneOffset":-480,"year":119},"batch":"1","details":"采购须知","deviceBig":"12口11台","deviceBigDelivery":"0","deviceBigNodelivery":"0","deviceBigcount":"1000","deviceSmall":"6台5口","deviceSmallDelivery":"0","deviceSmallNodelivery":"0","deviceSmallcount":"20","examination":"钱没打够","handleTime":{"date":22,"day":1,"hours":17,"minutes":30,"month":3,"seconds":34,"time":1555925434000,"timezoneOffset":-480,"year":119},"id":1,"payment":"一次性付款","receiptAddress":"四川省","receiptId":"201904221340098724","receiptMobile":"18981906214","receiptName":"张三","state":"1"}
     * message : 获取采购单详情
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
         * agentId : 1
         * applyTime : {"date":22,"day":1,"hours":13,"minutes":47,"month":3,"seconds":58,"time":1555912078000,"timezoneOffset":-480,"year":119}
         * batch : 1
         * details : 采购须知
         * deviceBig : 12口11台
         * deviceBigDelivery : 0
         * deviceBigNodelivery : 0
         * deviceBigcount : 1000
         * deviceSmall : 6台5口
         * deviceSmallDelivery : 0
         * deviceSmallNodelivery : 0
         * deviceSmallcount : 20
         * examination : 钱没打够
         * handleTime : {"date":22,"day":1,"hours":17,"minutes":30,"month":3,"seconds":34,"time":1555925434000,"timezoneOffset":-480,"year":119}
         * id : 1
         * payment : 一次性付款
         * receiptAddress : 四川省
         * receiptId : 201904221340098724
         * receiptMobile : 18981906214
         * receiptName : 张三
         * state : 1
         */

        private int agentId;
        private ApplyTimeBean applyTime;
        private String batch;
        private String details;
        private String deviceBig;
        private String deviceBigDelivery;
        private String deviceBigNodelivery;
        private String deviceBigcount;
        private String deviceSmall;
        private String deviceSmallDelivery;
        private String deviceSmallNodelivery;
        private String deviceSmallcount;
        private String examination;
        private HandleTimeBean handleTime;
        private int id;
        private String payment;
        private String receiptAddress;
        private String receiptId;
        private String receiptMobile;
        private String receiptName;
        private String state;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public ApplyTimeBean getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(ApplyTimeBean applyTime) {
            this.applyTime = applyTime;
        }

        public String getBatch() {
            return batch;
        }

        public void setBatch(String batch) {
            this.batch = batch;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getDeviceBig() {
            return deviceBig;
        }

        public void setDeviceBig(String deviceBig) {
            this.deviceBig = deviceBig;
        }

        public String getDeviceBigDelivery() {
            return deviceBigDelivery;
        }

        public void setDeviceBigDelivery(String deviceBigDelivery) {
            this.deviceBigDelivery = deviceBigDelivery;
        }

        public String getDeviceBigNodelivery() {
            return deviceBigNodelivery;
        }

        public void setDeviceBigNodelivery(String deviceBigNodelivery) {
            this.deviceBigNodelivery = deviceBigNodelivery;
        }

        public String getDeviceBigcount() {
            return deviceBigcount;
        }

        public void setDeviceBigcount(String deviceBigcount) {
            this.deviceBigcount = deviceBigcount;
        }

        public String getDeviceSmall() {
            return deviceSmall;
        }

        public void setDeviceSmall(String deviceSmall) {
            this.deviceSmall = deviceSmall;
        }

        public String getDeviceSmallDelivery() {
            return deviceSmallDelivery;
        }

        public void setDeviceSmallDelivery(String deviceSmallDelivery) {
            this.deviceSmallDelivery = deviceSmallDelivery;
        }

        public String getDeviceSmallNodelivery() {
            return deviceSmallNodelivery;
        }

        public void setDeviceSmallNodelivery(String deviceSmallNodelivery) {
            this.deviceSmallNodelivery = deviceSmallNodelivery;
        }

        public String getDeviceSmallcount() {
            return deviceSmallcount;
        }

        public void setDeviceSmallcount(String deviceSmallcount) {
            this.deviceSmallcount = deviceSmallcount;
        }

        public String getExamination() {
            return examination;
        }

        public void setExamination(String examination) {
            this.examination = examination;
        }

        public HandleTimeBean getHandleTime() {
            return handleTime;
        }

        public void setHandleTime(HandleTimeBean handleTime) {
            this.handleTime = handleTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public String getReceiptAddress() {
            return receiptAddress;
        }

        public void setReceiptAddress(String receiptAddress) {
            this.receiptAddress = receiptAddress;
        }

        public String getReceiptId() {
            return receiptId;
        }

        public void setReceiptId(String receiptId) {
            this.receiptId = receiptId;
        }

        public String getReceiptMobile() {
            return receiptMobile;
        }

        public void setReceiptMobile(String receiptMobile) {
            this.receiptMobile = receiptMobile;
        }

        public String getReceiptName() {
            return receiptName;
        }

        public void setReceiptName(String receiptName) {
            this.receiptName = receiptName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public static class ApplyTimeBean {
            /**
             * date : 22
             * day : 1
             * hours : 13
             * minutes : 47
             * month : 3
             * seconds : 58
             * time : 1555912078000
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

        public static class HandleTimeBean {
            /**
             * date : 22
             * day : 1
             * hours : 17
             * minutes : 30
             * month : 3
             * seconds : 34
             * time : 1555925434000
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
