package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem;
import com.fjut.oj.pojo.ProblemView;
import com.fjut.oj.pojo.Problemsample;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.service.ProblemViewService;
import com.fjut.oj.service.serviceImpl.ProblemServiceImpl;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/problemview")
public class ProblemViewController {

    @Autowired
    private ProblemViewService problemViewService;

    @Autowired
    private ProblemService problemService;

    private ProblemServiceImpl problemServiceImpl;

    @RequestMapping("/Gproblemview")
    @ResponseBody
    public JsonMsg queryProblemView(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        ProblemView problemView = problemViewService.queryProblemView(pid);
        Problem problem = problemService.queryProblemById(pid);
        List<Problemsample> problemsamples =problemService.getProblemHTMLProblemSample(pid);


        return JsonMsg.success().addInfo(problemView).addInfo(problem).addInfo(problemsamples);
    }
}
