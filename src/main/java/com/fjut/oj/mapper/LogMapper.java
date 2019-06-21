package com.fjut.oj.mapper;

import java.util.Date;
import java.util.List;

import com.fjut.oj.pojo.Log;
import org.apache.ibatis.annotations.Param;

/**
 * @author axiang
 */
public interface LogMapper {
    Integer insertLog(@Param("log") Log log);

    List<Log> queryLogsByTime(@Param("timeStart") Date DateStart, @Param("timeEnd") Date DateEnd, @Param("startIndex") int startIndex);

}