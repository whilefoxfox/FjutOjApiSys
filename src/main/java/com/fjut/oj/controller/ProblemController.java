package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.util.JsonMsg;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    /**
     * 查询所有的题目信息
     */
    @RequestMapping("/queryAllProblems")
    @ResponseBody
    public JsonMsg queryAllProblems(){

        List<Problem> list = problemService.queryAllProblems();
        if (list != null){
            return JsonMsg.success().addInfo(list);
        } else {
            return JsonMsg.fail().addInfo("未查询到题目信息");
        }
    }

    /**
     * 通过题目 ID 查找题目信息
     */
    @RequestMapping(value = "/queryProblemById",method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public JsonMsg queryProblemById(HttpServletRequest req, HttpServletResponse resp){

        Integer id = Integer.parseInt(req.getParameter("pid"));
        System.out.println("题目ID:" + id);

        Integer pid = 1001;
        Problem problem = problemService.queryProblemById(pid);

        if (problem != null){
            return JsonMsg.success().addInfo(problem);
        } else {
            return JsonMsg.fail().addInfo("未查找到该题目！");
        }
    }

    /**
     * 通过题目 title 查找题目
     */
    @RequestMapping(value = "/queryProblemByTitle",method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public JsonMsg queryProblemByTitle(HttpServletRequest req, HttpServletResponse resp){

        String title = req.getParameter("title");
        System.out.println("题目Title:" + title);

        if (title == null || title == "")
            return JsonMsg.fail().addInfo("题目查找信息为空！");

        List<Problem> list = problemService.queryProblemByTitle(title);

        if (list != null){
            return JsonMsg.success().addInfo(list);
        } else{
            return JsonMsg.success().addInfo("没有题目信息！");
        }
    }
}
