package com.xiaomai.ageny.bean;

import java.util.List;

public class DailiListBean {


    /**
     * code : 1
     * data : {"list":[{"area":"现代医院","boxcount":"0","count":"6","id":"61000016","level":"2","mobile":"18782420845","money":"5245.20","parentRealname":"","parentid":"","realname":"现代医院","reward":"40%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"1","id":"61000025","level":"2","mobile":"13183892888","money":"1998.00","parentRealname":"","parentid":"","realname":"祝哥","reward":"40%","zaixianbox":""},{"area":"金牛区","boxcount":"0","count":"7","id":"61000008","level":"2","mobile":"13558885016","money":"1800.40","parentRealname":"","parentid":"","realname":"任富","reward":"30%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000014","level":"2","mobile":"18284169111","money":"847.00","parentRealname":"","parentid":"","realname":"周雷","reward":"50%","zaixianbox":""},{"area":"四川省","boxcount":"3","count":"5","id":"61000013","level":"2","mobile":"13882058777","money":"571.90","parentRealname":"","parentid":"","realname":"陈琳","reward":"30%","zaixianbox":""},{"area":"成都","boxcount":"1","count":"1","id":"61000004","level":"2","mobile":"17882261001","money":"243.60","parentRealname":"","parentid":"","realname":"黄从高","reward":"30%","zaixianbox":""},{"area":"四川郫都区","boxcount":"3","count":"0","id":"61000195","level":"2","mobile":"18980008519","money":"227.75","parentRealname":"","parentid":"","realname":"潘哥","reward":"50%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"1","id":"61000040","level":"2","mobile":"13880268847","money":"221.50","parentRealname":"","parentid":"","realname":"罗家小院茶楼","reward":"50%","zaixianbox":""},{"area":"温江","boxcount":"0","count":"0","id":"61000460","level":"2","mobile":"13880240933","money":"55.30","parentRealname":"","parentid":"","realname":"易小姐","reward":"30%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000052","level":"2","mobile":"18108093888","money":"40.00","parentRealname":"","parentid":"","realname":"万晴","reward":"50%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000039","level":"2","mobile":"15308049825","money":"39.60","parentRealname":"","parentid":"","realname":"罗家小院黄经理","reward":"40%","zaixianbox":""},{"area":"双流","boxcount":"0","count":"1","id":"61000226","level":"2","mobile":"13881781697","money":"32.40","parentRealname":"","parentid":"","realname":"段姐","reward":"40%","zaixianbox":""},{"area":"成华区","boxcount":"0","count":"0","id":"61000737","level":"2","mobile":"13348833353","money":"18.00","parentRealname":"","parentid":"","realname":"成华区税务局","reward":"0%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000622","level":"2","mobile":"13880076060","money":"0.00","parentRealname":"","parentid":"","realname":"张姐","reward":"50%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000049","level":"2","mobile":"18982208123","money":"0.00","parentRealname":"","parentid":"","realname":"姚佳瑞","reward":"50%","zaixianbox":""}],"page":"","page_size":"","total":"15"}
     * message : 获取直属代理商列表成功
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
         * list : [{"area":"现代医院","boxcount":"0","count":"6","id":"61000016","level":"2","mobile":"18782420845","money":"5245.20","parentRealname":"","parentid":"","realname":"现代医院","reward":"40%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"1","id":"61000025","level":"2","mobile":"13183892888","money":"1998.00","parentRealname":"","parentid":"","realname":"祝哥","reward":"40%","zaixianbox":""},{"area":"金牛区","boxcount":"0","count":"7","id":"61000008","level":"2","mobile":"13558885016","money":"1800.40","parentRealname":"","parentid":"","realname":"任富","reward":"30%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000014","level":"2","mobile":"18284169111","money":"847.00","parentRealname":"","parentid":"","realname":"周雷","reward":"50%","zaixianbox":""},{"area":"四川省","boxcount":"3","count":"5","id":"61000013","level":"2","mobile":"13882058777","money":"571.90","parentRealname":"","parentid":"","realname":"陈琳","reward":"30%","zaixianbox":""},{"area":"成都","boxcount":"1","count":"1","id":"61000004","level":"2","mobile":"17882261001","money":"243.60","parentRealname":"","parentid":"","realname":"黄从高","reward":"30%","zaixianbox":""},{"area":"四川郫都区","boxcount":"3","count":"0","id":"61000195","level":"2","mobile":"18980008519","money":"227.75","parentRealname":"","parentid":"","realname":"潘哥","reward":"50%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"1","id":"61000040","level":"2","mobile":"13880268847","money":"221.50","parentRealname":"","parentid":"","realname":"罗家小院茶楼","reward":"50%","zaixianbox":""},{"area":"温江","boxcount":"0","count":"0","id":"61000460","level":"2","mobile":"13880240933","money":"55.30","parentRealname":"","parentid":"","realname":"易小姐","reward":"30%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000052","level":"2","mobile":"18108093888","money":"40.00","parentRealname":"","parentid":"","realname":"万晴","reward":"50%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000039","level":"2","mobile":"15308049825","money":"39.60","parentRealname":"","parentid":"","realname":"罗家小院黄经理","reward":"40%","zaixianbox":""},{"area":"双流","boxcount":"0","count":"1","id":"61000226","level":"2","mobile":"13881781697","money":"32.40","parentRealname":"","parentid":"","realname":"段姐","reward":"40%","zaixianbox":""},{"area":"成华区","boxcount":"0","count":"0","id":"61000737","level":"2","mobile":"13348833353","money":"18.00","parentRealname":"","parentid":"","realname":"成华区税务局","reward":"0%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000622","level":"2","mobile":"13880076060","money":"0.00","parentRealname":"","parentid":"","realname":"张姐","reward":"50%","zaixianbox":""},{"area":"四川","boxcount":"0","count":"0","id":"61000049","level":"2","mobile":"18982208123","money":"0.00","parentRealname":"","parentid":"","realname":"姚佳瑞","reward":"50%","zaixianbox":""}]
         * page :
         * page_size :
         * total : 15
         */

        private String page;
        private String page_size;
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
             * area : 现代医院
             * boxcount : 0
             * count : 6
             * id : 61000016
             * level : 2
             * mobile : 18782420845
             * money : 5245.20
             * parentRealname :
             * parentid :
             * realname : 现代医院
             * reward : 40%
             * zaixianbox :
             */

            private String area;
            private String boxcount;
            private String count;
            private String id;
            private String level;
            private String mobile;
            private String money;
            private String parentRealname;
            private String parentid;
            private String realname;
            private String reward;
            private String zaixianbox;

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getBoxcount() {
                return boxcount;
            }

            public void setBoxcount(String boxcount) {
                this.boxcount = boxcount;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getParentRealname() {
                return parentRealname;
            }

            public void setParentRealname(String parentRealname) {
                this.parentRealname = parentRealname;
            }

            public String getParentid() {
                return parentid;
            }

            public void setParentid(String parentid) {
                this.parentid = parentid;
            }

            public String getRealname() {
                return realname;
            }

            public void setRealname(String realname) {
                this.realname = realname;
            }

            public String getReward() {
                return reward;
            }

            public void setReward(String reward) {
                this.reward = reward;
            }

            public String getZaixianbox() {
                return zaixianbox;
            }

            public void setZaixianbox(String zaixianbox) {
                this.zaixianbox = zaixianbox;
            }
        }
    }
}
