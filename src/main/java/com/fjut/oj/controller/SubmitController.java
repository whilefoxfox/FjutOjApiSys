package com.fjut.oj.controller;

import com.fjut.oj.judge.util.Vjudge.Submitter;
import com.fjut.oj.judge.util.Vjudge.SubmitterImp;
import com.fjut.oj.pojo.Contest;
import com.fjut.oj.pojo.Contestuser;
import com.fjut.oj.pojo.UserSolve;
import com.fjut.oj.service.ContestService;
import com.fjut.oj.service.ProblemService;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.service.UserSolveService;
import com.fjut.oj.util.JsonMsg;
import com.fjut.oj.util.ResultString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * TODO: 把 JsonMsg 替换为 JsonInfo
 */
@RequestMapping("/submit")
@Controller
@CrossOrigin
public class SubmitController {

    @Autowired
    private StatusService statusService;
    @Autowired
    private ProblemService problemService;
    @Autowired
    private UserSolveService userSolveService;
    @Autowired
    private ContestService contestService;

    Submitter sm = new SubmitterImp();

    @RequestMapping("/submitProblem")
    @ResponseBody
    public JsonMsg submitProblem(HttpServletRequest req, HttpServletResponse resp){
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

        if (cid != -1) {
            Contest contest = contestService.getContestById(cid);
            if (contest == null) {
                return JsonMsg.fail().addInfo("没有查找到该比赛");
            }
            String endTime = contest.getEndTime();

            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);

            if (endTime.compareTo(dateString) < 0) {
                return JsonMsg.fail().addInfo("比赛已经结束，提交失败");
            }

            Integer userNum = contestService.getContestUser(cid, user);
            if (userNum == 0) {
                // 用户之前没有提交过题目，添加该用户
                Contestuser contestuser = new Contestuser();
                contestuser.setTime(dateString);
                contestuser.setCid(cid);
                contestuser.setUsername(user);
                contestuser.setInfo("");
                contestuser.setStatu(1);
                contestService.insertContestuser(contestuser);
            }
        }

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
