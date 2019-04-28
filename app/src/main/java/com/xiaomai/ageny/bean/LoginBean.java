package com.xiaomai.ageny.bean;

public class LoginBean {

    /**
     * code : 1
     * data : {"level":"2","reward":"94%","role":"1","weixinToken":"837bf938-7f3a-41ee-acaf-6b6ce6613915"}
     * message : app端登录成功
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
         * level : 2
         * reward : 94%
         * role : 1
         * weixinToken : 837bf938-7f3a-41ee-acaf-6b6ce6613915
         */

        private String level;
        private String reward;
        private String role;
        private String weixinToken;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getReward() {
            return reward;
        }

        public void setReward(String reward) {
            this.reward = reward;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getWeixinToken() {
            return weixinToken;
        }

        public void setWeixinToken(String weixinToken) {
            this.weixinToken = weixinToken;
        }
    }
}
