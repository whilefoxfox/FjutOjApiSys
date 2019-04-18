package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.UserMapper;
import com.fjut.oj.pojo.User;
import com.fjut.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.queryUserByUsername(username);
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
}
