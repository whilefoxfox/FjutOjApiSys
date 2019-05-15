package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem;
import com.fjut.oj.pojo.Problems1;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    public static List<Problem> listProblems = null;
    /**
     * 查询所有的题目信息
     */
    @RequestMapping("/queryAllProblems")
    @ResponseBody
    public JsonMsg queryAllProblems(HttpServletRequest req, HttpServletResponse resp){
        List<Problem> list = problemService.queryAllProblems();
        resp.setHeader("Access-Control-Allow-Origin","*");
        if (list != null){
            return JsonMsg.success().addInfo(list);
        } else {
            return JsonMsg.fail().addInfo("未查询到题目信息");
        }
    }

    /**
     * 一页一页的查询题目信息
     */
    @RequestMapping("/GProblemsByPage")
    @ResponseBody
    public JsonMsg queryProblemsByPage(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");

        Integer pid1, pid2, pagenum, totalpagenum;
        pagenum = Integer.parseInt(req.getParameter("pagenum"));
        totalpagenum = problemService.getPageNum(50, false);
        if (pagenum < totalpagenum - 1)
        {
            pid1 = (pagenum - 1) * 50;
            pid2 = pid1 + 50;
        }
        else
        {
            pid1 = (pagenum - 1) * 50;
            pid2 = problemService.queryProblemsNum();
        }

        List<Problem> list = problemService.queryProblemsByPage(pid1, pid2);
        return JsonMsg.success().addInfo(totalpagenum - 1).addInfo(list);
    }

    /**
     *
     */

    /**
     * 查询一个范围内的杭电的题目
     */
    @RequestMapping("/GProblemsFromHDU")
    @ResponseBody
    public JsonMsg queryProblemsFromHDU(HttpServletRequest req, HttpServletResponse resp){
        Integer from = 50;
        Integer to   = 100;
        List<Problem> list = problemService.queryProblemsFromHDU(from, to);
        if (list.size() == 0){
            return JsonMsg.fail().addInfo("未查找到该范围的题目");
        } else {
            return JsonMsg.success().addInfo(list);
        }
    }

    /**
     * 通过题目 ID 查找题目信息
     */
    @RequestMapping(value = "/queryProblemById")
    @ResponseBody
    public JsonMsg queryProblemById(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");

        Integer pid = Integer.parseInt(req.getParameter("pid"));

        Problem problem = problemService.queryProblemById(pid);
        return JsonMsg.success().addInfo(problem);
    }

    /**
     * 通过题目 title 查找题目
     */
    @RequestMapping(value = "/GProblemByTitle")
    @ResponseBody
    public JsonMsg queryProblemByTitle(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String title = req.getParameter("title");
        Integer pagenum = Integer.parseInt(req.getParameter("pagenum") == null ? "0" : req.getParameter("pagenum"));
        Integer totalpagenum, totalproblem;

        if (title == null || title == "" || pagenum == 0)
            return JsonMsg.fail().addInfo("题目查找信息为空！");

        totalproblem = problemService.queryProblemsNumByTitle(title);
        if (totalproblem == 0)
        {
            totalpagenum = 1;
        }
        else
        {
            if (totalproblem % 50 == 0)
                totalpagenum = totalproblem / 50;
            else
                totalpagenum = totalproblem / 50 + 1;
        }

        Integer pid1 = (pagenum - 1) * 50;
        List<Problem> list = problemService.queryProblemByTitle(title, pid1);

        return JsonMsg.success().addInfo(totalpagenum).addInfo(list);
    }

    /**
     * 查询题目数量
     */
    @RequestMapping("/GProblemsNum")
    @ResponseBody
    public JsonMsg queryProblemsNum(HttpServletRequest req, HttpServletResponse resp){
        String search = "";
        Integer num = problemService.queryProblemsNum();
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

        List<Problems1> list = problemService.getProblems1(pid1, pid2, showhide, owner);
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
