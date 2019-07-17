package com.fjut.oj.pojo;

/**
 * @Author: axiang [20190625] 新的挑战模式模块POJO类，集成了用户的模块信息
 */
public class ChallengeBlockForUser {
    private Integer id;
    private String name;
    private Integer totalScore;
    private String text;
    private Integer getScore;
    private Integer notScore;
    /**
     * 是否显示锁定
     */
    private boolean isLocked;
    /**
     * 是否对用户隐藏
     */
    private boolean isHide;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getGetScore() {
        return getScore;
    }

    public void setGetScore(Integer getScore) {
        this.getScore = getScore;
    }

    public Integer getNotScore() {
        return notScore;
    }

    public void setNotScore(Integer notScore) {
        this.notScore = notScore;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }

    @Override
    public String toString() {
        return "id: " + id
                + " name: " + name
                + " totalScore: " + totalScore
                + " isLocked: " + isLocked
                + " isHide: " + isHide
                + " text: " + (text.length()>10?text.substring(0,10):text)+"....";
    }
}
