package com.xiaomai.ageny.bean;

import java.util.List;

public class OffDirectDeviceBean {

    /**
     * code : 1
     * data : [{"countlinxianbox":"7","linkTel":"","list":[{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000093","details":"2.00","lixiantime":"577","stock":"6","updtime":""}],"linktel":"","sellerid":"120","sellername":"成都慈爱直属医院2楼护士站"},{"box":[{"boxaddress":"小天竺园公寓东(小天北巷)","boxid":"JZCB061901000094","details":"1.50","lixiantime":"689","stock":"6","updtime":""}],"linktel":"","sellerid":"323","sellername":"路华茶房"},{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000668","details":"2.00","lixiantime":"561","stock":"6","updtime":""}],"linktel":"","sellerid":"118","sellername":"成都慈爱直属医院3楼护士站"},{"box":[{"boxaddress":"四川省成都市金牛区金仙桥路10号","boxid":"JZCB061901000828","details":"2.00","lixiantime":"602","stock":"6","updtime":""}],"linktel":"","sellerid":"121","sellername":"城视医院"},{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000966","details":"2.00","lixiantime":"651","stock":"6","updtime":""}],"linktel":"","sellerid":"114","sellername":"成都慈爱直属医院1楼接待大厅"},{"box":[{"boxaddress":"四川省成都市金牛区金仙桥路10号","boxid":"JZCB061901000976","details":"2.00","lixiantime":"609","stock":"6","updtime":""}],"linktel":"","sellerid":"122","sellername":"城视医院1楼住院部"},{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000992","details":"2.00","lixiantime":"566","stock":"6","updtime":""}],"linktel":"","sellerid":"116","sellername":"成都慈爱直属医院5楼护士站"}],"sellerid":"","sellername":""}]
     * message : 4.6离线的直属设备成功
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
         * countlinxianbox : 7
         * linkTel :
         * list : [{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000093","details":"2.00","lixiantime":"577","stock":"6","updtime":""}],"linktel":"","sellerid":"120","sellername":"成都慈爱直属医院2楼护士站"},{"box":[{"boxaddress":"小天竺园公寓东(小天北巷)","boxid":"JZCB061901000094","details":"1.50","lixiantime":"689","stock":"6","updtime":""}],"linktel":"","sellerid":"323","sellername":"路华茶房"},{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000668","details":"2.00","lixiantime":"561","stock":"6","updtime":""}],"linktel":"","sellerid":"118","sellername":"成都慈爱直属医院3楼护士站"},{"box":[{"boxaddress":"四川省成都市金牛区金仙桥路10号","boxid":"JZCB061901000828","details":"2.00","lixiantime":"602","stock":"6","updtime":""}],"linktel":"","sellerid":"121","sellername":"城视医院"},{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000966","details":"2.00","lixiantime":"651","stock":"6","updtime":""}],"linktel":"","sellerid":"114","sellername":"成都慈爱直属医院1楼接待大厅"},{"box":[{"boxaddress":"四川省成都市金牛区金仙桥路10号","boxid":"JZCB061901000976","details":"2.00","lixiantime":"609","stock":"6","updtime":""}],"linktel":"","sellerid":"122","sellername":"城视医院1楼住院部"},{"box":[{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000992","details":"2.00","lixiantime":"566","stock":"6","updtime":""}],"linktel":"","sellerid":"116","sellername":"成都慈爱直属医院5楼护士站"}]
         * sellerid :
         * sellername :
         */

        private String countlinxianbox;
        private String linkTel;
        private String sellerid;
        private String sellername;
        private List<ListBean> list;

        public String getCountlinxianbox() {
            return countlinxianbox;
        }

        public void setCountlinxianbox(String countlinxianbox) {
            this.countlinxianbox = countlinxianbox;
        }

        public String getLinkTel() {
            return linkTel;
        }

        public void setLinkTel(String linkTel) {
            this.linkTel = linkTel;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public String getSellername() {
            return sellername;
        }

        public void setSellername(String sellername) {
            this.sellername = sellername;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * box : [{"boxaddress":"四川省成都市武侯区洗面桥街17号","boxid":"JZCB061901000093","details":"2.00","lixiantime":"577","stock":"6","updtime":""}]
             * linktel :
             * sellerid : 120
             * sellername : 成都慈爱直属医院2楼护士站
             */

            private String linktel;
            private String sellerid;
            private String sellername;
            private List<BoxBean> box;

            public String getLinktel() {
                return linktel;
            }

            public void setLinktel(String linktel) {
                this.linktel = linktel;
            }

            public String getSellerid() {
                return sellerid;
            }

            public void setSellerid(String sellerid) {
                this.sellerid = sellerid;
            }

            public String getSellername() {
                return sellername;
            }

            public void setSellername(String sellername) {
                this.sellername = sellername;
            }

            public List<BoxBean> getBox() {
                return box;
            }

            public void setBox(List<BoxBean> box) {
                this.box = box;
            }

            public static class BoxBean {
                /**
                 * boxaddress : 四川省成都市武侯区洗面桥街17号
                 * boxid : JZCB061901000093
                 * details : 2.00
                 * lixiantime : 577
                 * stock : 6
                 * updtime :
                 */

                private String boxaddress;
                private String boxid;
                private String details;
                private String lixiantime;
                private String stock;
                private String updtime;

                public String getBoxaddress() {
                    return boxaddress;
                }

                public void setBoxaddress(String boxaddress) {
                    this.boxaddress = boxaddress;
                }

                public String getBoxid() {
                    return boxid;
                }

                public void setBoxid(String boxid) {
                    this.boxid = boxid;
                }

                public String getDetails() {
                    return details;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public String getLixiantime() {
                    return lixiantime;
                }

                public void setLixiantime(String lixiantime) {
                    this.lixiantime = lixiantime;
                }

                public String getStock() {
                    return stock;
                }

                public void setStock(String stock) {
                    this.stock = stock;
                }

                public String getUpdtime() {
                    return updtime;
                }

                public void setUpdtime(String updtime) {
                    this.updtime = updtime;
                }
            }
        }
    }
}
