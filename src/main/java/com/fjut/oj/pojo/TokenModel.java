package com.fjut.oj.pojo;

/**
 * @Author: axiang [20190705] Token的Model类
 * @Despriction:
 * @Date:Created in 9:10 2019/7/5
 * @Modify By:
 */
public class TokenModel {
    private String username;
    private String token;

    public TokenModel(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
