package com.xiaomai.ageny.bean;

public class AgencyUserInfoBean {

    /**
     * code : 1
     * data : {"address":"","age":0,"area":"台湾","companyName":"","createTime":{"date":14,"day":2,"hours":16,"minutes":50,"month":4,"seconds":48,"time":1557823848000,"timezoneOffset":-480,"year":119},"createTimeStr":"2019-05-14 16:50:48","details":"","headPic":"","id":61001052,"lastLoginip":"","lastLogintime":{"date":14,"day":2,"hours":16,"minutes":50,"month":4,"seconds":48,"time":1557823848000,"timezoneOffset":-480,"year":119},"level":2,"maxReward":"100","mobile":"15888888887","num":0,"openid":"","parentid":435,"password":"","realname":"周杰伦","reward":99,"sex":"","state":1,"updateTime":{"date":14,"day":2,"hours":16,"minutes":50,"month":4,"seconds":48,"time":1557823848000,"timezoneOffset":-480,"year":119},"userType":0,"username":"","weixinNickname":"","weixinToken":""}
     * message : 获取直属代理商个人信息成功
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
         * address :
         * age : 0
         * area : 台湾
         * companyName :
         * createTime : {"date":14,"day":2,"hours":16,"minutes":50,"month":4,"seconds":48,"time":1557823848000,"timezoneOffset":-480,"year":119}
         * createTimeStr : 2019-05-14 16:50:48
         * details :
         * headPic :
         * id : 61001052
         * lastLoginip :
         * lastLogintime : {"date":14,"day":2,"hours":16,"minutes":50,"month":4,"seconds":48,"time":1557823848000,"timezoneOffset":-480,"year":119}
         * level : 2
         * maxReward : 100
         * mobile : 15888888887
         * num : 0
         * openid :
         * parentid : 435
         * password :
         * realname : 周杰伦
         * reward : 99
         * sex :
         * state : 1
         * updateTime : {"date":14,"day":2,"hours":16,"minutes":50,"month":4,"seconds":48,"time":1557823848000,"timezoneOffset":-480,"year":119}
         * userType : 0
         * username :
         * weixinNickname :
         * weixinToken :
         */

        private String address;
        private int age;
        private String area;
        private String companyName;
        private CreateTimeBean createTime;
        private String createTimeStr;
        private String details;
        private String headPic;
        private int id;
        private String lastLoginip;
        private LastLogintimeBean lastLogintime;
        private int level;
        private String maxReward;
        private String mobile;
        private int num;
        private String openid;
        private int parentid;
        private String password;
        private String realname;
        private int reward;
        private String sex;
        private int state;
        private UpdateTimeBean updateTime;
        private int userType;
        private String username;
        private String weixinNickname;
        private String weixinToken;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public String getCreateTimeStr() {
            return createTimeStr;
        }

        public void setCreateTimeStr(String createTimeStr) {
            this.createTimeStr = createTimeStr;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLastLoginip() {
            return lastLoginip;
        }

        public void setLastLoginip(String lastLoginip) {
            this.lastLoginip = lastLoginip;
        }

        public LastLogintimeBean getLastLogintime() {
            return lastLogintime;
        }

        public void setLastLogintime(LastLogintimeBean lastLogintime) {
            this.lastLogintime = lastLogintime;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getMaxReward() {
            return maxReward;
        }

        public void setMaxReward(String maxReward) {
            this.maxReward = maxReward;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public int getParentid() {
            return parentid;
        }

        public void setParentid(int parentid) {
            this.parentid = parentid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getWeixinNickname() {
            return weixinNickname;
        }

        public void setWeixinNickname(String weixinNickname) {
            this.weixinNickname = weixinNickname;
        }

        public String getWeixinToken() {
            return weixinToken;
        }

        public void setWeixinToken(String weixinToken) {
            this.weixinToken = weixinToken;
        }

        public static class CreateTimeBean {
            /**
             * date : 14
             * day : 2
             * hours : 16
             * minutes : 50
             * month : 4
             * seconds : 48
             * time : 1557823848000
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

        public static class LastLogintimeBean {
            /**
             * date : 14
             * day : 2
             * hours : 16
             * minutes : 50
             * month : 4
             * seconds : 48
             * time : 1557823848000
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
             * date : 14
             * day : 2
             * hours : 16
             * minutes : 50
             * month : 4
             * seconds : 48
             * time : 1557823848000
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
