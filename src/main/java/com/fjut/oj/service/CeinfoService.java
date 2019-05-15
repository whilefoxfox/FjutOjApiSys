package com.fjut.oj.service;

import com.fjut.oj.pojo.Ceinfo;

import java.util.List;

public interface CeinfoService {

    public List<Ceinfo> queryAllCeinfo();

    public Ceinfo queryCeinfo(Integer rid);

    public boolean insertCeinfo(Ceinfo ce);
}
