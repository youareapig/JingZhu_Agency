package com.xiaomai.ageny.bean;

import java.util.List;

public class DeviceInstallListBean {

    /**
     * code : 1
     * data : {"filler_time":"","install_mobile":"","list":[{"address":"四川省成都市武侯区武侯大道铁佛段1","deviceid":"JZCB061901000288","install_man":"","install_mobile":"","install_time":"2019-04-12 15:37:03","latitude":"30.622200","longitude":"103.984610","seller_man":"","seller_mobile":"","seller_name":"优博国际","unit_price":"1.00"}],"page":"1","page_size":"25","seller_mobile":""}
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
         * filler_time :
         * install_mobile :
         * list : [{"address":"四川省成都市武侯区武侯大道铁佛段1","deviceid":"JZCB061901000288","install_man":"","install_mobile":"","install_time":"2019-04-12 15:37:03","latitude":"30.622200","longitude":"103.984610","seller_man":"","seller_mobile":"","seller_name":"优博国际","unit_price":"1.00"}]
         * page : 1
         * page_size : 25
         * seller_mobile :
         */

        private String filler_time;
        private String install_mobile;
        private String page;
        private String page_size;
        private String seller_mobile;
        private List<ListBean> list;

        public String getFiller_time() {
            return filler_time;
        }

        public void setFiller_time(String filler_time) {
            this.filler_time = filler_time;
        }

        public String getInstall_mobile() {
            return install_mobile;
        }

        public void setInstall_mobile(String install_mobile) {
            this.install_mobile = install_mobile;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPage_size() {
            return page_size;
        }

        public void setPage_size(String page_size) {
            this.page_size = page_size;
        }

        public String getSeller_mobile() {
            return seller_mobile;
        }

        public void setSeller_mobile(String seller_mobile) {
            this.seller_mobile = seller_mobile;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * address : 四川省成都市武侯区武侯大道铁佛段1
             * deviceid : JZCB061901000288
             * install_man :
             * install_mobile :
             * install_time : 2019-04-12 15:37:03
             * latitude : 30.622200
             * longitude : 103.984610
             * seller_man :
             * seller_mobile :
             * seller_name : 优博国际
             * unit_price : 1.00
             */

            private String address;
            private String deviceid;
            private String install_man;
            private String install_mobile;
            private String install_time;
            private String latitude;
            private String longitude;
            private String seller_man;
            private String seller_mobile;
            private String seller_name;
            private String unit_price;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getDeviceid() {
                return deviceid;
            }

            public void setDeviceid(String deviceid) {
                this.deviceid = deviceid;
            }

            public String getInstall_man() {
                return install_man;
            }

            public void setInstall_man(String install_man) {
                this.install_man = install_man;
            }

            public String getInstall_mobile() {
                return install_mobile;
            }

            public void setInstall_mobile(String install_mobile) {
                this.install_mobile = install_mobile;
            }

            public String getInstall_time() {
                return install_time;
            }

            public void setInstall_time(String install_time) {
                this.install_time = install_time;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getSeller_man() {
                return seller_man;
            }

            public void setSeller_man(String seller_man) {
                this.seller_man = seller_man;
            }

            public String getSeller_mobile() {
                return seller_mobile;
            }

            public void setSeller_mobile(String seller_mobile) {
                this.seller_mobile = seller_mobile;
            }

            public String getSeller_name() {
                return seller_name;
            }

            public void setSeller_name(String seller_name) {
                this.seller_name = seller_name;
            }

            public String getUnit_price() {
                return unit_price;
            }

            public void setUnit_price(String unit_price) {
                this.unit_price = unit_price;
            }
        }
    }
}
