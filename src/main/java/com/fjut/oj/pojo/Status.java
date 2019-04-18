package com.fjut.oj.pojo;

import java.util.Date;

// 评测表
public class Status {

    private Integer id;
    private String  ruser;
    private Integer pid;
    private Integer cid;
    private Integer lang;
    private Date    submitTime;
    private Integer result;
    private String  timeUsed;
    private String  memoryUsed;
    private String  code;
    private Integer codelen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuser() {
        return ruser;
    }

    public void setRuser(String ruser) {
        this.ruser = ruser;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getLang() {
        return lang;
    }

    public void setLang(Integer lang) {
        this.lang = lang;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(String timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(String memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String text) {
        this.code = text;
    }

    public Integer getCodelen() {
        return codelen;
    }

    public void setCodelen(Integer codelen) {
        this.codelen = codelen;
    }
}
