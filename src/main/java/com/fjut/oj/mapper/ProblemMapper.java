package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper {

    List<Problem> queryAllProblems();  // 查询所有的题目
    Problem  queryProblemById(@Param("pid") Integer pid);   // 通过题目 ID 查找题目
    List<Problem> queryProblemByTitle(@Param("name") String title);

}
