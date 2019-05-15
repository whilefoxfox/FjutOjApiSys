package com.fjut.oj.mapper;

import com.fjut.oj.pojo.ProblemView;
import org.apache.ibatis.annotations.Param;

public interface ProblemViewMapper {

    ProblemView queryProblemView(@Param("pid") Integer pid);

}
