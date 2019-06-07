package com.fjut.oj.service;

import com.fjut.oj.pojo.Contestuser;

import java.util.List;

public interface ContestUserService {

    public List<Contestuser> getContestUserById(Integer cid);

    public Integer insertContestUser(Contestuser contestuser);
}
