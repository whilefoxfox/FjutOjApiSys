package com.fjut.oj.service;

import com.fjut.oj.pojo.ContestProblem;

import java.util.List;

public interface ContestProblemService {

    public List<ContestProblem> getContestProblemsByCid(Integer cid);

    public Integer insertContestProblem(ContestProblem contestProblem);
}
