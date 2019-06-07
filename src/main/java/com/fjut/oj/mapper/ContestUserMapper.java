package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Contestuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContestUserMapper {

    public List<Contestuser> getContestUserById(@Param("cid") Integer cid);

    public Integer insertContestUser(@Param("contestuser") Contestuser contestuser);
}
