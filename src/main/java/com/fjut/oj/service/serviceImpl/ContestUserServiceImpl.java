package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.ContestUserMapper;
import com.fjut.oj.pojo.Contestuser;
import com.fjut.oj.service.ContestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contestUserService")
public class ContestUserServiceImpl implements ContestUserService {

    @Autowired
    private ContestUserMapper contestUserMapper;

    public List<Contestuser> getContestUserById(Integer cid){
        return contestUserMapper.getContestUserById(cid);
    }

    public Integer insertContestUser(Contestuser contestuser){
        return contestUserMapper.insertContestUser(contestuser);
    }
}
