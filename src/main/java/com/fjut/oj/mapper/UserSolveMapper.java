package com.fjut.oj.mapper;

import com.fjut.oj.pojo.UserSolve;
import org.apache.ibatis.annotations.Param;

public interface UserSolveMapper {

    public UserSolve queryByUsernameAndPid(@Param("username") String username, @Param("pid") Integer pid);

    public UserSolve queryACProblem(@Param("username") String username, @Param("pid") Integer pid);
}
