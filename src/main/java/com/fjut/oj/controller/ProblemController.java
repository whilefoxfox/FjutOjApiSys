package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem;
import com.fjut.oj.pojo.Problems1;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.util.JsonInfo;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * TODO: 把 JsonMsg 替换为 JsonInfo
 *
 * @author axiang [20190707]
 */
@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;


    /**
     * 一页一页的查询题目信息
     */
    @GetMapping("/getProblems")
    public JsonInfo queryProblemsByPage(@RequestParam("pagenum") String pageNumStr) {
        JsonInfo jsonInfo = new JsonInfo();
        Integer pid1, pid2, pageNum, totalPageNum;
        pageNum = Integer.parseInt(null == pageNumStr ? "1" : pageNumStr);
        Integer total = problemService.queryProblemsNum();
        totalPageNum = (total % 50 == 0) ? total / 50 : total / 50 + 1;
        pid1 = (pageNum - 1) * 50;
        pid2 = pid1 + 50;
        List<Problem> list = problemService.queryProblemsByPage(pid1, pid2);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(totalPageNum);
        jsonInfo.addInfo(list);
        return jsonInfo;
    }

    /**
     * 查询一个范围内的杭电的题目
     */
    @GetMapping("/getProblemsFromHDU")
    public JsonMsg queryProblemsFromHDU() {
        Integer from = 50;
        Integer to = 100;
        List<Problem> list = problemService.queryProblemsFromHDU(from, to);
        if (list.size() == 0) {
            return JsonMsg.fail().addInfo("未查找到该范围的题目");
        } else {
            return JsonMsg.success().addInfo(list);
        }
    }

    /**
     * 通过题目 ID 查找题目信息
     */
    @GetMapping("/getProblemById")
    public JsonMsg queryProblemById(@RequestParam("pid") String pidStr) {
        Integer pid = Integer.parseInt(pidStr);
        Problem problem = problemService.queryProblemById(pid);
        if (problem != null) {
            return JsonMsg.success().addInfo(problem);
        }
        return JsonMsg.fail().addInfo("未查找到该题目！");
    }

    /**
     * 通过题目 title 查找题目
     */
    @GetMapping("/getProblemByTitle")
    public JsonInfo queryProblemByTitle(@RequestParam("title") String title,
                                        @RequestParam("pagenum") String pageNumStr) {
        JsonInfo jsonInfo = new JsonInfo();
        Integer pageNum = Integer.parseInt(pageNumStr == null ? "0" : pageNumStr);
        Integer totalPageNum, totalProblem;

        totalProblem = problemService.queryProblemsNumByTitle(title);
        if (totalProblem == 0) {
            totalPageNum = 1;
        } else {
            if (totalProblem % 50 == 0) {
                totalPageNum = totalProblem / 50;
            } else {
                totalPageNum = totalProblem / 50 + 1;
            }
        }
        Integer pid1 = (pageNum - 1) * 50;
        List<Problem> list = problemService.queryProblemByTitle(title, pid1);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(totalPageNum);
        jsonInfo.addInfo(list);
        return jsonInfo;
    }

    /**
     * 查询题目数量
     */
    @GetMapping("/getProblemsNum")
    public JsonInfo queryProblemsNum() {
        JsonInfo jsonInfo = new JsonInfo();
        Integer num = problemService.queryProblemsNum();
        jsonInfo.addInfo(num);
        return jsonInfo;
    }


    /**
     * 查询一个范围题目号范围内的题目 并可以选择是否查询隐藏题目和拥有者
     */
    @GetMapping("/GProblems1")
    public JsonMsg getProblems1(HttpServletRequest req, HttpServletResponse resp) {
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
    @GetMapping("/GProblems2")
    public JsonMsg getProblems2(HttpServletRequest req, HttpServletResponse resp) {
        Integer from = 1300;
        Integer num = 1500;
        String search = "";
        List<Problem> list;
        if (search == null || search == "") {
            list = problemService.getProblems2(from, num, search);
        } else {
            list = problemService.getProblems3(from, num, search);
        }
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
    public JsonMsg getPageNum(HttpServletRequest req, HttpServletResponse resp) {

        Integer num = 20;
        boolean showHide = false;

        Integer total = problemService.getPageNum(num, showHide);
        return JsonMsg.success().addInfo(total);
    }

    /**
     * 编辑题目信息
     */
    @RequestMapping("/EProblem")
    @ResponseBody
    public JsonMsg editProblem(HttpServletRequest req, HttpServletResponse resp) {
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
    public JsonMsg addProblem(HttpServletRequest req, HttpServletResponse resp) {
        Integer pid = 1;
        Problem pro = null;

        Integer num = problemService.addProblem(pid, pro);
        return JsonMsg.success().addInfo(num);
    }

    /**
     * 更改一个题目的可见状态
     */
    @RequestMapping("/UProblemVisiablePid")
    @ResponseBody
    public JsonMsg setProblemVisiablePid(HttpServletRequest req, HttpServletResponse resp) {
        Integer pid = 1;
        Integer num = problemService.setProblemVisiablePid(pid);

        return JsonMsg.success().addInfo(num);
    }

    /**
     * 将一个题目的可见状态改为想要的状态用 z 表示
     */
    @RequestMapping("/UProblemVisiablePidZ")
    @ResponseBody
    public JsonMsg UProblemVisiablePidZ(HttpServletRequest req, HttpServletResponse resp) {
        Integer pid = 1;
        Integer z = 0;
        Integer num = problemService.setProblemVisiablePidZ(pid, z);

        return JsonMsg.success().addInfo(num);
    }

    /**
     * 获取某个oj 的一个题目
     */
    @RequestMapping("/GProblemsByOjPid")
    @ResponseBody
    public JsonMsg getProblemsByOjPid(HttpServletRequest req, HttpServletResponse resp) {
        Integer oj = 1;
        String ojspid = "";

        List<Integer> list = problemService.getProblemsByOjPid(oj, ojspid);
        return JsonMsg.success().addInfo(list);
    }
}
