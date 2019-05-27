package com.xiaomai.ageny.bean;

import java.util.List;

public class OffIndirectDeivceBean {

    /**
     * code : 1
     * data : {"list":[{"agentid":"","agentmobile":"","agentname":"","countlinxianbox":"1","list":[{"box":[{"boxaddress":"117.132.194.123","boxid":"1210410000000519","details":"1.00","lixiantime":"665","stock":"6","updtime":"2019-04-29 18:01:50.0"}],"level":"2","mobile":"18981906214","realname":"张兴凯"}]}],"page":1,"page_size":25,"total":"1"}
     * message : 4.7离线的非直属直属设备成功
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
         * list : [{"agentid":"","agentmobile":"","agentname":"","countlinxianbox":"1","list":[{"box":[{"boxaddress":"117.132.194.123","boxid":"1210410000000519","details":"1.00","lixiantime":"665","stock":"6","updtime":"2019-04-29 18:01:50.0"}],"level":"2","mobile":"18981906214","realname":"张兴凯"}]}]
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
             * agentid :
             * agentmobile :
             * agentname :
             * countlinxianbox : 1
             * list : [{"box":[{"boxaddress":"117.132.194.123","boxid":"1210410000000519","details":"1.00","lixiantime":"665","stock":"6","updtime":"2019-04-29 18:01:50.0"}],"level":"2","mobile":"18981906214","realname":"张兴凯"}]
             */

            private String agentid;
            private String agentmobile;
            private String agentname;
            private String countlinxianbox;
            private List<ListBean> list;

            public String getAgentid() {
                return agentid;
            }

            public void setAgentid(String agentid) {
                this.agentid = agentid;
            }

            public String getAgentmobile() {
                return agentmobile;
            }

            public void setAgentmobile(String agentmobile) {
                this.agentmobile = agentmobile;
            }

            public String getAgentname() {
                return agentname;
            }

            public void setAgentname(String agentname) {
                this.agentname = agentname;
            }

            public String getCountlinxianbox() {
                return countlinxianbox;
            }

            public void setCountlinxianbox(String countlinxianbox) {
                this.countlinxianbox = countlinxianbox;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * box : [{"boxaddress":"117.132.194.123","boxid":"1210410000000519","details":"1.00","lixiantime":"665","stock":"6","updtime":"2019-04-29 18:01:50.0"}]
                 * level : 2
                 * mobile : 18981906214
                 * realname : 张兴凯
                 */

                private String level;
                private String mobile;
                private String realname;
                private List<BoxBean> box;

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

                public String getRealname() {
                    return realname;
                }

                public void setRealname(String realname) {
                    this.realname = realname;
                }

                public List<BoxBean> getBox() {
                    return box;
                }

                public void setBox(List<BoxBean> box) {
                    this.box = box;
                }

                public static class BoxBean {
                    /**
                     * boxaddress : 117.132.194.123
                     * boxid : 1210410000000519
                     * details : 1.00
                     * lixiantime : 665
                     * stock : 6
                     * updtime : 2019-04-29 18:01:50.0
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
