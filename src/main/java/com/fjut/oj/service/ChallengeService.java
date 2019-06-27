package com.fjut.oj.service;

import com.fjut.oj.pojo.ChallengeBlockForUser;
import com.fjut.oj.pojo.ChallengeConditionForBlock;
import com.fjut.oj.pojo.t_challenge_condition;

import java.util.List;

public interface ChallengeService {
    List<ChallengeBlockForUser> queryAllChallengeBlocks();

    List<Integer> queryShowedChallengeBlocksByUsername(String username);

    List<t_challenge_condition> queryAllChallengeConditions();

    List<Integer> queryChallengeOpenBlocksByUsername(String username);

    List<ChallengeBlockForUser> queryChallengeBlocksScoredByUsername(String username);

    List<ChallengeConditionForBlock> queryChallengeConditionByBlockId(Integer blockId);
}
