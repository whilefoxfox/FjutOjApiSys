package com.fjut.oj.controller;

import com.fjut.oj.pojo.Status;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.util.JsonMsg;
import com.fjut.oj.util.ResultString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/status")
@Controller
public class StatusController {
    @Autowired
    private StatusService statusService;
    static private List<Status> list;

    @RequestMapping("/GAllStatus")
    @ResponseBody
    public JsonMsg getAllStatus(HttpServletRequest req, HttpServletResponse resp){
        String pagenum_1 = req.getParameter("pagenum");
        int pagenum = Integer.parseInt(pagenum_1);
        System.out.println(pagenum);
        resp.setHeader("Access-Control-Allow-Origin","*");

        Integer num = statusService.allStatusNum();

        if (num == 0) return JsonMsg.success().addInfo("数据为空");
        System.out.println( num + " "  + (num % 50 == 0 ? num / 50 : num / 50 + 1));
        int from = (pagenum - 1) * 50;
        int to = 233;

        List<Status> list_1 = statusService.queryStatus(from);
        return JsonMsg.success().addInfo(num % 50 == 0 ? num / 50 : num / 50 + 1).addInfo(list_1);
    }

    @RequestMapping("/GStatusByConditions")
    @ResponseBody
    public JsonMsg queryAllStatusByConditions(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        Integer pid,result,lang,start;
        Integer pagenum = Integer.parseInt(req.getParameter("pagenum") == null ? "1" : req.getParameter("pagenum"));
        String ruser = req.getParameter("ruser") == null ? "" : req.getParameter("ruser");
        String pidStr = req.getParameter("pid") == null ? "" : req.getParameter("pid");
        String resultStr = req.getParameter("result") == null ? "" : req.getParameter("result");
        String langStr = req.getParameter("lang") == null ? "" : req.getParameter("lang");
        start = (pagenum - 1) * 50;
        if (pidStr == "")
        {
            pid = null;
        }
        else
        {
            pid= Integer.parseInt(pidStr);
        }

        if (resultStr == "" || "All".equals(resultStr))
        {
            result = null;
        }
        else
        {
            result = ResultString.getResultString(resultStr);
        }

        if (langStr == "" || "All".equals(langStr))
        {
            lang = null;
        }
        else
        {
            lang = ResultString.getSubmitLanguage(langStr);
        }

        Integer totalStatus = statusService.queryCountAllStatusByConditions(ruser,pid,result,lang,start);
        Integer totalpage = totalStatus % 50 == 0 ? totalStatus / 50 : totalStatus / 50 + 1;
        List<Status> list = statusService.queryAllStatusByConditions(ruser,pid,result,lang,start);
        return JsonMsg.success().addInfo(totalpage).addInfo(list);
    }
}
