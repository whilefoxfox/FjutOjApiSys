package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.UserSolveMapper;
import com.fjut.oj.pojo.UserSolve;
import com.fjut.oj.service.UserSolveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userSolveService")
public class UserSolveServiceImpl implements UserSolveService {

    @Autowired
    private UserSolveMapper userSolveMapper;

    @Override
    public UserSolve queryByUsernameAndPid(String username, Integer pid) {
        return userSolveMapper.queryByUsernameAndPid(username,pid);
    }

    @Override
    public UserSolve queryACProblem(String username, Integer pid) {
        return userSolveMapper.queryACProblem(username,pid);
    }
}
