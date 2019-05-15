package com.fjut.oj.service;

import com.fjut.oj.pojo.UserSolve;

public interface UserSolveService {

    public UserSolve queryByUsernameAndPid(String username, Integer pid);

    public UserSolve queryACProblem(String username, Integer pid);
}
