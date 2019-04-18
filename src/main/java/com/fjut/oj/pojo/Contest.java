package com.fjut.oj.pojo;

import java.util.Date;

// 比赛表
public class Contest {

    private Integer id;
    private String  name;
    private Date    beginTime;
    private Date    endTime;
    private Integer rankType;
    private Integer ctype;
    private String  password;
    private Date    registerstarttime;
    private Date    registerendtime;
    private String  info;
    private int     computerating;
    private String  createuser;
    private Integer kind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getRankType() {
        return rankType;
    }

    public void setRankType(Integer rankType) {
        this.rankType = rankType;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterstarttime() {
        return registerstarttime;
    }

    public void setRegisterstarttime(Date registerstarttime) {
        this.registerstarttime = registerstarttime;
    }

    public Date getRegisterendtime() {
        return registerendtime;
    }

    public void setRegisterendtime(Date registerendtime) {
        this.registerendtime = registerendtime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getComputerating() {
        return computerating;
    }

    public void setComputerating(int computerating) {
        this.computerating = computerating;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }
}
