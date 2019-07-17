package com.fjut.oj.pojo;

import org.apache.ibatis.type.IntegerTypeHandler;

import java.util.Date;

/**
 * @Author: axiang [20190717]
 */
public class Mall {
    Integer id;
    String title;
    Integer acb;
    Integer stock;
    String des;
    boolean isHidden;
    String user;
    Date time;
    Integer buyLimit;
    Integer buyVerifyLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAcb() {
        return acb;
    }

    public void setAcb(Integer acb) {
        this.acb = acb;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(Integer buyLimit) {
        this.buyLimit = buyLimit;
    }

    public Integer getBuyVerifyLimit() {
        return buyVerifyLimit;
    }

    public void setBuyVerifyLimit(Integer buyVerifyLimit) {
        this.buyVerifyLimit = buyVerifyLimit;
    }
}
