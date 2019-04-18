package com.fjut.oj.pojo;

public class UserRadar1 {

    private String username;

    private Integer ttype;

    private Integer num;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTtype() {
        return ttype;
    }

    public void setTtype(Integer ttype) {
        this.ttype = ttype;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "UserRadar1{" +
                "username='" + username + '\'' +
                ", ttype=" + ttype +
                ", num=" + num +
                '}';
    }
}
