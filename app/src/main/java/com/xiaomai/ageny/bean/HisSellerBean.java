package com.xiaomai.ageny.bean;

public class HisSellerBean {

    /**
     * code : 1
     * data : {"money":"0.00","ordercount":"0","sellercount":"20"}
     * message : 获取他的商户数据成功
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
         * money : 0.00
         * ordercount : 0
         * sellercount : 20
         */

        private String money;
        private String ordercount;
        private String sellercount;

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getOrdercount() {
            return ordercount;
        }

        public void setOrdercount(String ordercount) {
            this.ordercount = ordercount;
        }

        public String getSellercount() {
            return sellercount;
        }

        public void setSellercount(String sellercount) {
            this.sellercount = sellercount;
        }
    }
}
