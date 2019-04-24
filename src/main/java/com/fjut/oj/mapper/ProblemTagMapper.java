package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Problem_tag;
import com.fjut.oj.pojo.UserTag1;
import com.fjut.oj.pojo.UserTag2;
import com.fjut.oj.pojo.t_problem_tag_record;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProblemTagMapper {

    public List<Problem_tag> queryAllProblemTag();
    public List<t_problem_tag_record> problemTagRecord(@Param("pid") Integer pid, @Param("username") String username);
    public List<t_problem_tag_record> problemTagRecordLimitNum(@Param("pid") Integer pid, @Param("from") Integer from, @Param("num") Integer num);
    public int addTag(@Param("pid") Integer pid, @Param("username") String username, @Param("tagid") Integer tagid, @Param("rating") Integer rating);
    public int delTag(@Param("pid") Integer pid, @Param("username") String username, @Param("pid") Integer tagid);
    public int addProblemTag(@Param("username") String tagName);
    public int renameProblemTag(@Param("id") Integer id, @Param("name") Integer name);
    public List<UserTag1> queryUserTag1(@Param("username") String username);
    public List<UserTag2> queryUserTag2();
}
