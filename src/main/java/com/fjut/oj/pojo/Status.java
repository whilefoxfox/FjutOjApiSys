package com.fjut.oj.pojo;

/**
 * @author cjt
 */
public class Status {
    private Integer id;
    private String ruser;
    private Integer pid;
    private Integer cid;
    private Integer lang;
    private String submitTime;
    private Integer result;
    private Integer score;
    private String timeUsed;
    private String memoryUsed;
    private String code;
    private Integer codelen;
    private Object otherinfo;
    private String submitlanguage;

    public Object getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(Object otherinfo) {
        this.otherinfo = otherinfo;
    }

    public String getSubmitlanguage() {
        return submitlanguage;
    }

    public void setSubmitlanguage(String submitlanguage) {
        this.submitlanguage = submitlanguage;
    }

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

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCodelen() {
        return codelen;
    }

    public void setCodelen(Integer codelen) {
        this.codelen = codelen;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", ruser='" + ruser + '\'' +
                ", pid=" + pid +
                ", cid=" + cid +
                ", lang=" + lang +
                ", submitTime='" + submitTime + '\'' +
                ", result=" + result +
                ", score=" + score +
                ", timeUsed='" + timeUsed + '\'' +
                ", memoryUsed='" + memoryUsed + '\'' +
                ", code='" + code + '\'' +
                ", codelen=" + codelen +
                ", otherinfo=" + otherinfo +
                ", submitlanguage='" + submitlanguage + '\'' +
                '}';
    }
}
