package com.xiaomai.ageny.bean;

public class UserInfoBean {

    /**
     * code : 1
     * data : {"agent_number":"61000007","id":"7","level":"2","level_name":"一级代理","mobile":"18981906214","money":"0.00","parent_id":"5","parent_name":"吴凯","realname":"张兴凯","reward":"94%"}
     * message : 获取代理个人信息成功
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
         * agent_number : 61000007
         * id : 7
         * level : 2
         * level_name : 一级代理
         * mobile : 18981906214
         * money : 0.00
         * parent_id : 5
         * parent_name : 吴凯
         * realname : 张兴凯
         * reward : 94%
         */

        private String agent_number;
        private String id;
        private String level;
        private String level_name;
        private String mobile;
        private String money;
        private String parent_id;
        private String parent_name;
        private String realname;
        private String reward;

        public String getAgent_number() {
            return agent_number;
        }

        public void setAgent_number(String agent_number) {
            this.agent_number = agent_number;
        }

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

        public String getLevel_name() {
            return level_name;
        }

        public void setLevel_name(String level_name) {
            this.level_name = level_name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getParent_name() {
            return parent_name;
        }

        public void setParent_name(String parent_name) {
            this.parent_name = parent_name;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getReward() {
            return reward;
        }

        public void setReward(String reward) {
            this.reward = reward;
        }
    }
}
