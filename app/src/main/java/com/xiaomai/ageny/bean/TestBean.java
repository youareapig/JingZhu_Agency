package com.xiaomai.ageny.bean;

import java.util.List;

public class TestBean {
    private MyData myData;
    private String storeName;

    public MyData getMyData() {
        return myData;
    }

    public void setMyData(MyData myData) {
        this.myData = myData;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public class MyData {
        private List<String> moList;

        public List<String> getMoList() {
            return moList;
        }

        public void setMoList(List<String> moList) {
            this.moList = moList;
        }
    }
}
