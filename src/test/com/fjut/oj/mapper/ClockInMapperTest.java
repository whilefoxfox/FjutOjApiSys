package com.fjut.oj.mapper;

import com.fjut.oj.pojo.t_clock_in;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ClockInMapperTest {
    @Autowired
    ClockInMapper clockInMapper;

    @Test
    public void testQueryAllClockInByDate() throws ParseException {
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");

        String datestr="2017-8-21";
        Date date = dateFormat.parse(datestr);
        System.out.println(date.toString());
        List<t_clock_in> clockins = clockInMapper.queryAllClockInByDate(date);
        for (t_clock_in clockin : clockins)
        {
            System.out.println(clockin.toString());
        }
    }

    @Test
    public void testQueryAllClockIn() throws ParseException {

        List<t_clock_in> clockins = clockInMapper.queryAllClockIn();
        for (t_clock_in clockin : clockins)
        {
            System.out.println(clockin.toString());
        }
    }

    @Test
    public void testQueryAllClockInByUsername() {
        String username="3161906213";
        List<t_clock_in> clockins = clockInMapper.queryAllClockInByUsername(username, 0);
        for (t_clock_in clockin : clockins)
        {
            System.out.println(clockin.toString());
        }
    }

    @Test
    public void testQueryClockInByUsernameAndDate()
    {
        String username="wuyuxiang";
        Date date=new Date();
        List<t_clock_in> clockins = clockInMapper.queryClockInByUsernameAndDate(username,date);
        for (t_clock_in clockin : clockins)
        {
            System.out.println(clockin.toString());
        }
    }

    @Test
    public void testInsertClockIn()
    {
        t_clock_in clockIn=new t_clock_in();
        clockIn.setUsername("wuyuxiang");
        clockIn.setSign("正常");
        clockIn.setIp("10.10.10.1");
        clockIn.setTime(new Date());
        clockIn.setTodytimes(1);
        int ret = clockInMapper.insertClockIn(clockIn);
        System.out.println("return: " + ret);
    }



}