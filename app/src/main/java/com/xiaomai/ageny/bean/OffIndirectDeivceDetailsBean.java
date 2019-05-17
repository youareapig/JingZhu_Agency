package com.xiaomai.ageny.bean;

import java.util.List;

public class OffIndirectDeivceDetailsBean {

    /**
     * code : 1
     * data : {"bushu":"已部署","fenpeitime":"2019-05-17 15:24:30","lingquren":"一代直商1","lingqurenmobile":"17032224444","list":[{"level":"1","name":"徐碧"},{"level":"2","name":"一代个人1"},{"level":"9","name":"一代直商名1"}],"zhiliutime":""}
     * message : 2.19设备管理--已分配设备--设备详情
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
         * bushu : 已部署
         * fenpeitime : 2019-05-17 15:24:30
         * lingquren : 一代直商1
         * lingqurenmobile : 17032224444
         * list : [{"level":"1","name":"徐碧"},{"level":"2","name":"一代个人1"},{"level":"9","name":"一代直商名1"}]
         * zhiliutime :
         */

        private String bushu;
        private String fenpeitime;
        private String lingquren;
        private String lingqurenmobile;
        private String zhiliutime;
        private List<ListBean> list;

        public String getBushu() {
            return bushu;
        }

        public void setBushu(String bushu) {
            this.bushu = bushu;
        }

        public String getFenpeitime() {
            return fenpeitime;
        }

        public void setFenpeitime(String fenpeitime) {
            this.fenpeitime = fenpeitime;
        }

        public String getLingquren() {
            return lingquren;
        }

        public void setLingquren(String lingquren) {
            this.lingquren = lingquren;
        }

        public String getLingqurenmobile() {
            return lingqurenmobile;
        }

        public void setLingqurenmobile(String lingqurenmobile) {
            this.lingqurenmobile = lingqurenmobile;
        }

        public String getZhiliutime() {
            return zhiliutime;
        }

        public void setZhiliutime(String zhiliutime) {
            this.zhiliutime = zhiliutime;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * level : 1
             * name : 徐碧
             */

            private String level;
            private String name;

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
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
