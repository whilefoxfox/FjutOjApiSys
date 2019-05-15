package com.fjut.oj.pojo;

public class ProblemView {

    private Integer pid;
    private String timelimit;
    private String Menorylimit;
    private String int64;
    private Integer spj;
    private String dis;
    private String input;
    private String output;

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

    public String getMenorylimit() {
        return Menorylimit;
    }

    public void setMenorylimit(String menorylimit) {
        Menorylimit = menorylimit;
    }

    public String getInt64() {
        return int64;
    }

    public void setInt64(String int64) {
        this.int64 = int64;
    }

    public Integer getSpj() {
        return spj;
    }

    public void setSpj(Integer spj) {
        this.spj = spj;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
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

    @Override
    public String toString() {
        return "ProblemView{" +
                "pid=" + pid +
                ", timelimit='" + timelimit + '\'' +
                ", Memorylimit='" + Menorylimit + '\'' +
                ", int64='" + int64 + '\'' +
                ", spj=" + spj +
                ", dis='" + dis + '\'' +
                ", input='" + input + '\'' +
                ", output='" + output + '\'' +
                '}';
    }
}
