package com.xiaomai.ageny.bean;

import java.util.List;

public class ContactListBean {

    /**
     * code : 1
     * data : {"list":[{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000113","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000114","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院1楼接待大厅"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000116","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院5楼护士站"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000118","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院3楼护士站"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000120","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院2楼护士站"},{"address":"四川省成都市金牛区金仙桥路10号","boxcount":"0","count":"0","id":"61000121","linkman":"","linktel":"","money":"0.00","name":"城视医院"},{"address":"四川省成都市金牛区金仙桥路10号","boxcount":"0","count":"1","id":"61000122","linkman":"","linktel":"","money":"0.00","name":"城视医院1楼住院部"},{"address":"四川省成都市青羊区金泽路8号附201号(近茅庐)","boxcount":"0","count":"0","id":"61000132","linkman":"","linktel":"","money":"0.00","name":"中唐华庭茶府"},{"address":"成华区双林路50号","boxcount":"0","count":"0","id":"61001016","linkman":"赵所","linktel":"13348833353","money":"14.00","name":"成华区税务局"},{"address":"清水河公园后门","boxcount":"0","count":"0","id":"61001026","linkman":"张姐","linktel":"13880076060","money":"25.00","name":"丰涛火锅"},{"address":"新南门","boxcount":"0","count":"0","id":"61001191","linkman":"卢老师","linktel":"13688423963","money":"0.00","name":"新南门车站"}],"page":"1","page_size":"25","total":11}
     * message : 获取商户列表成功
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
         * list : [{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000113","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000114","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院1楼接待大厅"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000116","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院5楼护士站"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000118","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院3楼护士站"},{"address":"四川省成都市武侯区洗面桥街17号","boxcount":"0","count":"0","id":"61000120","linkman":"","linktel":"","money":"0.00","name":"成都慈爱直属医院2楼护士站"},{"address":"四川省成都市金牛区金仙桥路10号","boxcount":"0","count":"0","id":"61000121","linkman":"","linktel":"","money":"0.00","name":"城视医院"},{"address":"四川省成都市金牛区金仙桥路10号","boxcount":"0","count":"1","id":"61000122","linkman":"","linktel":"","money":"0.00","name":"城视医院1楼住院部"},{"address":"四川省成都市青羊区金泽路8号附201号(近茅庐)","boxcount":"0","count":"0","id":"61000132","linkman":"","linktel":"","money":"0.00","name":"中唐华庭茶府"},{"address":"成华区双林路50号","boxcount":"0","count":"0","id":"61001016","linkman":"赵所","linktel":"13348833353","money":"14.00","name":"成华区税务局"},{"address":"清水河公园后门","boxcount":"0","count":"0","id":"61001026","linkman":"张姐","linktel":"13880076060","money":"25.00","name":"丰涛火锅"},{"address":"新南门","boxcount":"0","count":"0","id":"61001191","linkman":"卢老师","linktel":"13688423963","money":"0.00","name":"新南门车站"}]
         * page : 1
         * page_size : 25
         * total : 11
         */

        private String page;
        private String page_size;
        private int total;
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

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
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
             * address : 四川省成都市武侯区洗面桥街17号
             * boxcount : 0
             * count : 0
             * id : 61000113
             * linkman :
             * linktel :
             * money : 0.00
             * name : 成都慈爱直属医院
             */

            private String address;
            private String boxcount;
            private String count;
            private String id;
            private String linkman;
            private String linktel;
            private String money;
            private String name;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

            public String getLinkman() {
                return linkman;
            }

            public void setLinkman(String linkman) {
                this.linkman = linkman;
            }

            public String getLinktel() {
                return linktel;
            }

            public void setLinktel(String linktel) {
                this.linktel = linktel;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
