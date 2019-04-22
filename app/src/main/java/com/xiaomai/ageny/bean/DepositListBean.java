package com.xiaomai.ageny.bean;

import java.util.List;

public class DepositListBean {

    /**
     * code : 1
     * data : {"list":[{"applyTime":"2019-04-19 20:49:46","bank":"好嗨哟","creditCard":"1547895465125478","details":"","mobile":"12547896541","money":"100.00","orderId":"201904192049462919","realName":"华总","serviceMoney":"0.10","state":"0"},{"applyTime":"2019-04-19 20:30:54","bank":"好嗨哟","creditCard":"1547895465125478","details":"钱是假的","mobile":"12547896541","money":"20.00","orderId":"201904192030547069","realName":"华总","serviceMoney":"0.02","state":"-1"},{"applyTime":"2019-04-04 15:59:40","bank":"好嗨哟","creditCard":"1547895465125478","details":"","mobile":"12547896541","money":"20.00","orderId":"201904041559400027","realName":"华总","serviceMoney":"1.00","state":"-1"},{"applyTime":"2019-02-25 09:54:34","bank":"招商银行","creditCard":"4100620289923456","details":"","mobile":"18683958888","money":"5000.00","orderId":"201902250954348155","realName":"周琪帆","serviceMoney":"1.00","state":"1"},{"applyTime":"2019-02-18 16:39:35","bank":"招商银行","creditCard":"4100620289923456","details":"","mobile":"18683958888","money":"100.00","orderId":"201902181639351917","realName":"周琪帆","serviceMoney":"1.00","state":"-1"}],"page":"1","page_size":"15","text":"","total":"5"}
     * message : 个人中心提现记录获取成功
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
         * list : [{"applyTime":"2019-04-19 20:49:46","bank":"好嗨哟","creditCard":"1547895465125478","details":"","mobile":"12547896541","money":"100.00","orderId":"201904192049462919","realName":"华总","serviceMoney":"0.10","state":"0"},{"applyTime":"2019-04-19 20:30:54","bank":"好嗨哟","creditCard":"1547895465125478","details":"钱是假的","mobile":"12547896541","money":"20.00","orderId":"201904192030547069","realName":"华总","serviceMoney":"0.02","state":"-1"},{"applyTime":"2019-04-04 15:59:40","bank":"好嗨哟","creditCard":"1547895465125478","details":"","mobile":"12547896541","money":"20.00","orderId":"201904041559400027","realName":"华总","serviceMoney":"1.00","state":"-1"},{"applyTime":"2019-02-25 09:54:34","bank":"招商银行","creditCard":"4100620289923456","details":"","mobile":"18683958888","money":"5000.00","orderId":"201902250954348155","realName":"周琪帆","serviceMoney":"1.00","state":"1"},{"applyTime":"2019-02-18 16:39:35","bank":"招商银行","creditCard":"4100620289923456","details":"","mobile":"18683958888","money":"100.00","orderId":"201902181639351917","realName":"周琪帆","serviceMoney":"1.00","state":"-1"}]
         * page : 1
         * page_size : 15
         * text :
         * total : 5
         */

        private String page;
        private String page_size;
        private String text;
        private String total;
        private List<ListBean> list;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * applyTime : 2019-04-19 20:49:46
             * bank : 好嗨哟
             * creditCard : 1547895465125478
             * details :
             * mobile : 12547896541
             * money : 100.00
             * orderId : 201904192049462919
             * realName : 华总
             * serviceMoney : 0.10
             * state : 0
             */

            private String applyTime;
            private String bank;
            private String creditCard;
            private String details;
            private String mobile;
            private String money;
            private String orderId;
            private String realName;
            private String serviceMoney;
            private String state;

            public String getApplyTime() {
                return applyTime;
            }

            public void setApplyTime(String applyTime) {
                this.applyTime = applyTime;
            }

            public String getBank() {
                return bank;
            }

            public void setBank(String bank) {
                this.bank = bank;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getServiceMoney() {
                return serviceMoney;
            }

            public void setServiceMoney(String serviceMoney) {
                this.serviceMoney = serviceMoney;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }
        }
    }
}
