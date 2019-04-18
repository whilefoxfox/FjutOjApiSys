package com.fjut.oj.service;

import com.fjut.oj.pojo.Problem;

import java.util.List;

public interface ProblemService {

    public List<Problem> queryAllProblems();        //查询所有的题目

    public Problem queryProblemById(Integer pid);   // 通过题目 ID 查找题目

    public List<Problem> queryProblemByTitle(String title);  // 通过题目名称查找题目
}
