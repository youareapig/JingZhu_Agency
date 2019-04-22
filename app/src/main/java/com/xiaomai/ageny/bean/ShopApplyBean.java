package com.xiaomai.ageny.bean;

import java.util.List;

public class ShopApplyBean {

    /**
     * code : 1
     * data : [{"agentId":1,"applyTime":null,"batch":"1","details":"采购须知","deviceBig":"12口11台","deviceBigDelivery":"0","deviceBigNodelivery":"0","deviceBigcount":"1000","deviceSmall":"6台5口","deviceSmallDelivery":"0","deviceSmallNodelivery":"0","deviceSmallcount":"20","examination":"","handleTime":null,"id":1,"payment":"一次性付款","receiptAddress":"四川省","receiptId":"201904221340098724","receiptMobile":"18981906214","receiptName":"张三","state":"1"},{"agentId":1,"applyTime":null,"batch":"1","details":"快","deviceBig":"12口11台","deviceBigDelivery":"0","deviceBigNodelivery":"0","deviceBigcount":"12","deviceSmall":"6口5台","deviceSmallDelivery":"0","deviceSmallNodelivery":"0","deviceSmallcount":"12","examination":"","handleTime":null,"id":2,"payment":"分期付款","receiptAddress":"兆信国际","receiptId":"201904221343467084","receiptMobile":"17360054510","receiptName":"明","state":"-1"},{"agentId":1,"applyTime":null,"batch":"2","details":"快快","deviceBig":"12口11台","deviceBigDelivery":"0","deviceBigNodelivery":"0","deviceBigcount":"10","deviceSmall":"6口5台","deviceSmallDelivery":"0","deviceSmallNodelivery":"0","deviceSmallcount":"12","examination":"","handleTime":null,"id":3,"payment":"分期付款","receiptAddress":"下兆信国际","receiptId":"201904221344118251","receiptMobile":"17360054510","receiptName":"田明焕","state":"0"}]
     * message : 获取申请表列表
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
         * applyTime : null
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
         * examination :
         * handleTime : null
         * id : 1
         * payment : 一次性付款
         * receiptAddress : 四川省
         * receiptId : 201904221340098724
         * receiptMobile : 18981906214
         * receiptName : 张三
         * state : 1
         */

        private int agentId;
        private Object applyTime;
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
        private Object handleTime;
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

        public Object getApplyTime() {
            return applyTime;
        }

        public void setApplyTime(Object applyTime) {
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

        public Object getHandleTime() {
            return handleTime;
        }

        public void setHandleTime(Object handleTime) {
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
    }
}
