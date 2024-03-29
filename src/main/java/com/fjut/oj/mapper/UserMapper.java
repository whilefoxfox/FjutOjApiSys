package com.fjut.oj.mapper;

import com.fjut.oj.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    Integer queryUserCount();

    User queryByUsernameAndPassword(@Param("username") String username);

    List<AwardInfo> queryAwardInfo(@Param("username") String username);

    int insertUser(@Param("user") User user);

    List<User> queryAll();

    User queryUserByName(@Param("username")String username);

    Integer getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int updateUserByUsername(@Param("user") User user);

    void deleteUserByUsername(@Param("username")String username);

    List<UserRadar1> queryUserRadar1(@Param("user") String user);

    List<UserRadar2> queryUserRadar2(@Param("user") String user);

    Integer queryPutTagNumByUsername(@Param("username") String username);

    List<Integer> queryStatusProblemsByUsername(@Param("status")Integer status, @Param("username")String username);

    List<Integer> queryCanViewCodeProblemsByUsername(@Param("username")String username);  // 查询用户已经贴过标签的题目

    List<User> queryRichTop10();

    List<User> queryAcnumTop10();

    List<Integer> queryUserPermission(@Param("username") String username);

    List<User> getRatingTop(@Param("from") int from,@Param("num") int num);

    List<User> getRichTop();

    List<User> getAcTop();

    List<RatingGraph> getRatingGraph(@Param("username") String username);

    Integer addAcnum(@Param("username") String username);

}
