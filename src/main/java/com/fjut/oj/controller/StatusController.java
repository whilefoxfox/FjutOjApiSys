package com.fjut.oj.controller;

import com.fjut.oj.pojo.Status;
import com.fjut.oj.pojo.UserSolve;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.service.UserSolveService;
import com.fjut.oj.util.JsonInfo;
import com.fjut.oj.util.JsonMsg;
import com.fjut.oj.util.MapSort;
import com.fjut.oj.util.ResultString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/**
 * TODO: 把 JsonMsg 替换为 JsonInfo
 */

@Controller
@CrossOrigin
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserSolveService userSolveService;

    static private List<Status> list;

    @RequestMapping("/GAllStatus")
    @ResponseBody
    public JsonInfo getAllStatus(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String pagenum_1 = req.getParameter("pagenum");
        int pagenum = Integer.parseInt(pagenum_1);
        System.out.println(pagenum);

        Integer num = statusService.allStatusNum();
        if (num == 0) {
            jsonInfo.setSuccess("数据为空");
        }
        int from = (pagenum - 1) * 50;
        int to = 233;
        List<Status> list_1 = statusService.queryStatus(from);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(num % 50 == 0 ? num / 50 : num / 50 + 1);
        jsonInfo.addInfo(list_1);
        return jsonInfo;
    }

    @RequestMapping("/GAllStatusByUsername")
    @ResponseBody
    public JsonInfo getAllStatusByUsername(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        Integer pid;
        String ruser, submitTime;
        String username = req.getParameter("username");
        Map<String, Integer> submitToal = new TreeMap<String, Integer>();
        Map<String, Integer> submitAc = new TreeMap<String, Integer>();
        Map<String, Integer> vis = new TreeMap<String, Integer>();
        UserSolve userSolve = null;
        if (null == username) {
            jsonInfo.setFail("无用户");
            return jsonInfo;
        }
        List<Status> list = statusService.getAllStatusByUsername(username);
        for (Status st : list) {
            submitTime = st.getSubmitTime().substring(0, 7);
            Integer num = submitToal.get(submitTime) == null ? 1 : submitToal.get(submitTime) + 1;
            submitToal.put(submitTime, num);
            if (st.getResult() == 1) {
                pid = st.getPid();
                ruser = st.getRuser();
                if (vis.get(ruser + "ABCDEFG" + pid) == null) {
                    vis.put(ruser + "ABCDEFG" + pid, 1);
                    Integer numAc = submitAc.get(submitTime) == null ? 1 : submitAc.get(submitTime) + 1;
                    submitAc.put(submitTime, numAc);
                }
            }

        }
        Map<String, Integer> totalMap = MapSort.sortMapByKey(submitToal);
        Map<String, Integer> acMap = MapSort.sortMapByKey(submitAc);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(totalMap);
        jsonInfo.addInfo(acMap);
        return jsonInfo;
    }

    @RequestMapping("/GStatusByConditions")
    @ResponseBody
    public JsonMsg queryAllStatusByConditions(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Integer pid, result, lang, start;
        Integer pagenum = Integer.parseInt(req.getParameter("pagenum") == null ? "1" : req.getParameter("pagenum"));
        String ruser = req.getParameter("ruser") == null ? "" : req.getParameter("ruser");
        String pidStr = req.getParameter("pid") == null ? "" : req.getParameter("pid");
        String resultStr = req.getParameter("result") == null ? "" : req.getParameter("result");
        String langStr = req.getParameter("lang") == null ? "" : req.getParameter("lang");
        start = (pagenum - 1) * 50;
        if (pidStr == "") {
            pid = null;
        } else {
            pid = Integer.parseInt(pidStr);
        }

        if (resultStr == "" || "All".equals(resultStr)) {
            result = null;
        } else {
            result = ResultString.getResultString(resultStr);
        }

        if (langStr == "" || "All".equals(langStr)) {
            lang = null;
        } else {
            lang = ResultString.getSubmitLanguage(langStr);
        }

        Integer totalStatus = statusService.queryCountAllStatusByConditions(ruser, pid, result, lang, start);
        Integer totalpage = totalStatus % 50 == 0 ? totalStatus / 50 : totalStatus / 50 + 1;
        List<Status> list = statusService.queryAllStatusByConditions(ruser, pid, result, lang, start);
        return JsonMsg.success().addInfo(totalpage).addInfo(list);
    }

    @RequestMapping("/GStatusCode")
    @ResponseBody
    public JsonMsg queryStatusCode(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String user = req.getParameter("user");
        Status status = statusService.queryStatusById(id);
        if (status == null) {
            return JsonMsg.fail().addInfo("评测信息不存在");
        }
        if (status.getRuser().equals(user)) {
            return JsonMsg.success().addInfo(status.getCode());
        }
        return JsonMsg.fail().addInfo("无法查看其他用户代码");
    }
}
