package com.xiaomai.ageny.bean;

public class LowerOrderDetailsBean {

    /**
     * code : 1
     * data : {"agentRealName":"张兴凯","agentid":"7","agentlevel":"2","agentmobile":"18981906214","deviceid":"JZCB061901000288","discountprice":"0.00","earn":"0.30","leasetime":"00时00分15秒","orderid":"201904151145201612","parentMobile":"15202856321","parentName":"吴凯","parentid":"5","realpayment":"3.00","rentaddress":"兆信国际1号楼(武侯区武兴路86号)兆信国际1号楼(武侯区武兴路86号)","rentprice":"3.00","renttime":"2019-04-15 11:45:20","returnaddress":"兆信国际1号楼(武侯区武兴路86号)兆信国际1号楼(武侯区武兴路86号)","returnbox":"JZCB061901000288","returnsellername":"测试商户","returntime":"2019-04-15 11:45:36","sellername":"京猪","state":"0","updTime":"2019-04-15 11:45:36"}
     * message : 5.15获取我的订单--订单详情成功
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
         * agentRealName : 张兴凯
         * agentid : 7
         * agentlevel : 2
         * agentmobile : 18981906214
         * deviceid : JZCB061901000288
         * discountprice : 0.00
         * earn : 0.30
         * leasetime : 00时00分15秒
         * orderid : 201904151145201612
         * parentMobile : 15202856321
         * parentName : 吴凯
         * parentid : 5
         * realpayment : 3.00
         * rentaddress : 兆信国际1号楼(武侯区武兴路86号)兆信国际1号楼(武侯区武兴路86号)
         * rentprice : 3.00
         * renttime : 2019-04-15 11:45:20
         * returnaddress : 兆信国际1号楼(武侯区武兴路86号)兆信国际1号楼(武侯区武兴路86号)
         * returnbox : JZCB061901000288
         * returnsellername : 测试商户
         * returntime : 2019-04-15 11:45:36
         * sellername : 京猪
         * state : 0
         * updTime : 2019-04-15 11:45:36
         */

        private String agentRealName;
        private String agentid;
        private String agentlevel;
        private String agentmobile;
        private String deviceid;
        private String discountprice;
        private String earn;
        private String leasetime;
        private String orderid;
        private String parentMobile;
        private String parentName;
        private String parentid;
        private String realpayment;
        private String rentaddress;
        private String rentprice;
        private String renttime;
        private String returnaddress;
        private String returnbox;
        private String returnsellername;
        private String returntime;
        private String sellername;
        private String state;
        private String updTime;

        public String getAgentRealName() {
            return agentRealName;
        }

        public void setAgentRealName(String agentRealName) {
            this.agentRealName = agentRealName;
        }

        public String getAgentid() {
            return agentid;
        }

        public void setAgentid(String agentid) {
            this.agentid = agentid;
        }

        public String getAgentlevel() {
            return agentlevel;
        }

        public void setAgentlevel(String agentlevel) {
            this.agentlevel = agentlevel;
        }

        public String getAgentmobile() {
            return agentmobile;
        }

        public void setAgentmobile(String agentmobile) {
            this.agentmobile = agentmobile;
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

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getParentMobile() {
            return parentMobile;
        }

        public void setParentMobile(String parentMobile) {
            this.parentMobile = parentMobile;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public String getParentid() {
            return parentid;
        }

        public void setParentid(String parentid) {
            this.parentid = parentid;
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

        public String getReturnbox() {
            return returnbox;
        }

        public void setReturnbox(String returnbox) {
            this.returnbox = returnbox;
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
