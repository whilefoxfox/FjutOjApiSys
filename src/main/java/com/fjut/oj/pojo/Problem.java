package com.fjut.oj.pojo;

// 题目表
public class Problem {
    static public int LOCAL = 0;
    static public int OTHEROJ = 1;
    static public int ONLYDES = 2;
    private boolean spj;
    public int totalSubmit;
    public int totalSubmitUser;
    public int totalAc;
    public int totalAcUser;
    private Integer pid;
    private Integer ptype;
    private String  title;
    private Integer ojid;
    private String  ojspid;
    private Integer visiable;
    private String  author;
    public  Double  radio;
    public String  strRadio;

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
    public Problem(int ojid,String ojspid,String title,String author,boolean spj){
        this.ojid=ojid;
        this.ojspid=ojspid;
        this.title=title;
        this.ptype= OTHEROJ;
        this.author=author;
        this.spj=spj;
    }
    public boolean isLocal(){return ptype == LOCAL;}

    public boolean isSpj(){return spj;}

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

    public static int getLOCAL() {
        return LOCAL;
    }

    public static void setLOCAL(int LOCAL) {
        Problem.LOCAL = LOCAL;
    }

    public static int getOTHEROJ() {
        return OTHEROJ;
    }

    public static void setOTHEROJ(int OTHEROJ) {
        Problem.OTHEROJ = OTHEROJ;
    }

    public static int getONLYDES() {
        return ONLYDES;
    }

    public static void setONLYDES(int ONLYDES) {
        Problem.ONLYDES = ONLYDES;
    }

    public void setSpj(boolean spj) {
        this.spj = spj;
    }

    public int getTotalSubmit() {
        return totalSubmit;
    }

    public void setTotalSubmit(int totalSubmit) {
        this.totalSubmit = totalSubmit;
    }

    public int getTotalSubmitUser() {
        return totalSubmitUser;
    }

    public void setTotalSubmitUser(int totalSubmitUser) {
        this.totalSubmitUser = totalSubmitUser;
    }

    public int getTotalAc() {
        return totalAc;
    }

    public void setTotalAc(int totalAc) {
        this.totalAc = totalAc;
    }

    public int getTotalAcUser() {
        return totalAcUser;
    }

    public void setTotalAcUser(int totalAcUser) {
        this.totalAcUser = totalAcUser;
    }

    public Double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public String getStrRadio() {
        return strRadio;
    }

    public void setStrRadio(String strRadio) {
        this.strRadio = strRadio;
    }
}
