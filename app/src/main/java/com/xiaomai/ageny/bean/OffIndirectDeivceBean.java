package com.xiaomai.ageny.bean;

import java.util.List;

public class OffIndirectDeivceBean {

    /**
     * code : 1
     * data : [{"agentid":"","agentmobile":"","agentname":"","countlinxianbox":"13","list":[{"box":[{"boxaddress":"四川省成都市双流区西航港长江路一段8号1栋底楼","boxid":"JZCB061901000014","details":"1.50","lixiantime":"84","stock":"6"}],"mobile":"13882086933","realname":"虞丹"},{"box":[{"boxaddress":"锦江区百合花园(滨湖东路东)","boxid":"JZCB061901000042","details":"1.00","lixiantime":"121","stock":"6"},{"boxaddress":"锦江区百合花园(滨湖东路东)","boxid":"JZCB061901000054","details":"1.00","lixiantime":"216","stock":"6"},{"boxaddress":"锦江区百合花园(滨湖东路东)","boxid":"JZCB061901000058","details":"1.00","lixiantime":"241","stock":"6"}],"mobile":"13032866466","realname":"张哥"},{"box":[{"boxaddress":"四川省成都市锦江区幸福梅林滨湖路幸福联合一组301号","boxid":"JZCB061901000044","details":"1.00","lixiantime":"86","stock":"6"},{"boxaddress":"锦江区水香雅舍(三圣乡店)","boxid":"JZCB061901000053","details":"1.00","lixiantime":"86","stock":"6"},{"boxaddress":"锦江区水香雅舍(三圣乡店)","boxid":"JZCB061901000068","details":"1.00","lixiantime":"87","stock":"6"}],"mobile":"15828576954","realname":"王琴"},{"box":[{"boxaddress":"四川省成都市新都区物流大道华都九龙广场独一栋六楼","boxid":"JZCB061901000100","details":"1.00","lixiantime":"1068","stock":"6"},{"boxaddress":"青羊区东坡TT·尚品(瑞联路南)","boxid":"JZCB061901000131","details":"1.00","lixiantime":"1338","stock":"6"},{"boxaddress":"四川省成都市新都区物流大道华都九龙广场独一栋六楼","boxid":"JZCB061901000383","details":"1.00","lixiantime":"570","stock":"6"},{"boxaddress":"四川省成都市成华区万科路19号1幢3层附91号(凯德广场1号门对面)","boxid":"JZCB061901000647","details":"1.00","lixiantime":"236","stock":"6"},{"boxaddress":"四川省成都市郫都区合信路92号龙湖时代天街29栋4楼","boxid":"JZCB061901000653","details":"1.00","lixiantime":"1358","stock":"6"},{"boxaddress":"四川省成都市新都区物流大道华都九龙广场独一栋六楼","boxid":"JZCB061901000948","details":"1.00","lixiantime":"1067","stock":"6"}],"mobile":"18780276288","realname":"袁先生"}]}]
     * message : 4.7离线的非直属直属设备成功
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
         * agentid :
         * agentmobile :
         * agentname :
         * countlinxianbox : 13
         * list : [{"box":[{"boxaddress":"四川省成都市双流区西航港长江路一段8号1栋底楼","boxid":"JZCB061901000014","details":"1.50","lixiantime":"84","stock":"6"}],"mobile":"13882086933","realname":"虞丹"},{"box":[{"boxaddress":"锦江区百合花园(滨湖东路东)","boxid":"JZCB061901000042","details":"1.00","lixiantime":"121","stock":"6"},{"boxaddress":"锦江区百合花园(滨湖东路东)","boxid":"JZCB061901000054","details":"1.00","lixiantime":"216","stock":"6"},{"boxaddress":"锦江区百合花园(滨湖东路东)","boxid":"JZCB061901000058","details":"1.00","lixiantime":"241","stock":"6"}],"mobile":"13032866466","realname":"张哥"},{"box":[{"boxaddress":"四川省成都市锦江区幸福梅林滨湖路幸福联合一组301号","boxid":"JZCB061901000044","details":"1.00","lixiantime":"86","stock":"6"},{"boxaddress":"锦江区水香雅舍(三圣乡店)","boxid":"JZCB061901000053","details":"1.00","lixiantime":"86","stock":"6"},{"boxaddress":"锦江区水香雅舍(三圣乡店)","boxid":"JZCB061901000068","details":"1.00","lixiantime":"87","stock":"6"}],"mobile":"15828576954","realname":"王琴"},{"box":[{"boxaddress":"四川省成都市新都区物流大道华都九龙广场独一栋六楼","boxid":"JZCB061901000100","details":"1.00","lixiantime":"1068","stock":"6"},{"boxaddress":"青羊区东坡TT·尚品(瑞联路南)","boxid":"JZCB061901000131","details":"1.00","lixiantime":"1338","stock":"6"},{"boxaddress":"四川省成都市新都区物流大道华都九龙广场独一栋六楼","boxid":"JZCB061901000383","details":"1.00","lixiantime":"570","stock":"6"},{"boxaddress":"四川省成都市成华区万科路19号1幢3层附91号(凯德广场1号门对面)","boxid":"JZCB061901000647","details":"1.00","lixiantime":"236","stock":"6"},{"boxaddress":"四川省成都市郫都区合信路92号龙湖时代天街29栋4楼","boxid":"JZCB061901000653","details":"1.00","lixiantime":"1358","stock":"6"},{"boxaddress":"四川省成都市新都区物流大道华都九龙广场独一栋六楼","boxid":"JZCB061901000948","details":"1.00","lixiantime":"1067","stock":"6"}],"mobile":"18780276288","realname":"袁先生"}]
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
             * box : [{"boxaddress":"四川省成都市双流区西航港长江路一段8号1栋底楼","boxid":"JZCB061901000014","details":"1.50","lixiantime":"84","stock":"6"}]
             * mobile : 13882086933
             * realname : 虞丹
             */

            private String mobile;
            private String realname;
            private List<BoxBean> box;

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
                 * boxaddress : 四川省成都市双流区西航港长江路一段8号1栋底楼
                 * boxid : JZCB061901000014
                 * details : 1.50
                 * lixiantime : 84
                 * stock : 6
                 */

                private String boxaddress;
                private String boxid;
                private String details;
                private String lixiantime;
                private String stock;

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
            }
        }
    }
}
