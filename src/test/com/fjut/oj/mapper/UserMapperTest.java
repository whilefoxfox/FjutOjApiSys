package com.fjut.oj.mapper;

import com.fjut.oj.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;



    @Test
    public void testQueryUserCount()
    {
        Integer i  = userMapper.queryUserCount();
        System.out.println(i);
        List<User> richTops = userMapper.getRichTop();
        for(User user :richTops)
        {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testQueryByUsernameAndPassword()
    {
        User user = userMapper.queryByUsernameAndPassword("__notAnonymity_");
        System.out.println(user.toString());
    }
}