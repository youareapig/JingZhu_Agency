package com.xiaomai.ageny.bean;

import java.util.List;

public class DeviceEarnListBean {

    /**
     * code : 1
     * data : {"list":[{"box":[{"boxaddress":"","boxid":"JZCB061901000020","details":"","lixiantime":"90","stock":"","updtime":""}],"linktel":"17364723819","lixiantime":"90","sellerid":"1947","sellername":"哆唻客"},{"box":[{"boxaddress":"","boxid":"JZCB061901000164","details":"","lixiantime":"143","stock":"","updtime":""}],"linktel":"18180514939","lixiantime":"143","sellerid":"3013","sellername":"金鑫网咖"},{"box":[{"boxaddress":"","boxid":"JZCB061901000335","details":"","lixiantime":"236","stock":"","updtime":""}],"linktel":"13410352259","lixiantime":"236","sellerid":"1603","sellername":"幸运串"},{"box":[{"boxaddress":"","boxid":"JZCB061901000383","details":"","lixiantime":"94","stock":"","updtime":""}],"linktel":"15982349733","lixiantime":"94","sellerid":"3051","sellername":"大山土鸡"},{"box":[{"boxaddress":"","boxid":"JZCB061901000420","details":"","lixiantime":"90","stock":"","updtime":""}],"linktel":"17711077586","lixiantime":"90","sellerid":"3081","sellername":"由顾酒店"},{"box":[{"boxaddress":"","boxid":"JZCB061901000448","details":"","lixiantime":"88","stock":"","updtime":""}],"linktel":"13708079601","lixiantime":"88","sellerid":"3072","sellername":"听吞鲜老馆子"},{"box":[{"boxaddress":"","boxid":"JZCB061901000537","details":"","lixiantime":"91","stock":"","updtime":""}],"linktel":"17628282813","lixiantime":"91","sellerid":"845","sellername":"MK马克凯文英伦面包坊"},{"box":[{"boxaddress":"","boxid":"JZCB061901000547","details":"","lixiantime":"208","stock":"","updtime":""}],"linktel":"15881050335","lixiantime":"208","sellerid":"2767","sellername":"钢管厂串串香"},{"box":[{"boxaddress":"","boxid":"JZCB061901000615","details":"","lixiantime":"91","stock":"","updtime":""}],"linktel":"13618025818","lixiantime":"91","sellerid":"1413","sellername":"云红招待所"},{"box":[{"boxaddress":"","boxid":"JZCB061901000635","details":"","lixiantime":"133","stock":"","updtime":""}],"linktel":"13688039228","lixiantime":"133","sellerid":"1404","sellername":"皇城一號时尚KTV"}],"page":1,"page_size":10,"total":"178"}
     * message : 4.10收益任务获取成功
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
         * list : [{"box":[{"boxaddress":"","boxid":"JZCB061901000020","details":"","lixiantime":"90","stock":"","updtime":""}],"linktel":"17364723819","lixiantime":"90","sellerid":"1947","sellername":"哆唻客"},{"box":[{"boxaddress":"","boxid":"JZCB061901000164","details":"","lixiantime":"143","stock":"","updtime":""}],"linktel":"18180514939","lixiantime":"143","sellerid":"3013","sellername":"金鑫网咖"},{"box":[{"boxaddress":"","boxid":"JZCB061901000335","details":"","lixiantime":"236","stock":"","updtime":""}],"linktel":"13410352259","lixiantime":"236","sellerid":"1603","sellername":"幸运串"},{"box":[{"boxaddress":"","boxid":"JZCB061901000383","details":"","lixiantime":"94","stock":"","updtime":""}],"linktel":"15982349733","lixiantime":"94","sellerid":"3051","sellername":"大山土鸡"},{"box":[{"boxaddress":"","boxid":"JZCB061901000420","details":"","lixiantime":"90","stock":"","updtime":""}],"linktel":"17711077586","lixiantime":"90","sellerid":"3081","sellername":"由顾酒店"},{"box":[{"boxaddress":"","boxid":"JZCB061901000448","details":"","lixiantime":"88","stock":"","updtime":""}],"linktel":"13708079601","lixiantime":"88","sellerid":"3072","sellername":"听吞鲜老馆子"},{"box":[{"boxaddress":"","boxid":"JZCB061901000537","details":"","lixiantime":"91","stock":"","updtime":""}],"linktel":"17628282813","lixiantime":"91","sellerid":"845","sellername":"MK马克凯文英伦面包坊"},{"box":[{"boxaddress":"","boxid":"JZCB061901000547","details":"","lixiantime":"208","stock":"","updtime":""}],"linktel":"15881050335","lixiantime":"208","sellerid":"2767","sellername":"钢管厂串串香"},{"box":[{"boxaddress":"","boxid":"JZCB061901000615","details":"","lixiantime":"91","stock":"","updtime":""}],"linktel":"13618025818","lixiantime":"91","sellerid":"1413","sellername":"云红招待所"},{"box":[{"boxaddress":"","boxid":"JZCB061901000635","details":"","lixiantime":"133","stock":"","updtime":""}],"linktel":"13688039228","lixiantime":"133","sellerid":"1404","sellername":"皇城一號时尚KTV"}]
         * page : 1
         * page_size : 10
         * total : 178
         */

        private int page;
        private int page_size;
        private String total;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPage_size() {
            return page_size;
        }

        public void setPage_size(int page_size) {
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
             * box : [{"boxaddress":"","boxid":"JZCB061901000020","details":"","lixiantime":"90","stock":"","updtime":""}]
             * linktel : 17364723819
             * lixiantime : 90
             * sellerid : 1947
             * sellername : 哆唻客
             */

            private String linktel;
            private String lixiantime;
            private String sellerid;
            private String sellername;
            private List<BoxBean> box;

            public String getLinktel() {
                return linktel;
            }

            public void setLinktel(String linktel) {
                this.linktel = linktel;
            }

            public String getLixiantime() {
                return lixiantime;
            }

            public void setLixiantime(String lixiantime) {
                this.lixiantime = lixiantime;
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
                 * boxaddress :
                 * boxid : JZCB061901000020
                 * details :
                 * lixiantime : 90
                 * stock :
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
