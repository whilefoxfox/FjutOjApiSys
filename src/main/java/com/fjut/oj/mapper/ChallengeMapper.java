package com.fjut.oj.mapper;

import com.fjut.oj.pojo.ChallengeBlockForUser;
import com.fjut.oj.pojo.ChallengeConditionForBlock;
import com.fjut.oj.pojo.t_challenge_condition;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ChallengeMapper {

    /**
     * 获取全部挑战模块
     * @return
     */
    List<ChallengeBlockForUser> queryAllChallengeBlocks();

    /**
     * 获取用户显示的挑战模块ID
     * @param username
     * @return
     */
    List<Integer> queryShowedChallengeBlocksByUsername(@Param("username")String username);


    /**
     * 获取全部挑战模块的解锁条件
     * @return
     */
    List<t_challenge_condition> queryAllChallengeConditions();

    /**
     * 获取用户已开放的挑战模块ID
     * @param username
     * @return
     */
    List<Integer> queryChallengeOpenBlocksByUsername(@Param("username")String username);



    /**
     * 获取挑战模式中某个模块的解锁条件
     * @param blockId
     * @return
     */
    List<ChallengeConditionForBlock> queryChallengeConditionByBlockId(@Param("blockId") Integer blockId);


    /**
     * 根据用户获取挑战模块已完成分数
     * @param username
     * @return
     */
    List<ChallengeBlockForUser> getChallengeBlocksScoredByUsername(@Param("username") String username);

}
