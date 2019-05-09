package com.xiaomai.ageny.bean;

import java.util.List;

public class ConfigBean {

    /**
     * code : 1
     * data : {"countunread":"0","price":["1.00","1.50","2.00"]}
     * message : 2.30系统设置
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
         * countunread : 0
         * price : ["1.00","1.50","2.00"]
         */

        private String countunread;
        private List<String> price;

        public String getCountunread() {
            return countunread;
        }

        public void setCountunread(String countunread) {
            this.countunread = countunread;
        }

        public List<String> getPrice() {
            return price;
        }

        public void setPrice(List<String> price) {
            this.price = price;
        }
    }
}
