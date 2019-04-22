package com.xiaomai.ageny.bean;

public class MyBankBean {

    /**
     * code : 1
     * data : {"agentId":1,"bank":"好嗨哟","createTime":{"date":12,"day":2,"hours":13,"minutes":54,"month":2,"seconds":39,"time":1552370079000,"timezoneOffset":-480,"year":119},"creditCard":"****   ****   ****   5478","details":"","id":2,"mobile":"125****6541","realName":"华总","sellerId":0,"subBank":"","updTime":{"date":13,"day":3,"hours":9,"minutes":36,"month":2,"seconds":28,"time":1552440988000,"timezoneOffset":-480,"year":119}}
     * message : 获取银行卡信息成功
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
         * bank : 好嗨哟
         * createTime : {"date":12,"day":2,"hours":13,"minutes":54,"month":2,"seconds":39,"time":1552370079000,"timezoneOffset":-480,"year":119}
         * creditCard : ****   ****   ****   5478
         * details :
         * id : 2
         * mobile : 125****6541
         * realName : 华总
         * sellerId : 0
         * subBank :
         * updTime : {"date":13,"day":3,"hours":9,"minutes":36,"month":2,"seconds":28,"time":1552440988000,"timezoneOffset":-480,"year":119}
         */

        private int agentId;
        private String bank;
        private CreateTimeBean createTime;
        private String creditCard;
        private String details;
        private int id;
        private String mobile;
        private String realName;
        private int sellerId;
        private String subBank;
        private UpdTimeBean updTime;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public String getCreditCard() {
            return creditCard;
        }

        public void setCreditCard(String creditCard) {
            this.creditCard = creditCard;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public String getSubBank() {
            return subBank;
        }

        public void setSubBank(String subBank) {
            this.subBank = subBank;
        }

        public UpdTimeBean getUpdTime() {
            return updTime;
        }

        public void setUpdTime(UpdTimeBean updTime) {
            this.updTime = updTime;
        }

        public static class CreateTimeBean {
            /**
             * date : 12
             * day : 2
             * hours : 13
             * minutes : 54
             * month : 2
             * seconds : 39
             * time : 1552370079000
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

        public static class UpdTimeBean {
            /**
             * date : 13
             * day : 3
             * hours : 9
             * minutes : 36
             * month : 2
             * seconds : 28
             * time : 1552440988000
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
