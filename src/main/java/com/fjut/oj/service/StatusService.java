package com.fjut.oj.service;

import com.fjut.oj.pojo.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatusService {

    List<Status> ShowAllStatus(); // 获取所有的提交情况

    List<Status> getAllStatusByUsername(String username);

    Integer allStatusNum();

    List<Status> queryStatus(Integer start);

    Status queryStatusById(Integer id); // 按照id查询评测记录

    /**
     * 查询某一条件下评测的数量
     * @param ruser
     * @param pid
     * @param result
     * @param language
     * @param start
     * @return
     */
    Integer queryCountAllStatusByConditions(String ruser, Integer pid, Integer result, Integer language, Integer start);

    /**
     * 查询某一条件下的评测
      */
    List<Status> queryAllStatusByConditions(String ruser, Integer pid, Integer result, Integer language, Integer start);

    Integer querySubmitCountByUsername(String name);    // 获取一个用户所有提交题目的次数

    Integer queryMaxStatusId();  // 获取最大的评测表的 id

    boolean insertStatus(Status status); // 插入一条记录

    boolean updateStatus(Status status); // 更新一条评测记录

    /**
     * 根据用户名获取AC的题目列表
     * @param username
     * @return
     */
    List<Status> queryACStatusByUsername(String username);
}
