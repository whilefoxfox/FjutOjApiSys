package com.fjut.oj.mapper;

import com.fjut.oj.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AllUsersRankMapper {

    public List<User> getallUsersRank(@Param("order") String order, @Param("desc") String desc);
}
