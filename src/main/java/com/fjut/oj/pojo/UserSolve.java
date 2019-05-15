package com.fjut.oj.pojo;

public class UserSolve {

    private String username;

    private Integer pid;

    private Integer status;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserSolve{" +
                "username='" + username + '\'' +
                ", pid=" + pid +
                ", status=" + status +
                '}';
    }
}
