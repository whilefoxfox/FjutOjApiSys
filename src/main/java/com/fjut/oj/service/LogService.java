package com.fjut.oj.service;

import com.fjut.oj.pojo.Log;

import java.util.Date;
import java.util.List;

public interface LogService {
    Integer insertLog(Log log);

    List<Log> queryLogsByTime(Date DateStart,Date DateEnd, int startIndex);

}
