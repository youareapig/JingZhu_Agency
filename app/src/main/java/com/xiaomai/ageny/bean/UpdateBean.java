package com.xiaomai.ageny.bean;

public class UpdateBean {

    /**
     * id : 1
     * udate : Yes
     * newVersion : 1
     * apkFileUrl : http://47.92.253.91:8010/app-release.apk
     * updateLog : 应用更新
     * targetSize : 7.5MB
     * newMd5 :
     * cons : false
     * versionType : 0
     */

    private int id;
    private String udate;
    private String newVersion;
    private String apkFileUrl;
    private String updateLog;
    private String targetSize;
    private String newMd5;
    private boolean cons;
    private String versionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getApkFileUrl() {
        return apkFileUrl;
    }

    public void setApkFileUrl(String apkFileUrl) {
        this.apkFileUrl = apkFileUrl;
    }

    public String getUpdateLog() {
        return updateLog;
    }

    public void setUpdateLog(String updateLog) {
        this.updateLog = updateLog;
    }

    public String getTargetSize() {
        return targetSize;
    }

    public void setTargetSize(String targetSize) {
        this.targetSize = targetSize;
    }

    public String getNewMd5() {
        return newMd5;
    }

    public void setNewMd5(String newMd5) {
        this.newMd5 = newMd5;
    }

    public boolean isCons() {
        return cons;
    }

    public void setCons(boolean cons) {
        this.cons = cons;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }
}
