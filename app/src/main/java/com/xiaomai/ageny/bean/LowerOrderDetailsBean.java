package com.xiaomai.ageny.bean;

public class LowerOrderDetailsBean {


    /**
     * code : 1
     * data : {"agentmobile":"","agentname":"成华区税务局","deviceid":"","discountprice":"0.00","earn":"4.00","leasetime":"01时53分16秒","level":"一级代理","orderid":"201904121201410773","realname":"","realpayment":"4.00","rentaddress":"四川省成都市成华区双林路55号","rentprice":"4.00","renttime":"2019-04-12 12:01:42","returnaddress":"四川省成都市成华区双林路55号","returnboxid":"JZCB061901000681","returnsellername":"成华区税务局大厅","returntime":"2019-04-12 13:54:58","sellername":"国家税务总局成都市成华区税务局猛追湾税务所","state":"0","updTime":"2019-04-12 13:54:58"}
     * message : 5.13获取下级订单--订单详情成功
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
         * agentmobile :
         * agentname : 成华区税务局
         * deviceid :
         * discountprice : 0.00
         * earn : 4.00
         * leasetime : 01时53分16秒
         * level : 一级代理
         * orderid : 201904121201410773
         * realname :
         * realpayment : 4.00
         * rentaddress : 四川省成都市成华区双林路55号
         * rentprice : 4.00
         * renttime : 2019-04-12 12:01:42
         * returnaddress : 四川省成都市成华区双林路55号
         * returnboxid : JZCB061901000681
         * returnsellername : 成华区税务局大厅
         * returntime : 2019-04-12 13:54:58
         * sellername : 国家税务总局成都市成华区税务局猛追湾税务所
         * state : 0
         * updTime : 2019-04-12 13:54:58
         */

        private String agentmobile;
        private String agentname;
        private String deviceid;
        private String discountprice;
        private String earn;
        private String leasetime;
        private String level;
        private String orderid;
        private String realname;
        private String realpayment;
        private String rentaddress;
        private String rentprice;
        private String renttime;
        private String returnaddress;
        private String returnboxid;
        private String returnsellername;
        private String returntime;
        private String sellername;
        private String state;
        private String updTime;

        public String getAgentmobile() {
            return agentmobile;
        }

        public void setAgentmobile(String agentmobile) {
            this.agentmobile = agentmobile;
        }

        public String getAgentname() {
            return agentname;
        }

        public void setAgentname(String agentname) {
            this.agentname = agentname;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public String getDiscountprice() {
            return discountprice;
        }

        public void setDiscountprice(String discountprice) {
            this.discountprice = discountprice;
        }

        public String getEarn() {
            return earn;
        }

        public void setEarn(String earn) {
            this.earn = earn;
        }

        public String getLeasetime() {
            return leasetime;
        }

        public void setLeasetime(String leasetime) {
            this.leasetime = leasetime;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getRealpayment() {
            return realpayment;
        }

        public void setRealpayment(String realpayment) {
            this.realpayment = realpayment;
        }

        public String getRentaddress() {
            return rentaddress;
        }

        public void setRentaddress(String rentaddress) {
            this.rentaddress = rentaddress;
        }

        public String getRentprice() {
            return rentprice;
        }

        public void setRentprice(String rentprice) {
            this.rentprice = rentprice;
        }

        public String getRenttime() {
            return renttime;
        }

        public void setRenttime(String renttime) {
            this.renttime = renttime;
        }

        public String getReturnaddress() {
            return returnaddress;
        }

        public void setReturnaddress(String returnaddress) {
            this.returnaddress = returnaddress;
        }

        public String getReturnboxid() {
            return returnboxid;
        }

        public void setReturnboxid(String returnboxid) {
            this.returnboxid = returnboxid;
        }

        public String getReturnsellername() {
            return returnsellername;
        }

        public void setReturnsellername(String returnsellername) {
            this.returnsellername = returnsellername;
        }

        public String getReturntime() {
            return returntime;
        }

        public void setReturntime(String returntime) {
            this.returntime = returntime;
        }

        public String getSellername() {
            return sellername;
        }

        public void setSellername(String sellername) {
            this.sellername = sellername;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUpdTime() {
            return updTime;
        }

        public void setUpdTime(String updTime) {
            this.updTime = updTime;
        }
    }
}
