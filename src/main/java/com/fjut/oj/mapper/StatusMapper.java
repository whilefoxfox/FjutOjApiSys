package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatusMapper {

    List<Status> ShowAllStatus();

    List<Status> getAllStatusByUsername(@Param("username") String username);

    Integer allStatusNum();

    List<Status> queryStatus(@Param("start") Integer start);

    Status queryStatusById(@Param("id") Integer id);

    List<Status> queryAllStatusByUser(@Param("ruser") String ruser);

    List<Status> queryAllStatusByPid(@Param("pid") String pid);

    List<Status> queryAllStatusByConditions(@Param("ruser") String ruser, @Param("pid") Integer pid, @Param("result")Integer result, @Param("language")Integer language, @Param("start")Integer start);

    Integer queryCountAllStatusByConditions(@Param("ruser") String ruser, @Param("pid") Integer pid, @Param("result")Integer result, @Param("language")Integer language, @Param("start")Integer start);

    Integer querySubmitCountByUsername(@Param("ruser") String ruser);

    Integer queryMaxStatusId();

    Integer insertStatus(@Param("status") Status status);

    Integer updateStatus(@Param("status") Status status);

    /**
     * 获取用户的AC题列表
     * @param username
     * @return
     */
    List<Status> queryACStatusByUsername(@Param("username") String username);

}
