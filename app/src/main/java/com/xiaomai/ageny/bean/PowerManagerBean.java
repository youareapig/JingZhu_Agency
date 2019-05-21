package com.xiaomai.ageny.bean;

public class PowerManagerBean {

    /**
     * code : 1
     * data : {"countBox":"3","fenpeiBox":"3","weifenpeiBox":"0"}
     * message : 7.1接口访问成功
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
         * countBox : 3
         * fenpeiBox : 3
         * weifenpeiBox : 0
         */

        private String countBox;
        private String fenpeiBox;
        private String weifenpeiBox;

        public String getCountBox() {
            return countBox;
        }

        public void setCountBox(String countBox) {
            this.countBox = countBox;
        }

        public String getFenpeiBox() {
            return fenpeiBox;
        }

        public void setFenpeiBox(String fenpeiBox) {
            this.fenpeiBox = fenpeiBox;
        }

        public String getWeifenpeiBox() {
            return weifenpeiBox;
        }

        public void setWeifenpeiBox(String weifenpeiBox) {
            this.weifenpeiBox = weifenpeiBox;
        }
    }
}
