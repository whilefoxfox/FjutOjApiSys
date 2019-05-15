package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Problemsample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemSampleMapper {

    public List<Problemsample> queryProblemsampleById(@Param("pid") Integer pid);
}
