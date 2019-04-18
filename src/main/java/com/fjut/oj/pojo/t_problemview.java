package com.fjut.oj.pojo;

// 题目显示信息
public class t_problemview {

    private Integer pid;
    private String  timelimit;    // 时限
    private String  MenoryLimit;  // 内存
    private String  Int64;        // 64位
    private Integer spj;          // 是否特判
    private String  Dis;
    private String  input;        // 输入文本
    private String  output;       // 输出文本

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTimelimit() {
        return timelimit;
    }

    public void setTimelimit(String timelimit) {
        this.timelimit = timelimit;
    }

    public String getMenoryLimit() {
        return MenoryLimit;
    }

    public void setMenoryLimit(String menoryLimit) {
        MenoryLimit = menoryLimit;
    }

    public String getInt64() {
        return Int64;
    }

    public void setInt64(String int64) {
        Int64 = int64;
    }

    public Integer getSpj() {
        return spj;
    }

    public void setSpj(Integer spj) {
        this.spj = spj;
    }

    public String getDis() {
        return Dis;
    }

    public void setDis(String dis) {
        Dis = dis;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
