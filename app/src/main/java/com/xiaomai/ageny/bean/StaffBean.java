package com.xiaomai.ageny.bean;

import java.util.List;

public class StaffBean {

    /**
     * code : 1
     * data : {"list":[{"id":"61000038","lastLoginTime":"2019-03-12 10:51:28","mobile":"15478945612","name":"黄小月"},{"id":"61000040","lastLoginTime":"2019-03-12 14:13:05","mobile":"15456545125","name":"华总"}]}
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 61000038
             * lastLoginTime : 2019-03-12 10:51:28
             * mobile : 15478945612
             * name : 黄小月
             */

            private String id;
            private String lastLoginTime;
            private String mobile;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
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
