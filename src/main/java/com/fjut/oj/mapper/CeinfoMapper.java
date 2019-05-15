package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Ceinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CeinfoMapper {

    public List<Ceinfo> queryAllCeinfo();

    public Ceinfo queryCeinfo(@Param("rid") Integer rid);

    public Integer insertCeinfo(@Param("ce") Ceinfo ce);
}
