package com.fjut.oj.mapper;

import com.fjut.oj.pojo.ContestProblem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContestProblemMapper {

    public List<ContestProblem> getContestProblemsByCid(@Param("cid") Integer cid);

    public Integer insertContestProblem(@Param("contestProblem") ContestProblem contestProblem);
}
