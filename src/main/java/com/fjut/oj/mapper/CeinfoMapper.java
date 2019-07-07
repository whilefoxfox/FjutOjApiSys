package com.fjut.oj.mapper;

import com.fjut.oj.pojo.Ceinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CeinfoMapper {

    List<Ceinfo> queryAllCeinfo();

    Ceinfo queryCeinfo(@Param("rid") Integer rid);

    Integer insertCeinfo(@Param("ce") Ceinfo ce);
}
