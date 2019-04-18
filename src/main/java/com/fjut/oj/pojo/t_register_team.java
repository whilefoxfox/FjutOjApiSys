package com.fjut.oj.pojo;

import java.util.Date;

// 注册队伍信息
public class t_register_team {

    private String  username;
    private Integer cid;
    private String  teamusername;
    private String  teampassword;
    private String  teamname;
    private Integer statu;
    private String  info;
    private Date    time;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTeamusername() {
        return teamusername;
    }

    public void setTeamusername(String teamusername) {
        this.teamusername = teamusername;
    }

    public String getTeampassword() {
        return teampassword;
    }

    public void setTeampassword(String teampassword) {
        this.teampassword = teampassword;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
