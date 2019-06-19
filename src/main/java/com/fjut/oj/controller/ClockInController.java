package com.fjut.oj.controller;

import com.fjut.oj.util.Tool;
import com.fjut.oj.pojo.t_clock_in;
import com.fjut.oj.service.ClockInService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/clockin")
public class ClockInController {
    @Autowired
    private ClockInService clockInService;

    @RequestMapping(value = "/GAllClockIn")
    @ResponseBody
    public JsonMsg queryAllClockIn(HttpServletRequest req, HttpServletResponse resp) {
        List<t_clock_in> clockIns = clockInService.queryAllClockIn();
        return JsonMsg.success().addInfo(clockIns);
    }

    @RequestMapping("/GUserClockIn")
    @ResponseBody
    public JsonMsg queryAllClockInByUsername(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String pageNumStr = req.getParameter("pageNum");
        Integer pageNum;
        if (null == pageNumStr) {
            pageNum = null;
        } else {
            pageNum = Integer.parseInt(pageNumStr);
        }
        List<t_clock_in> clockIns = clockInService.queryAllClockInByUsername(username, pageNum);
        if (clockIns != null) {
            return JsonMsg.success().addInfo(clockIns);
        }
        return JsonMsg.fail().addInfo("未查询到该用户的签到记录！");

    }

    @RequestMapping("/GSomedayClockIn")
    @ResponseBody
    public JsonMsg queryAllClockInByDate(HttpServletRequest req, HttpServletResponse resp) throws ParseException {

        String dateStr = req.getParameter("date");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        List<t_clock_in> clockIns = clockInService.queryAllClockInByDate(date);
        if (clockIns != null) {
            return JsonMsg.success().addInfo(clockIns);
        }
        return JsonMsg.fail().addInfo("未查询到该用户的签到记录！");
    }

    @RequestMapping("/GUserTodayClockIn")
    @ResponseBody
    public JsonMsg queryClockInByUserAndDate(HttpServletRequest req, HttpServletResponse resp) throws ParseException {

        String username = req.getParameter("username");
        Date date = new Date();
        List<t_clock_in> clockIns = clockInService.queryClockInByUsernameAndDate(username, date);
        if (clockIns.size() != 0)
            return JsonMsg.success().addInfo(clockIns);
        return JsonMsg.fail().addInfo("未查询到该用户的签到记录！");
    }

    @RequestMapping("/UserClockIn")
    @ResponseBody
    public JsonMsg ClockInForNormalUser(HttpServletRequest req, HttpServletResponse resp) {

        Tool tool = new Tool();
        String username = req.getParameter("username");
        Date time = new Date();
        String sign = "日常";
        String ip = tool.getClientIpAddress(req);
        Integer todytimes = 1;
        t_clock_in clockIn = new t_clock_in();
        clockIn.setUsername(username);
        clockIn.setTime(time);
        clockIn.setSign(sign);
        clockIn.setIp(ip);
        clockIn.setTodytimes(todytimes);
        boolean isClockIn = clockInService.insertClockIn(clockIn);
        if (isClockIn) {
            return JsonMsg.success().addInfo("用户签到成功！");
        } else {
            return JsonMsg.fail().addInfo("用户签到失败！");
        }

    }


}
