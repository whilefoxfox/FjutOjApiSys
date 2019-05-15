package com.fjut.oj.service;

import com.fjut.oj.pojo.User;

import java.util.List;

public interface AllUserRankService {
    public List<User> allUsersRank(String order, String desc);
}
