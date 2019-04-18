package com.fjut.oj.pojo;

import java.util.Date;

// 比赛排名记录表
public class t_rating {

    private String  username;
    private Date    time;
    private Integer cid;
    private Integer prating;
    private Integer rating;
    private Integer ratingnum;
    private Integer rank;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPrating() {
        return prating;
    }

    public void setPrating(Integer prating) {
        this.prating = prating;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getRatingnum() {
        return ratingnum;
    }

    public void setRatingnum(Integer ratingnum) {
        this.ratingnum = ratingnum;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
