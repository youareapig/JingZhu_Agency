package com.xiaomai.ageny.bean;

import java.util.List;

public class ContactUserInfoBean {

    /**
     * code : 1
     * data : {"address":"四川省成都市武侯区洗面桥街17号","agentId":1,"agentMobile":"18683958888","area":"","canRent":true,"canReturn":false,"city":"","createTime":{"date":30,"day":3,"hours":12,"minutes":32,"month":0,"seconds":20,"time":1548822740000,"timezoneOffset":-480,"year":119},"createTimestr":"2019-01-30 12:32:20","details":"","id":61000113,"latitude":30.63705,"linkman":"","linktel":"","longitude":104.05362,"name":"成都慈爱直属医院","openTime":"0:00-24:00","personCost":"100","pics":"[\"https://www.jzcdsc.com/pics/big1.jpg\",\"https://www.jzcdsc.com/pics/big2.jpg\",\"https://www.jzcdsc.com/pics/big3.jpg\"]","picsList":[],"province":"","reward":100,"rewardTo":"100%","smallpic":"https://www.jzcdsc.com/pics/small.jpg","updateTime":{"date":11,"day":4,"hours":19,"minutes":31,"month":3,"seconds":26,"time":1554982286000,"timezoneOffset":-480,"year":119},"updateTimestr":""}
     * message : 查找资料成功
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
         * address : 四川省成都市武侯区洗面桥街17号
         * agentId : 1
         * agentMobile : 18683958888
         * area :
         * canRent : true
         * canReturn : false
         * city :
         * createTime : {"date":30,"day":3,"hours":12,"minutes":32,"month":0,"seconds":20,"time":1548822740000,"timezoneOffset":-480,"year":119}
         * createTimestr : 2019-01-30 12:32:20
         * details :
         * id : 61000113
         * latitude : 30.63705
         * linkman :
         * linktel :
         * longitude : 104.05362
         * name : 成都慈爱直属医院
         * openTime : 0:00-24:00
         * personCost : 100
         * pics : ["https://www.jzcdsc.com/pics/big1.jpg","https://www.jzcdsc.com/pics/big2.jpg","https://www.jzcdsc.com/pics/big3.jpg"]
         * picsList : []
         * province :
         * reward : 100
         * rewardTo : 100%
         * smallpic : https://www.jzcdsc.com/pics/small.jpg
         * updateTime : {"date":11,"day":4,"hours":19,"minutes":31,"month":3,"seconds":26,"time":1554982286000,"timezoneOffset":-480,"year":119}
         * updateTimestr :
         */

        private String address;
        private int agentId;
        private String agentMobile;
        private String area;
        private boolean canRent;
        private boolean canReturn;
        private String city;
        private CreateTimeBean createTime;
        private String createTimestr;
        private String details;
        private int id;
        private double latitude;
        private String linkman;
        private String linktel;
        private double longitude;
        private String name;
        private String openTime;
        private String personCost;
        private String pics;
        private String province;
        private int reward;
        private String rewardTo;
        private String smallpic;
        private UpdateTimeBean updateTime;
        private String updateTimestr;
        private List<?> picsList;

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

        public String getAgentMobile() {
            return agentMobile;
        }

        public void setAgentMobile(String agentMobile) {
            this.agentMobile = agentMobile;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public String getCreateTimestr() {
            return createTimestr;
        }

        public void setCreateTimestr(String createTimestr) {
            this.createTimestr = createTimestr;
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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getLinkman() {
            return linkman;
        }

        public void setLinkman(String linkman) {
            this.linkman = linkman;
        }

        public String getLinktel() {
            return linktel;
        }

        public void setLinktel(String linktel) {
            this.linktel = linktel;
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

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public String getPersonCost() {
            return personCost;
        }

        public void setPersonCost(String personCost) {
            this.personCost = personCost;
        }

        public String getPics() {
            return pics;
        }

        public void setPics(String pics) {
            this.pics = pics;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
        }

        public String getRewardTo() {
            return rewardTo;
        }

        public void setRewardTo(String rewardTo) {
            this.rewardTo = rewardTo;
        }

        public String getSmallpic() {
            return smallpic;
        }

        public void setSmallpic(String smallpic) {
            this.smallpic = smallpic;
        }

        public UpdateTimeBean getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(UpdateTimeBean updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateTimestr() {
            return updateTimestr;
        }

        public void setUpdateTimestr(String updateTimestr) {
            this.updateTimestr = updateTimestr;
        }

        public List<?> getPicsList() {
            return picsList;
        }

        public void setPicsList(List<?> picsList) {
            this.picsList = picsList;
        }

        public static class CreateTimeBean {
            /**
             * date : 30
             * day : 3
             * hours : 12
             * minutes : 32
             * month : 0
             * seconds : 20
             * time : 1548822740000
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
             * date : 11
             * day : 4
             * hours : 19
             * minutes : 31
             * month : 3
             * seconds : 26
             * time : 1554982286000
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
