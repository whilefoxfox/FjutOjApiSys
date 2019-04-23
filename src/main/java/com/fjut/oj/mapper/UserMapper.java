package com.fjut.oj.mapper;

import com.fjut.oj.pojo.User;
import com.fjut.oj.pojo.UserRadar1;
import com.fjut.oj.pojo.UserRadar2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User queryByUsernameAndPassword(@Param("username") String username);

    int insertUser(User user);

    List<User> queryAll();

    User queryUserByUsername(@Param("username")String username);

    int updateUserByUsername(User user);

    void deleteUserByUsername(@Param("username")String username);

    List<UserRadar1> queryUserRadar1(@Param("user") String user);

    List<UserRadar2> queryUserRadar2(@Param("user") String user);

    int queryPutTagNumByUsername(@Param("username") String username);

    List<Integer> queryStatusProblemsByUsername(@Param("status")Integer status, @Param("username")String username);

    List<Integer> queryCanViewCodeProblemsByUsername(@Param("username")String username);  // 查询用户已经贴过标签的题目

    List<User> queryRichTop10();

    List<User> queryAcnumTop10();

    List<Integer> queryUserPermission(@Param("username") String username);
}
