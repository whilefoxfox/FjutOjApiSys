package com.fjut.oj.service;

import com.fjut.oj.pojo.SubmisssionRecord;
import com.fjut.oj.pojo.User;
import com.fjut.oj.pojo.WeekRankRecord;

import java.util.List;

public interface WeekRankRecordService {
    public void add(WeekRankRecord weekRankRecord, int day, int value);
    public void addStatus(WeekRankRecord weekRankRecord, SubmisssionRecord submisssionRecord);
    public void sort(WeekRankRecord weekRankRecord);
    public List<User> getActiveRank();
}
