package com.fjut.oj.pojo;

public class Ceinfo {
    Integer rid;
    String info;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ceinfo{" +
                "rid=" + rid +
                ", info='" + info + '\'' +
                '}';
    }
}
