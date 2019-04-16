package com.xiaomai.ageny.bean;

import java.util.List;

public class FreezeBean {

    /**
     * code : 1
     * data : {"count":"1","filler_deviceid":"","filler_relation":"","filler_state":"1","freeze_money":"980.00","list":[{"deviceid":"JZCB061901000288","freezeMoney":"980.00","installMan":"张兴凯","isFreeze":"1","nofreezeMoney":"980.00","relation":"1","remitTime":"2019-03-28 16:01:35","sellerLinkman":"","sellerName":"优博国际","unfreezeMoney":"0.00","unfreezeTime":""}],"page":"1","page_size":"25","unfreeze_money":"980.00"}
     * message :
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
         * count : 1
         * filler_deviceid :
         * filler_relation :
         * filler_state : 1
         * freeze_money : 980.00
         * list : [{"deviceid":"JZCB061901000288","freezeMoney":"980.00","installMan":"张兴凯","isFreeze":"1","nofreezeMoney":"980.00","relation":"1","remitTime":"2019-03-28 16:01:35","sellerLinkman":"","sellerName":"优博国际","unfreezeMoney":"0.00","unfreezeTime":""}]
         * page : 1
         * page_size : 25
         * unfreeze_money : 980.00
         */

        private String count;
        private String filler_deviceid;
        private String filler_relation;
        private String filler_state;
        private String freeze_money;
        private String page;
        private String page_size;
        private String unfreeze_money;
        private List<ListBean> list;

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getFiller_deviceid() {
            return filler_deviceid;
        }

        public void setFiller_deviceid(String filler_deviceid) {
            this.filler_deviceid = filler_deviceid;
        }

        public String getFiller_relation() {
            return filler_relation;
        }

        public void setFiller_relation(String filler_relation) {
            this.filler_relation = filler_relation;
        }

        public String getFiller_state() {
            return filler_state;
        }

        public void setFiller_state(String filler_state) {
            this.filler_state = filler_state;
        }

        public String getFreeze_money() {
            return freeze_money;
        }

        public void setFreeze_money(String freeze_money) {
            this.freeze_money = freeze_money;
        }

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

        public String getUnfreeze_money() {
            return unfreeze_money;
        }

        public void setUnfreeze_money(String unfreeze_money) {
            this.unfreeze_money = unfreeze_money;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * deviceid : JZCB061901000288
             * freezeMoney : 980.00
             * installMan : 张兴凯
             * isFreeze : 1
             * nofreezeMoney : 980.00
             * relation : 1
             * remitTime : 2019-03-28 16:01:35
             * sellerLinkman :
             * sellerName : 优博国际
             * unfreezeMoney : 0.00
             * unfreezeTime :
             */

            private String deviceid;
            private String freezeMoney;
            private String installMan;
            private String isFreeze;
            private String nofreezeMoney;
            private String relation;
            private String remitTime;
            private String sellerLinkman;
            private String sellerName;
            private String unfreezeMoney;
            private String unfreezeTime;

            public String getDeviceid() {
                return deviceid;
            }

            public void setDeviceid(String deviceid) {
                this.deviceid = deviceid;
            }

            public String getFreezeMoney() {
                return freezeMoney;
            }

            public void setFreezeMoney(String freezeMoney) {
                this.freezeMoney = freezeMoney;
            }

            public String getInstallMan() {
                return installMan;
            }

            public void setInstallMan(String installMan) {
                this.installMan = installMan;
            }

            public String getIsFreeze() {
                return isFreeze;
            }

            public void setIsFreeze(String isFreeze) {
                this.isFreeze = isFreeze;
            }

            public String getNofreezeMoney() {
                return nofreezeMoney;
            }

            public void setNofreezeMoney(String nofreezeMoney) {
                this.nofreezeMoney = nofreezeMoney;
            }

            public String getRelation() {
                return relation;
            }

            public void setRelation(String relation) {
                this.relation = relation;
            }

            public String getRemitTime() {
                return remitTime;
            }

            public void setRemitTime(String remitTime) {
                this.remitTime = remitTime;
            }

            public String getSellerLinkman() {
                return sellerLinkman;
            }

            public void setSellerLinkman(String sellerLinkman) {
                this.sellerLinkman = sellerLinkman;
            }

            public String getSellerName() {
                return sellerName;
            }

            public void setSellerName(String sellerName) {
                this.sellerName = sellerName;
            }

            public String getUnfreezeMoney() {
                return unfreezeMoney;
            }

            public void setUnfreezeMoney(String unfreezeMoney) {
                this.unfreezeMoney = unfreezeMoney;
            }

            public String getUnfreezeTime() {
                return unfreezeTime;
            }

            public void setUnfreezeTime(String unfreezeTime) {
                this.unfreezeTime = unfreezeTime;
            }
        }
    }
}
