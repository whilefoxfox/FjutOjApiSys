package com.fjut.oj.service;

import com.fjut.oj.pojo.User;

import java.util.List;

public interface UserService {
    public boolean check(String username, String password); // 登录检测用户名和密码是否匹配
    public boolean insertUser(User user);                   // 插入用户
    public int updateUserByUsername(User user);             // 通过用户名更新用户
    public User getUserByUsername(String usernam);          // 通过用户名查找用户
    public List<User> queryAll();                           // 查找所有用户
    public void  deleteUserByUsername(String username);     // 通过用户名删除用户
    public int queryPutTagNumByUsername(String username);   // 查询一个用户贴标签的数量
    public List<Integer> queryStatusProblemsByUsername(Integer status, String username); // 查询用户通过和未通过的题目
}
