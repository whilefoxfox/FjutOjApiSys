package com.fjut.oj.mapper;

import com.fjut.oj.pojo.*;
import com.fjut.oj.util.problemHTML;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemMapper {

    List<Problem> queryAllProblems();  // getPageNum查询所有的题目

    List<Problem> queryProblemsByPage(@Param("pid1") Integer pid1, @Param("pid2") Integer pid2); // 一页一页的查询题目信息

    List<Problem> queryProblemsFromHDU(@Param("from") Integer from, @Param("to") Integer to); // 查询一个范围内杭电的题目

    Problem  queryProblemById(@Param("pid") Integer pid);   // 通过题目 ID 查找题目

    List<Problem> queryProblemByTitle(@Param("title") String title, @Param("pid1") Integer pid1); // 通过题目标题查找题目

    Integer queryProblemsNum(); // 查找题目的数量

    Integer queryProblemsNumByTitle(@Param("title") String title);

    Integer updateProblemtotalSubmit(@Param("pid") Integer pid);

    Integer updateProblemtotalSubmitUser(@Param("pid") Integer pid);

    Integer updateProblemtotalAc(@Param("pid") Integer pid);

    Integer updateProblemtotalAcUser(@Param("pid") Integer pid);

    List<Problems1> getProblems1(@Param("pid1") Integer pid1, @Param("pid2") Integer pid2, @Param("showhide") boolean showhide, @Param("owner") String owner);

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

    List<Integer> getProblemsByOjPid(@Param("oj") Integer oj, @Param("ojspid") String ojspid);

    Integer saveProblemHTMLProblemView(@Param("pid") Integer pid, @Param("ph") problemHTML ph);

    Integer saveProblemHTMLProblemSample(@Param("pid") Integer pid, @Param("ph") problemHTML ph);

    /*
    Integer editProblemDis();

    Integer editProblemInput();

    Integer editProblemOutput();

    Integer editProblemSampleInput();

    Integer editProblemSampleoutput();*/

    Integer delProblemDisProblemView(@Param("pid") Integer pid);

    Integer delProblemDisProblemSample(@Param("pid") Integer pid);

    List<t_problemview> getProblemHTMLProblemView(@Param("pid") Integer pid);

    List<Problemsample> getProblemHTMLProblemSample(@Param("pid") Integer pid);
}
