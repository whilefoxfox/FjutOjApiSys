package com.fjut.oj.pojo;

public class Problems1 {
    private Integer pid;
    private String title;
    private boolean visiable;
    private Integer totalAcUser;
    private Integer totalSubmit;
    public  Double  radio;
    public String  strRadio;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVisiable() {
        return visiable;
    }

    public void setVisiable(boolean visiable) {
        this.visiable = visiable;
    }

    public Integer getTotalAcUser() {
        return totalAcUser;
    }

    public void setTotalAcUser(Integer totalAcUser) {
        this.totalAcUser = totalAcUser;
    }

    public Integer getTotalSubmit() {
        return totalSubmit;
    }

    public void setTotalSubmit(Integer totalSubmit) {
        this.totalSubmit = totalSubmit;
    }
}
