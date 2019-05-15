package com.fjut.oj.controller;

import com.fjut.oj.judge.util.Vjudge.Submitter;
import com.fjut.oj.judge.util.Vjudge.SubmitterImp;
import com.fjut.oj.pojo.UserSolve;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.service.UserSolveService;
import com.fjut.oj.util.JsonMsg;
import com.fjut.oj.util.ResultString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@RequestMapping("/submit")
@Controller
public class SubmitController {

    @Autowired
    private StatusService statusService;
    @Autowired
    private ProblemService problemService;
    @Autowired
    private UserSolveService userSolveService;

    @RequestMapping("/submitProblem")
    @ResponseBody
    public JsonMsg submitProblem(HttpServletRequest req, HttpServletResponse resp){
        Submitter sm = new SubmitterImp();
        resp.setHeader("Access-Control-Allow-Origin","*");
        String strpid = req.getParameter("pid");
        if (strpid == null || strpid == "") {
            return JsonMsg.fail().addInfo("pid未传入");
        }

        String user = req.getParameter("user");
        if (user == null || user == ""){
            return JsonMsg.fail().addInfo("user未传入");
        }

        String code = req.getParameter("code");
        if (code == null || code == ""){
            return JsonMsg.fail().addInfo("code未传入");
        }

        /**
         * test
         */
        // code = "#include<stdio.h>\nint main(){int a,b;while(~scanf(\"%d%d\",&a,&b))printf(\"%d\\n\",a+b);}";

        Integer pid = Integer.parseInt(strpid);
        Integer cid = Integer.parseInt(req.getParameter("cid") == null ? "-1" : req.getParameter("cid"));

        String language = req.getParameter("language") == null ? "G++" : req.getParameter("language");
        Integer langid = ResultString.getSubmitLanguage(language);
        System.out.println(pid + " " + cid + " " + language + " " + langid + user + code);


        Timestamp submittime = new Timestamp(System.currentTimeMillis());
        Integer maxpid = statusService.queryMaxStatusId();
        Integer newpid = maxpid == null ? 1 : maxpid + 1;

        sm.doSubmit(user, pid, cid, langid, code, submittime);
        problemService.updateProblemtotalSubmit(pid);
        UserSolve userSolve = userSolveService.queryByUsernameAndPid(user,pid);
        if (userSolve == null){
            // 该用户没有交过这道题目
            problemService.updateProblemtotalSubmitUser(pid);
        }

        return JsonMsg.success();
    }
}
