package com.fjut.oj.mapper;

import com.fjut.oj.pojo.NewDiscuss;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewDiscussMapper {

    public List<NewDiscuss> queryDiscussByPage(@Param("start") Integer start);

    public Integer queryDiscussCount();

    public Integer insertDiscuss(@Param("newDiscuss") NewDiscuss newDiscuss);

    public Integer queryMaxCountDiscussId();

    public Integer queryDiscussCountById(@Param("id")Integer id);

    public Integer updateDisscussPirority(@Param("id")Integer id, @Param("priority") Double priority);
}
