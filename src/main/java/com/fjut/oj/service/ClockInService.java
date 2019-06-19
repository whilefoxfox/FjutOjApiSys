package com.fjut.oj.service;

import com.fjut.oj.pojo.t_clock_in;

import java.util.Date;
import java.util.List;


public interface ClockInService {
    List<t_clock_in> queryAllClockInByDate(Date time);

    List<t_clock_in> queryAllClockIn();

    List<t_clock_in> queryAllClockInByUsername(String username, Integer pageNum);

    List<t_clock_in> queryClockInByUsernameAndDate(String username, Date date);

    boolean insertClockIn(t_clock_in clockin);
}
