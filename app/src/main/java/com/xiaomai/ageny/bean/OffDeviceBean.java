package com.xiaomai.ageny.bean;

import java.util.List;

public class OffDeviceBean {

    /**
     * code : 1
     * data : [{"countlinxianbox":"11","linkTel":"","list":[{"boxid":"","details":"","linktel":"","sellerid":"113","sellername":"成都慈爱直属医院","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"114","sellername":"成都慈爱直属医院1楼接待大厅","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"116","sellername":"成都慈爱直属医院5楼护士站","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"118","sellername":"成都慈爱直属医院3楼护士站","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"120","sellername":"成都慈爱直属医院2楼护士站","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"121","sellername":"城视医院","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"122","sellername":"城视医院1楼住院部","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"132","sellername":"中唐华庭茶府","stock":"","updtime":""},{"boxid":"","details":"","linktel":"13348833353","sellerid":"1016","sellername":"成华区税务局","stock":"","updtime":""},{"boxid":"","details":"","linktel":"13880076060","sellerid":"1026","sellername":"丰涛火锅","stock":"","updtime":""},{"boxid":"","details":"","linktel":"13688423963","sellerid":"1191","sellername":"新南门车站","stock":"","updtime":""}],"sellerid":"","sellername":""}]
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
         * countlinxianbox : 11
         * linkTel :
         * list : [{"boxid":"","details":"","linktel":"","sellerid":"113","sellername":"成都慈爱直属医院","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"114","sellername":"成都慈爱直属医院1楼接待大厅","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"116","sellername":"成都慈爱直属医院5楼护士站","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"118","sellername":"成都慈爱直属医院3楼护士站","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"120","sellername":"成都慈爱直属医院2楼护士站","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"121","sellername":"城视医院","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"122","sellername":"城视医院1楼住院部","stock":"","updtime":""},{"boxid":"","details":"","linktel":"","sellerid":"132","sellername":"中唐华庭茶府","stock":"","updtime":""},{"boxid":"","details":"","linktel":"13348833353","sellerid":"1016","sellername":"成华区税务局","stock":"","updtime":""},{"boxid":"","details":"","linktel":"13880076060","sellerid":"1026","sellername":"丰涛火锅","stock":"","updtime":""},{"boxid":"","details":"","linktel":"13688423963","sellerid":"1191","sellername":"新南门车站","stock":"","updtime":""}]
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
             * boxid :
             * details :
             * linktel :
             * sellerid : 113
             * sellername : 成都慈爱直属医院
             * stock :
             * updtime :
             */

            private String boxid;
            private String details;
            private String linktel;
            private String sellerid;
            private String sellername;
            private String stock;
            private String updtime;

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
