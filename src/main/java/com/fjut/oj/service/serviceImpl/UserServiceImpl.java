package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.UserMapper;
import com.fjut.oj.pojo.User;
import com.fjut.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean check(String username, String password) {
        User user = userMapper.queryByUsernameAndPassword(username);
        if (user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertUser(User user) {
        int num = userMapper.insertUser(user);
        if (num == 1){
            return true;
        }
        return false;
    }

    @Override
    public int updateUserByUsername(User user) {
        return userMapper.updateUserByUsername(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.queryUserByName(username);
    }

    @Override
    public Integer getUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public List<User> queryAll() {
        List<User> list = userMapper.queryAll();
        return list;
    }

    @Override
    public void deleteUserByUsername(String username) {
        userMapper.deleteUserByUsername(username);
    }

    @Override
    public int queryPutTagNumByUsername(String username) {
        int num = userMapper.queryPutTagNumByUsername(username);
        return num;
    }

    @Override
    public List<Integer> queryStatusProblemsByUsername(Integer status, String username) {
        List<Integer> list = userMapper.queryStatusProblemsByUsername(status, username);
        return list;
    }

    @Override
    public List<Integer> queryNotPutTagProblemsByUsername(String username) {

        List<Integer> list1 = userMapper.queryStatusProblemsByUsername(1,username);
        List<Integer> list2 = userMapper.queryCanViewCodeProblemsByUsername(username);
        List<Integer> list3 = new ArrayList<>();

        for(Integer pid : list1){
            if (!list2.contains(pid)){
                list3.add(pid);
            }
        }
        return list3;
    }

    @Override
    public List<User> queryRichTop10() {
        List<User> list = userMapper.queryRichTop10();
        return list;
    }

    @Override
    public List<User> queryAcnumTop10() {
        List<User> list = userMapper.queryAcnumTop10();
        return list;
    }

    @Override
    public List<Integer> queryUserPermission(String username) {
        List<Integer> list = userMapper.queryUserPermission(username);
        return list;
    }


}
