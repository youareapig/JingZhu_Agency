package com.xiaomai.ageny.bean;

import java.util.List;

public class FreezeDetailsBean {

    /**
     * code : 1
     * data : {"list":[{"id":"1","level":"1","name":"周琪帆","type":"1","type_name":"代理"}]}
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
             * id : 1
             * level : 1
             * name : 周琪帆
             * type : 1
             * type_name : 代理
             */

            private String id;
            private String level;
            private String name;
            private String type;
            private String type_name;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }
        }
    }
}
