package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem_tag;
import com.fjut.oj.service.ProblemTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/problemTag")
public class ProblemTagController {

    @Autowired
    private ProblemTagService problemTagService;

    @RequestMapping("/GAllProblemTag")
    @ResponseBody
    public List<Problem_tag> queryAllProblemTag(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        List<Problem_tag> list = problemTagService.queryAllProblemTag();
        return list;
    }
}
