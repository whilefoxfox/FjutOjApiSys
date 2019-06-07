package com.fjut.oj.service;

import com.fjut.oj.pojo.NewDiscuss;

import java.util.List;

public interface NewDiscussService {

    List<NewDiscuss> queryDiscussByPage(Integer start);

    Integer queryDiscussCount();

    Integer insertDiscuss(NewDiscuss newDiscuss);

    Integer queryMaxCountDiscussId();

    Integer queryDiscussCountById(Integer id);

    Integer updateDisscussPirority(Integer id, Double priority);
}
