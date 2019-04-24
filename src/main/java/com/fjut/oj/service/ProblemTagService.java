package com.fjut.oj.service;

import com.fjut.oj.pojo.Problem_tag;
import com.fjut.oj.pojo.t_problem_tag_record;

import java.util.List;

public interface ProblemTagService {

    public List<Problem_tag> queryAllProblemTag();  // 查询所有标签
    public List<t_problem_tag_record> problemTagRecord(Integer pid, String username);   // 按照题目 id 或者加上用户名查找一个题目的标签记录
    public List<t_problem_tag_record> problemTagRecordLimitNum(Integer pid, Integer from, Integer num);  // 查找一个范围的题目标签记录
    public int addTag(Integer pid, String username, Integer tagid, Integer rating);      // 用户贴标签时新增一条贴标签记录
    public int delTag(Integer pid, String username, Integer tagid);                      // 删除一个用户贴的某个标签记录
    public int addProblemTag(String tagName);                                           // 新增标签名称
    public int renameProblemTag(Integer id, Integer name);                              // 重命名标签名称
    public String queryUserTag(String username);                                     // 查询某个用户贴的总标签记录的各种类型数量
}
