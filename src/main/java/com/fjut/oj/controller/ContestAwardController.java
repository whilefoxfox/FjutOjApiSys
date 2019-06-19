package com.fjut.oj.controller;

import com.fjut.oj.pojo.TeamMemberInfo;
import com.fjut.oj.service.TeamMemberInfoService;
import com.fjut.oj.util.JsonMsg;
import com.fjut.oj.util.ResultString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/addContestAward")
public class ContestAwardController {

    @Autowired
    private TeamMemberInfoService teamMemberInfoService;

    @ResponseBody
    @RequestMapping("/IContestAward")
    public JsonMsg IContestAward(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String time = req.getParameter("time");
        String username1 = req.getParameter("username1") == null ? "" : req.getParameter("username1");
        String username2 = req.getParameter("username2") == null ? "" : req.getParameter("username2");
        String username3 = req.getParameter("username3") == null ? "" : req.getParameter("username3");
        String name1 = req.getParameter("name1") == null ? "" : req.getParameter("name1");
        String name2 = req.getParameter("name2") == null ? "" : req.getParameter("name2");
        String name3 = req.getParameter("name3") == null ? "" : req.getParameter("name3");
        String contestLevelStr = req.getParameter("contest_level");
        Integer contestLevel = ResultString.contestLevelToint(contestLevelStr);
        String awardsLevelStr = req.getParameter("awards_level");
        Integer awardsLevel= ResultString.awardLevelToint(awardsLevelStr);
        String text = req.getParameter("text");

        TeamMemberInfo teamMemberInfo = new TeamMemberInfo();
        teamMemberInfo.setTime(time);
        teamMemberInfo.setUsername1(username1);
        teamMemberInfo.setUsername2(username2);
        teamMemberInfo.setUsername3(username3);
        teamMemberInfo.setName1(name1);
        teamMemberInfo.setName2(name2);
        teamMemberInfo.setName3(name3);
        teamMemberInfo.setContest_level(contestLevel);
        teamMemberInfo.setAwards_level(awardsLevel);
        teamMemberInfo.setText(text);

        Integer num = teamMemberInfoService.insertTeamMemberInfo(teamMemberInfo);
        if (num != 0){
            return JsonMsg.success().addInfo("添加成功");
        }
        return JsonMsg.fail().addInfo("添加失败");
    }
}
