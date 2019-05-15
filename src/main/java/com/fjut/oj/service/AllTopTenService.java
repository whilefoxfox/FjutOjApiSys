package com.fjut.oj.service;

import com.fjut.oj.pojo.User;

import java.util.List;

public interface AllTopTenService {
    public List<User> getRatingTOP();
    public List<User> getAcbTOP();
    public List<User> getAcTOP();
    public List<User> getActiveTop();
}
