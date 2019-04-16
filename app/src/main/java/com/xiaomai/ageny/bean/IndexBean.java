package com.xiaomai.ageny.bean;

public class IndexBean {

    /**
     * code : 1
     * data : {"bank":"农业银行","creditCard":"****   ****   ****   3275","day_earn":"0.00","freeze_money":"0.00","is_havecard":"1","liquidated":"0.00","mobile":"189****6214","month_earn":"1.68","noRentCount":"7","offLineCount":"0","onLineCount":"1","realName":"你蔡","rentCount":"0","subBank":"","total_earn":"3.78","unliquidated":"3.78","yestoday_earn":"0.00"}
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
        /**
         * bank : 农业银行
         * creditCard : ****   ****   ****   3275
         * day_earn : 0.00
         * freeze_money : 0.00
         * is_havecard : 1
         * liquidated : 0.00
         * mobile : 189****6214
         * month_earn : 1.68
         * noRentCount : 7
         * offLineCount : 0
         * onLineCount : 1
         * realName : 你蔡
         * rentCount : 0
         * subBank :
         * total_earn : 3.78
         * unliquidated : 3.78
         * yestoday_earn : 0.00
         */

        private String bank;
        private String creditCard;
        private String day_earn;
        private String freeze_money;
        private String is_havecard;
        private String liquidated;
        private String mobile;
        private String month_earn;
        private String noRentCount;
        private String offLineCount;
        private String onLineCount;
        private String realName;
        private String rentCount;
        private String subBank;
        private String total_earn;
        private String unliquidated;
        private String yestoday_earn;

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCreditCard() {
            return creditCard;
        }

        public void setCreditCard(String creditCard) {
            this.creditCard = creditCard;
        }

        public String getDay_earn() {
            return day_earn;
        }

        public void setDay_earn(String day_earn) {
            this.day_earn = day_earn;
        }

        public String getFreeze_money() {
            return freeze_money;
        }

        public void setFreeze_money(String freeze_money) {
            this.freeze_money = freeze_money;
        }

        public String getIs_havecard() {
            return is_havecard;
        }

        public void setIs_havecard(String is_havecard) {
            this.is_havecard = is_havecard;
        }

        public String getLiquidated() {
            return liquidated;
        }

        public void setLiquidated(String liquidated) {
            this.liquidated = liquidated;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMonth_earn() {
            return month_earn;
        }

        public void setMonth_earn(String month_earn) {
            this.month_earn = month_earn;
        }

        public String getNoRentCount() {
            return noRentCount;
        }

        public void setNoRentCount(String noRentCount) {
            this.noRentCount = noRentCount;
        }

        public String getOffLineCount() {
            return offLineCount;
        }

        public void setOffLineCount(String offLineCount) {
            this.offLineCount = offLineCount;
        }

        public String getOnLineCount() {
            return onLineCount;
        }

        public void setOnLineCount(String onLineCount) {
            this.onLineCount = onLineCount;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getRentCount() {
            return rentCount;
        }

        public void setRentCount(String rentCount) {
            this.rentCount = rentCount;
        }

        public String getSubBank() {
            return subBank;
        }

        public void setSubBank(String subBank) {
            this.subBank = subBank;
        }

        public String getTotal_earn() {
            return total_earn;
        }

        public void setTotal_earn(String total_earn) {
            this.total_earn = total_earn;
        }

        public String getUnliquidated() {
            return unliquidated;
        }

        public void setUnliquidated(String unliquidated) {
            this.unliquidated = unliquidated;
        }

        public String getYestoday_earn() {
            return yestoday_earn;
        }

        public void setYestoday_earn(String yestoday_earn) {
            this.yestoday_earn = yestoday_earn;
        }
    }
}
