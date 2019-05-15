package com.fjut.oj.controller;

import com.fjut.oj.pojo.User;
import com.fjut.oj.service.AllUserRankService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/rank")
@Controller
public class UserRankController {

    @Autowired
    private AllUserRankService allUserRankService;

    @RequestMapping("/GUserRank")
    @ResponseBody
    public JsonMsg getAllUsersRank(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String order = req.getParameter("order") == null ? "rank" : req.getParameter("order");
        String desc = req.getParameter("desc") == null ? "" : req.getParameter("desc");
        System.out.println(order + " " + desc);
        List<User> list = allUserRankService.allUsersRank(order,desc);
        return JsonMsg.success().addInfo(list);
    }
}
