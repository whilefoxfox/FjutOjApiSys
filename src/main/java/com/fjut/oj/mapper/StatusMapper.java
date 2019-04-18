package com.fjut.oj.mapper;

import org.apache.ibatis.annotations.Param;

public interface StatusMapper {

    Integer querySubmitCountByUsername(@Param("ruser") String ruser);
}
