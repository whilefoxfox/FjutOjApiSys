package com.fjut.oj.mapper;

import com.fjut.oj.pojo.t_clock_in;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ClockInMapper {

    List<t_clock_in> queryAllClockInByDate(@Param("time") Date time);

    List<t_clock_in> queryAllClockIn();

    List<t_clock_in> queryAllClockInByUsername(@Param("username") String username, @Param("pageNum") Integer pageNum);

    List<t_clock_in> queryClockInByUsernameAndDate(@Param("username") String username,@Param("date") Date date);

    int insertClockIn(@Param("clockin")t_clock_in clockin);

}
