package com.fjut.oj.pojo;

public class UserRadar2 {

    private Integer ttype;

    private Integer num;

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
        return "UserRadar2{" +
                "ttype=" + ttype +
                ", num=" + num +
                '}';
    }
}
