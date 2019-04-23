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
    public List<Integer> queryStatusProblemsByUsername(Integer status, String username); // 查询用户通过和未通过的题目  status 为 1 获取user已经AC题目列表 为 0 获取user提交过但没有AC的题目列表（不包括contest内的）
    public List<Integer> queryNotPutTagProblemsByUsername(String username); // 查询用户未贴标签的题目
    public List<User> queryRichTop10();                  // 获取用户 ACB 排行榜前10
    public List<User> queryAcnumTop10();                 // 获取用户 AC 题目数量前10
    public List<Integer> queryUserPermission(String username); // 获取用户权限
}
