package com.fjut.oj.pojo;

// 题目表
public class Problem {
    private Integer pid;
    private Integer ptype;
    private String  title;
    private Integer ojid;
    private String  ojspid;
    private Integer visiable;
    private String  author;

    public Problem() {
    }

    public Problem(Integer ptype, String title, Integer ojid, String ojspid, Integer visiable, String author) {
        this.ptype = ptype;
        this.title = title;
        this.ojid = ojid;
        this.ojspid = ojspid;
        this.visiable = visiable;
        this.author = author;
    }

    public String getOjspid() {
        return ojspid;
    }

    public void setOjspid(String ojspid) {
        this.ojspid = ojspid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPtype() {
        return ptype;
    }

    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOjid() {
        return ojid;
    }

    public void setOjid(Integer ojid) {
        this.ojid = ojid;
    }

    public Integer getVisiable() {
        return visiable;
    }

    public void setVisiable(Integer visiable) {
        this.visiable = visiable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
