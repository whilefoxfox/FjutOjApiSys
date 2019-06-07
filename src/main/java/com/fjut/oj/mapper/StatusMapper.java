package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatusMapper {

    public List<Status> ShowAllStatus();

    public List<Status> getAllStatusByUsername(@Param("username") String username);

    public Integer allStatusNum();

    public List<Status> queryStatus(@Param("start") Integer start);

    public Status queryStatusById(@Param("id")  Integer id);

    public List<Status> queryAllStatusByUser(@Param("ruser") String ruser);

    public List<Status> queryAllStatusByPid(@Param("pid") String pid);

    List<Status> queryAllStatusByConditions(@Param("ruser") String ruser, @Param("pid") Integer pid, @Param("result")Integer result, @Param("language")Integer language, @Param("start")Integer start);

    Integer queryCountAllStatusByConditions(@Param("ruser") String ruser, @Param("pid") Integer pid, @Param("result")Integer result, @Param("language")Integer language, @Param("start")Integer start);

    Integer querySubmitCountByUsername(@Param("ruser") String ruser);

    Integer queryMaxStatusId();

    Integer insertStatus(@Param("status") Status status);

    Integer updateStatus(@Param("status") Status status);

    public List<Status> getAcNum(@Param("username") String username);

}
