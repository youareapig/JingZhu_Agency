package com.xiaomai.ageny.bean;

public class MyOrderDetailsBean {

    /**
     * code : 1
     * data : {"deviceid":"JZCB061901000685","discountprice":"0.00","earn":"0.00","leasetime":"00时00分03秒","orderid":"201904032023317848","realpayment":"0.00","rentaddress":"成都市二号雅舍(武侯区清河路西南方向160米)二号雅舍(武侯区清河路西南方向160米)","rentprice":"0.00","renttime":"2019-04-03 20:23:32","returnaddress":"成都市二号雅舍(武侯区清河路西南方向160米)二号雅舍(武侯区清河路西南方向160米)","returnbox":"JZCB061901000685","returnsellername":"丰涛火锅","returntime":"2019-04-03 20:23:36","sellername":"丰涛火锅","state":"0","updTime":"2019-04-03 20:23:36"}
     * message : 5.11获取我的订单--订单详情成功
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
         * deviceid : JZCB061901000685
         * discountprice : 0.00
         * earn : 0.00
         * leasetime : 00时00分03秒
         * orderid : 201904032023317848
         * realpayment : 0.00
         * rentaddress : 成都市二号雅舍(武侯区清河路西南方向160米)二号雅舍(武侯区清河路西南方向160米)
         * rentprice : 0.00
         * renttime : 2019-04-03 20:23:32
         * returnaddress : 成都市二号雅舍(武侯区清河路西南方向160米)二号雅舍(武侯区清河路西南方向160米)
         * returnbox : JZCB061901000685
         * returnsellername : 丰涛火锅
         * returntime : 2019-04-03 20:23:36
         * sellername : 丰涛火锅
         * state : 0
         * updTime : 2019-04-03 20:23:36
         */

        private String deviceid;
        private String discountprice;
        private String earn;
        private String leasetime;
        private String orderid;
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
