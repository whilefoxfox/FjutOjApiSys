package com.fjut.oj.service;

public interface StatusService {

    Integer querySubmitCountByUsername(String name);    // 获取一个用户所有提交题目的次数
}
