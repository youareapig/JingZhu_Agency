package com.xiaomai.ageny.bean;

public class PopDeviceBean {

    /**
     * code : 1
     * data : {"result":1,"slot":3,"terminalId":"5357668659890226309"}
     * message : 成功强制弹出
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
         * result : 1
         * slot : 3
         * terminalId : 5357668659890226309
         */

        private int result;
        private int slot;
        private String terminalId;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getSlot() {
            return slot;
        }

        public void setSlot(int slot) {
            this.slot = slot;
        }

        public String getTerminalId() {
            return terminalId;
        }

        public void setTerminalId(String terminalId) {
            this.terminalId = terminalId;
        }
    }
}
