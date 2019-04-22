package com.xiaomai.ageny.bean;

import java.util.List;

public class UnbindRecordBean {

    /**
     * code : 1
     * data : [{"agentId":1,"applyTime":"2019-04-20 12:06:30","datails":"","id":2,"info":"dddd","passTime":"","sellerId":1026,"sellerLinkman":"张姐","sellerLinktel":"13880076060","sellerName":"丰涛火锅","state":"1"}]
     * message : 获取解绑单成功！
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
         * agentId : 1
         * applyTime : 2019-04-20 12:06:30
         * datails :
         * id : 2
         * info : dddd
         * passTime :
         * sellerId : 1026
         * sellerLinkman : 张姐
         * sellerLinktel : 13880076060
         * sellerName : 丰涛火锅
         * state : 1
         */

        private int agentId;
        private String applyTime;
        private String datails;
        private int id;
        private String info;
        private String passTime;
        private int sellerId;
        private String sellerLinkman;
        private String sellerLinktel;
        private String sellerName;
        private String state;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public String getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(String applyTime) {
            this.applyTime = applyTime;
        }

        public String getDatails() {
            return datails;
        }

        public void setDatails(String datails) {
            this.datails = datails;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getPassTime() {
            return passTime;
        }

        public void setPassTime(String passTime) {
            this.passTime = passTime;
        }

        public int getSellerId() {
            return sellerId;
        }

        public void setSellerId(int sellerId) {
            this.sellerId = sellerId;
        }

        public String getSellerLinkman() {
            return sellerLinkman;
        }

        public void setSellerLinkman(String sellerLinkman) {
            this.sellerLinkman = sellerLinkman;
        }

        public String getSellerLinktel() {
            return sellerLinktel;
        }

        public void setSellerLinktel(String sellerLinktel) {
            this.sellerLinktel = sellerLinktel;
        }

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}
