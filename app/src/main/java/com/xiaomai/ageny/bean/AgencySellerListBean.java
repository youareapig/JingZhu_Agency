package com.xiaomai.ageny.bean;

import java.util.List;

public class AgencySellerListBean {


    /**
     * code : 1
     * data : [{"id":"JZCB061901000003","linktel":"18782420845","lixian":"0","name":"现代医院（3楼护士站B）","page":"","pageSize":"","sellerId":"61000027","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000004","linktel":"18782420845","lixian":"0","name":"成都现代医院4楼护士站C区","page":"","pageSize":"","sellerId":"61000146","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000242","linktel":"18782420845","lixian":"0","name":"现代医院（急诊）","page":"","pageSize":"","sellerId":"61000025","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000271","linktel":"18782420845","lixian":"0","name":"现代医院（护士站6楼A）","page":"","pageSize":"","sellerId":"61000035","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000273","linktel":"18782420845","lixian":"0","name":"现代医院（护士站5楼B）","page":"","pageSize":"","sellerId":"61000033","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000274","linktel":"18782420845","lixian":"0","name":"现代医院（护士站6楼B）","page":"","pageSize":"","sellerId":"61000037","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000275","linktel":"18782420845","lixian":"0","name":"现代医院（护士站7楼A）","page":"","pageSize":"","sellerId":"61000040","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000284","linktel":"18782420845","lixian":"0","name":"现代医院（护士站7楼B）","page":"","pageSize":"","sellerId":"61000039","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000289","linktel":"18782420845","lixian":"0","name":"成都现代医院C区5楼护土站","page":"","pageSize":"","sellerId":"61000147","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000290","linktel":"18782420845","lixian":"0","name":"现代医院（护士站5楼A）","page":"","pageSize":"","sellerId":"61000034","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000291","linktel":"18782420845","lixian":"0","name":"现代医院（急诊台）","page":"","pageSize":"","sellerId":"61000023","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000293","linktel":"18782420845","lixian":"0","name":"现代医院（导医台）","page":"","pageSize":"","sellerId":"61000022","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000294","linktel":"18782420845","lixian":"0","name":"现代医院（住院部护士站3楼A）","page":"","pageSize":"","sellerId":"61000029","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000296","linktel":"18782420845","lixian":"0","name":"现代医院（住院部4楼护士站A）","page":"","pageSize":"","sellerId":"61000030","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000298","linktel":"18782420845","lixian":"0","name":"现代医院（护士站7楼A）","page":"","pageSize":"","sellerId":"61000041","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000300","linktel":"18782420845","lixian":"0","name":"现代医院（护士站4楼B）","page":"","pageSize":"","sellerId":"61000031","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000333","linktel":"18782420845","lixian":"0","name":"现代医院（护士站7楼B）","page":"","pageSize":"","sellerId":"61000042","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000360","linktel":"18782420845","lixian":"0","name":"现代医院（健康体检部）","page":"","pageSize":"","sellerId":"61000043","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000554","linktel":"18782420845","lixian":"0","name":"成都现代医院6楼C区","page":"","pageSize":"","sellerId":"61000149","state":"1","total":"","zaixian":"1"},{"id":"JZCB061901000563","linktel":"18782420845","lixian":"0","name":"成都现代医院7楼C区护士站","page":"","pageSize":"","sellerId":"61000150","state":"1","total":"","zaixian":"1"}]
     * message : 获取代理的商户信息成功
     */

    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : JZCB061901000003
         * linktel : 18782420845
         * lixian : 0
         * name : 现代医院（3楼护士站B）
         * page :
         * pageSize :
         * sellerId : 61000027
         * state : 1
         * total :
         * zaixian : 1
         */

        private String id;
        private String linktel;
        private String lixian;
        private String name;
        private String page;
        private String pageSize;
        private String sellerId;
        private String state;
        private String total;
        private String zaixian;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLinktel() {
            return linktel;
        }

        public void setLinktel(String linktel) {
            this.linktel = linktel;
        }

        public String getLixian() {
            return lixian;
        }

        public void setLixian(String lixian) {
            this.lixian = lixian;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getZaixian() {
            return zaixian;
        }

        public void setZaixian(String zaixian) {
            this.zaixian = zaixian;
        }
    }
}
