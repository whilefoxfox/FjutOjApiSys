package com.fjut.oj.mapper;

import com.fjut.oj.pojo.t_message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class MessageMapperTest {
    @Autowired
    MessageMapper messageMapper;

    @Test
    public void testQueryAllMessageByUser() {
        String username = "wuyuxiang";
        List<t_message> messages = messageMapper.queryAllMessageByUser(username,1);
        for (t_message message : messages) {
            System.out.println(message.toString());
        }
    }

    @Test
    public void testInsertMessage(){
        t_message message=new t_message();
        message.setUser("wuyuxiang");
        message.setStatus(0);
        message.setTitle("标题");
        message.setText("测试用的");
        message.setTime(new Date());
        message.setDeadline(new Date());
        int ret = messageMapper.insertMessage(message);
        System.out.println(ret);

    }

    @Test
    public void testUpdateMessageStatu(){
        int mid=68487;
        int status = 0;
        int ret = messageMapper.updateMessageStatuByMid(mid,status);
        System.out.println(ret);
    }

    @Test
    public void testDeleteAllMessageByUser() {
        String username = "zzz123";
        int ret = messageMapper.deleteAllMessageByUser(username);
        System.out.println(ret);
    }
}