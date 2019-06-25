package com.fjut.oj.mapper;

import com.fjut.oj.pojo.ChallengeBlockForUser;
import com.fjut.oj.pojo.t_challenge_block;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ChallengeMapper {
    public List<ChallengeBlockForUser> getChallengeBlocksForUser();
    //TODO: 还没做完
    public List<Integer> getChallengeOpenBlocksByUsername();

}
