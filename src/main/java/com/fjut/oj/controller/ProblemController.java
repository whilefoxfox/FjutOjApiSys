package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.util.JsonMsg;
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

    /**
     * 查询题目数量
     */
    @RequestMapping("/GProblemsNum")
    @ResponseBody
    public JsonMsg queryProblemsNum(HttpServletRequest req, HttpServletResponse resp){
        String search = "";
        Integer num = problemService.queryProblemsNum(search);
        return JsonMsg.success().addInfo(num);
    }

    /**
     * 查询一个范围题目号范围内的题目 并可以选择是否查询隐藏题目和拥有者
     */
    @RequestMapping("/GProblems1")
    @ResponseBody
    public JsonMsg getProblems1(HttpServletRequest req, HttpServletResponse resp){
        Integer pid1 = 1500;
        Integer pid2 = 2000;
        boolean showhide = false;
        String owner = "admin";

        List<Problem> list = problemService.getProblems1(pid1, pid2, showhide, owner);
        return JsonMsg.success().addInfo(list);
    }

    /**
     * 根据题目名称查询一个范围内的题目
     */
    @RequestMapping("/GProblems2")
    @ResponseBody
    public JsonMsg getProblems2(HttpServletRequest req, HttpServletResponse resp){
        Integer from = 1300;
        Integer num =  1500;
        String search = "";
        List<Problem> list;
        if (search == null || search =="")
            list = problemService.getProblems2(from, num, search);
        else
            list = problemService.getProblems3(from, num, search);
        return JsonMsg.success().addInfo(list);
    }

    /**
     * 根据比赛id 查询一个比赛里的题目
     */


    /**
     * 查询题目页面数量,根据 num 的不同结果会有不同
     */
    @RequestMapping("/GPageNum")
    @ResponseBody
    public JsonMsg getPageNum(HttpServletRequest req, HttpServletResponse resp){

        Integer num = 20;
        boolean showHide = false;

        Integer total = problemService.getPageNum(num,showHide);
        return JsonMsg.success().addInfo(total);
    }

    /**
     * 编辑题目信息
     */
    @RequestMapping("/EProblem")
    @ResponseBody
    public JsonMsg editProblem(HttpServletRequest req, HttpServletResponse resp){
         Integer pid = 1;
         Problem pro = null;

         Integer num = problemService.editProblem(pid, pro);
         return JsonMsg.success().addInfo(num);
     }

    /**
     * 新增题目
     */
    @RequestMapping("/AProblem")
    @ResponseBody
    public JsonMsg addProblem(HttpServletRequest req, HttpServletResponse resp){
        Integer pid = 1;
        Problem pro = null;

        Integer num = problemService.addProblem(pid,pro);
        return JsonMsg.success().addInfo(num);
    }

    /**
     * 更改一个题目的可见状态
     */
    @RequestMapping("/UProblemVisiablePid")
    @ResponseBody
    public JsonMsg setProblemVisiablePid(HttpServletRequest req, HttpServletResponse resp){
        Integer pid = 1;
        Integer num = problemService.setProblemVisiablePid(pid);

        return JsonMsg.success().addInfo(num);
    }
    /**
     * 将一个题目的可见状态改为想要的状态用 z 表示
     */
    @RequestMapping("/UProblemVisiablePidZ")
    @ResponseBody
    public JsonMsg UProblemVisiablePidZ(HttpServletRequest req, HttpServletResponse resp){
        Integer pid = 1;
        Integer z   = 0;
        Integer num = problemService.setProblemVisiablePidZ(pid,z);

        return JsonMsg.success().addInfo(num);
    }

    /**
     * 获取某个oj 的一个题目
     */
    @RequestMapping("/GProblemsByOjPid")
    @ResponseBody
    public JsonMsg getProblemsByOjPid(HttpServletRequest req, HttpServletResponse resp){
        Integer oj = 1;
        String ojspid = "";

        List<Integer> list = problemService.getProblemsByOjPid(oj, ojspid);
        return JsonMsg.success().addInfo(list);
    }


}
