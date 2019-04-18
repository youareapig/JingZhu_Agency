package com.xiaomai.ageny.bean;

import java.util.List;

public class MyOrderBean {

    /**
     * code : 1
     * data : {"countEarn":"0.00","countRentPrice":"0.00","list":[{"agentname":"周琪帆","countPrice":"","countearn":"25.00","earn":"0.00","leasetime":"00时00分03秒","level":"","mobile":"","orderid":"201904032023317848","realname":"","rentprice":"0.00","sellername":"丰涛火锅","updTime":"2019-04-03 20:23:36"},{"agentname":"周琪帆","countPrice":"","countearn":"25.00","earn":"0.00","leasetime":"00时00分11秒","level":"","mobile":"","orderid":"201904032034322587","realname":"","rentprice":"0.00","sellername":"丰涛火锅","updTime":"2019-04-03 20:34:44"}],"page":"1","pageSize":"2","total":"23"}
     * message : 5.10获取我的订单列表成功
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
         * countEarn : 0.00
         * countRentPrice : 0.00
         * list : [{"agentname":"周琪帆","countPrice":"","countearn":"25.00","earn":"0.00","leasetime":"00时00分03秒","level":"","mobile":"","orderid":"201904032023317848","realname":"","rentprice":"0.00","sellername":"丰涛火锅","updTime":"2019-04-03 20:23:36"},{"agentname":"周琪帆","countPrice":"","countearn":"25.00","earn":"0.00","leasetime":"00时00分11秒","level":"","mobile":"","orderid":"201904032034322587","realname":"","rentprice":"0.00","sellername":"丰涛火锅","updTime":"2019-04-03 20:34:44"}]
         * page : 1
         * pageSize : 2
         * total : 23
         */

        private String countEarn;
        private String countRentPrice;
        private String page;
        private String pageSize;
        private String total;
        private List<ListBean> list;

        public String getCountEarn() {
            return countEarn;
        }

        public void setCountEarn(String countEarn) {
            this.countEarn = countEarn;
        }

        public String getCountRentPrice() {
            return countRentPrice;
        }

        public void setCountRentPrice(String countRentPrice) {
            this.countRentPrice = countRentPrice;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
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
             * agentname : 周琪帆
             * countPrice :
             * countearn : 25.00
             * earn : 0.00
             * leasetime : 00时00分03秒
             * level :
             * mobile :
             * orderid : 201904032023317848
             * realname :
             * rentprice : 0.00
             * sellername : 丰涛火锅
             * updTime : 2019-04-03 20:23:36
             */

            private String agentname;
            private String countPrice;
            private String countearn;
            private String earn;
            private String leasetime;
            private String level;
            private String mobile;
            private String orderid;
            private String realname;
            private String rentprice;
            private String sellername;
            private String updTime;

            public String getAgentname() {
                return agentname;
            }

            public void setAgentname(String agentname) {
                this.agentname = agentname;
            }

            public String getCountPrice() {
                return countPrice;
            }

            public void setCountPrice(String countPrice) {
                this.countPrice = countPrice;
            }

            public String getCountearn() {
                return countearn;
            }

            public void setCountearn(String countearn) {
                this.countearn = countearn;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
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

            public String getRentprice() {
                return rentprice;
            }

            public void setRentprice(String rentprice) {
                this.rentprice = rentprice;
            }

            public String getSellername() {
                return sellername;
            }

            public void setSellername(String sellername) {
                this.sellername = sellername;
            }

            public String getUpdTime() {
                return updTime;
            }

            public void setUpdTime(String updTime) {
                this.updTime = updTime;
            }
        }
    }
}
