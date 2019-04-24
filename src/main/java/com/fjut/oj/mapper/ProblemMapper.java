package com.fjut.oj.mapper;

import com.fjut.oj.pojo.CidProblems1;
import com.fjut.oj.pojo.CidProblems2;
import com.fjut.oj.pojo.Problem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper {

    List<Problem> queryAllProblems();  // 查询所有的题目
    Problem  queryProblemById(@Param("pid") Integer pid);   // 通过题目 ID 查找题目
    List<Problem> queryProblemByTitle(@Param("name") String title); // 通过题目标题查找题目
    Integer  queryProblemsNum(String search); // 查找题目的数量

    List<Problem> getProblems1(@Param("pid1") Integer pid1, @Param("pid2") Integer pid2, @Param("showhide") boolean showhide, @Param("owner") String owner);
    List<Problem> getProblems2(@Param("from") Integer from, @Param("num") Integer num, @Param("search") String search);
    List<Problem> getProblems3(@Param("from") Integer from, @Param("num") Integer num, @Param("search") String search);

    List<CidProblems1> getCidProblems1(@Param("cid") Integer cid);
    List<CidProblems2> getCidProblems2(@Param("cid") Integer cid);

    Integer getMaxProblemId(@Param("num") Integer num, @Param("showHide") boolean showHide);

    Integer editProblem(@Param("pid") Integer pid, @Param("problem") Problem problem);

    Integer getMaxProblemIdAddOne();

    Integer addProblem(@Param("newpid") Integer newpid, @Param("pro") Problem pro);

    Integer setProblemVisiablePid(@Param("pid") Integer pid);

    Integer setProblemVisiablePidZ(@Param("pid") Integer pid, @Param("z") Integer z);

    Integer setContestProblemVisiableCidZ(@Param("cid") Integer cid, @Param("z") Integer z);

    List<Integer> getProblemsByOjPid(@Param("oj") Integer oj, @Param("ojspid") Integer ojspid);

    Integer saveProblemHTML();
}
