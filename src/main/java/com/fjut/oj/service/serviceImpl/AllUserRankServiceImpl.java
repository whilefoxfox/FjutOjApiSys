package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.AllUsersRankMapper;
import com.fjut.oj.pojo.User;
import com.fjut.oj.service.AllUserRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("allUsersRankService")
public class AllUserRankServiceImpl implements AllUserRankService {

    @Autowired
    private AllUsersRankMapper allUsersRankMapper;

    @Override
    public List<User> allUsersRank(String order, String desc) {
        List<User> list = allUsersRankMapper.getallUsersRank(order,desc);
        return list;
    }
}
