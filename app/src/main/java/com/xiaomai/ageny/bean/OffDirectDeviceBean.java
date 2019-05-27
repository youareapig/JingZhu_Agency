package com.xiaomai.ageny.bean;

import java.util.List;

public class OffDirectDeviceBean {

    /**
     * code : 1
     * data : {"list":[{"countlinxianbox":"1","linkTel":"","list":[{"box":[{"boxaddress":"117.132.198.77","boxid":"CS1B061901000001","details":"1.00","lixiantime":"45","stock":"6","updtime":""}],"linktel":"13608083652","sellerid":"2688","sellername":"总直商名1"}],"sellerid":"","sellername":""}],"page":1,"page_size":25,"total":"1"}
     * message : 4.6离线的直属设备成功
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
         * list : [{"countlinxianbox":"1","linkTel":"","list":[{"box":[{"boxaddress":"117.132.198.77","boxid":"CS1B061901000001","details":"1.00","lixiantime":"45","stock":"6","updtime":""}],"linktel":"13608083652","sellerid":"2688","sellername":"总直商名1"}],"sellerid":"","sellername":""}]
         * page : 1
         * page_size : 25
         * total : 1
         */

        private int page;
        private int page_size;
        private String total;
        private List<ListBeanX> list;

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

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX {
            /**
             * countlinxianbox : 1
             * linkTel :
             * list : [{"box":[{"boxaddress":"117.132.198.77","boxid":"CS1B061901000001","details":"1.00","lixiantime":"45","stock":"6","updtime":""}],"linktel":"13608083652","sellerid":"2688","sellername":"总直商名1"}]
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
                 * box : [{"boxaddress":"117.132.198.77","boxid":"CS1B061901000001","details":"1.00","lixiantime":"45","stock":"6","updtime":""}]
                 * linktel : 13608083652
                 * sellerid : 2688
                 * sellername : 总直商名1
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
                     * boxaddress : 117.132.198.77
                     * boxid : CS1B061901000001
                     * details : 1.00
                     * lixiantime : 45
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
}
