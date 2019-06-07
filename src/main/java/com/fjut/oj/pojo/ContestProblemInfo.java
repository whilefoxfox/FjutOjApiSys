package com.fjut.oj.pojo;

public class ContestProblemInfo {
    private Integer tpid;
    private String title;
    private Integer totalAcUser;
    private Integer totalSubmit;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
