package com.xiaomai.ageny.bean;

import java.util.List;

public class BillListBean {

    /**
     * code : 1
     * data : {"list":[{"agentEarn":"0.00","agentId":"7","billDate":"2019年03月01日-2019年03月31日","billMonth":"2019年03月","createTime":"2019-04-01 00:00:16","id":"118","sellerEarn":"2.10","totalEarn":"2.10","totalPrice":"7.00"}],"total_earn":"3.78","total_price":"9.00"}
     * message : 获取出账单成功！
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
         * list : [{"agentEarn":"0.00","agentId":"7","billDate":"2019年03月01日-2019年03月31日","billMonth":"2019年03月","createTime":"2019-04-01 00:00:16","id":"118","sellerEarn":"2.10","totalEarn":"2.10","totalPrice":"7.00"}]
         * total_earn : 3.78
         * total_price : 9.00
         */

        private String total_earn;
        private String total_price;
        private List<ListBean> list;

        public String getTotal_earn() {
            return total_earn;
        }

        public void setTotal_earn(String total_earn) {
            this.total_earn = total_earn;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * agentEarn : 0.00
             * agentId : 7
             * billDate : 2019年03月01日-2019年03月31日
             * billMonth : 2019年03月
             * createTime : 2019-04-01 00:00:16
             * id : 118
             * sellerEarn : 2.10
             * totalEarn : 2.10
             * totalPrice : 7.00
             */

            private String agentEarn;
            private String agentId;
            private String billDate;
            private String billMonth;
            private String createTime;
            private String id;
            private String sellerEarn;
            private String totalEarn;
            private String totalPrice;

            public String getAgentEarn() {
                return agentEarn;
            }

            public void setAgentEarn(String agentEarn) {
                this.agentEarn = agentEarn;
            }

            public String getAgentId() {
                return agentId;
            }

            public void setAgentId(String agentId) {
                this.agentId = agentId;
            }

            public String getBillDate() {
                return billDate;
            }

            public void setBillDate(String billDate) {
                this.billDate = billDate;
            }

            public String getBillMonth() {
                return billMonth;
            }

            public void setBillMonth(String billMonth) {
                this.billMonth = billMonth;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSellerEarn() {
                return sellerEarn;
            }

            public void setSellerEarn(String sellerEarn) {
                this.sellerEarn = sellerEarn;
            }

            public String getTotalEarn() {
                return totalEarn;
            }

            public void setTotalEarn(String totalEarn) {
                this.totalEarn = totalEarn;
            }

            public String getTotalPrice() {
                return totalPrice;
            }

            public void setTotalPrice(String totalPrice) {
                this.totalPrice = totalPrice;
            }
        }
    }
}
