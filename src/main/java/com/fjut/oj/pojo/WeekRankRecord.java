package com.fjut.oj.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekRankRecord implements Comparable<WeekRankRecord>{
    static int config[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    private static WeekRankRecord[] weekRank = new WeekRankRecord[8];
    private static int pageSize = 50;
    String username;
    int rank;
    int score;
    int scoreEveryDay[] = new int[30];;
    int acNum[]  = new int[30];
    Timestamp from;
    Timestamp to;
    Map<String, WeekRankRecord> resultsMap = new HashMap<>();
    List<WeekRankRecord> resultsList = new ArrayList<>();

    public static int[] getConfig() {
        return config;
    }

    public static WeekRankRecord[] getWeekRank() {
        return weekRank;
    }

    public static WeekRankRecord getWeekRank(int i) {
        return weekRank[i];
    }

    public static void setWeekRank(WeekRankRecord[] weekRank) {
        WeekRankRecord.weekRank = weekRank;
    }

    public static void setWeekRank(WeekRankRecord weekRank, int i) {
        WeekRankRecord.weekRank[i] = weekRank;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        WeekRankRecord.pageSize = pageSize;
    }

    public Timestamp getFrom() {
        return from;
    }

    public static int getConfig(int value) {
        return config[value];
    }

    public static void setConfig(int[] config) {
        WeekRankRecord.config = config;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public Map<String, WeekRankRecord> getResultsMap() {
        return resultsMap;
    }

    public void setResultsMap(Map<String, WeekRankRecord> resultsMap) {
        this.resultsMap = resultsMap;
    }

    public List<WeekRankRecord> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<WeekRankRecord> resultsList) {
        this.resultsList = resultsList;
    }

    public String getUsername() {
        return username;
    }

    public int getRank() {
        return rank;
    }

    public int getScore() {
        return score;
    }

    public int getScoreEveryDayByOne(int i) {
        return scoreEveryDay[i];
    }

    public int[] getScoreEveryDay() {
        return scoreEveryDay;
    }

    public int getAcNum(int i) {
        return acNum[i];
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setScoreEveryDay(int[] scoreEveryDay) {
        this.scoreEveryDay = scoreEveryDay;
    }

    public void setAcNum(int[] acNum) {
        this.acNum = acNum;
    }

    public int[] getAcNum() {
        return this.acNum;
    }

    @Override
    public int compareTo(WeekRankRecord o) {
        return o.score - this.score;
    }
}
