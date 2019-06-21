package com.fjut.oj.controller;

import com.fjut.oj.pojo.User;
import com.fjut.oj.service.AllUserRankService;
import com.fjut.oj.service.UserService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
/**
 * TODO: 把 JsonMsg 替换为 JsonInfo
 */
@RequestMapping("/rank")
@Controller
public class UserRankController {

    @Autowired
    private AllUserRankService allUserRankService;

    @Autowired
    private UserService userService;

    @RequestMapping("/GUserRank")
    @ResponseBody
    public JsonMsg getAllUsersRank(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String pagenumStr = req.getParameter("pagenum") == null ? "1" : req.getParameter("pagenum");
        String order = req.getParameter("order") == null ? "acnum" : req.getParameter("order");
        String desc = req.getParameter("desc") == null ? null : req.getParameter("desc");
        Integer pagenum = Integer.parseInt(pagenumStr);
        System.out.println(order + " " + desc + " " + pagenum);

        Integer totalUser = userService.queryUserCount();
        Integer totalPageNum = totalUser % 50 == 0 ? totalUser / 50 : totalUser / 50 + 1;
        Integer start = (pagenum - 1) * 50;

        List<User> list = allUserRankService.allUsersRank(order,desc,start);
        return JsonMsg.success().addInfo(totalPageNum).addInfo(list);
    }

    @RequestMapping("/GUserRankByName")
    @ResponseBody
    public JsonMsg getUsersRankByName(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String pagenumStr = req.getParameter("pagenum") == null ? "1" : req.getParameter("pagenum");
        String username = req.getParameter("username");
        Integer pagenum = Integer.parseInt(pagenumStr);

        Integer totalUser = allUserRankService.queryUserCountByName(username);
        Integer totalPageNum = totalUser % 50 == 0 ? totalUser / 50 : totalUser / 50 + 1;
        Integer start = (pagenum - 1) * 50;

        List<User> list = allUserRankService.queryUserByName(username,start);
        return JsonMsg.success().addInfo(totalPageNum).addInfo(list);
    }
}
