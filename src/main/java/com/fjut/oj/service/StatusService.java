package com.fjut.oj.service;

import com.fjut.oj.pojo.Status;

import java.util.List;

public interface StatusService {

    public List<Status> ShowAllStatus(); // 获取所有的提交情况

    public Integer allStatusNum();

    public List<Status> queryStatus(Integer start);

    public Status queryStatusById(Integer id); // 按照id查询评测记录

    // 查询某一条件下评测的数量
    public Integer queryCountAllStatusByConditions(String ruser, Integer pid, Integer result, Integer language, Integer start);

    // 查询某一条件下的评测
    public List<Status> queryAllStatusByConditions(String ruser, Integer pid, Integer result, Integer language, Integer start);

    public Integer querySubmitCountByUsername(String name);    // 获取一个用户所有提交题目的次数

    public Integer queryMaxStatusId();  // 获取最大的评测表的 id

    boolean insertStatus(Status status); // 插入一条记录

    boolean updateStatus(Status status); // 更新一条评测记录
}
