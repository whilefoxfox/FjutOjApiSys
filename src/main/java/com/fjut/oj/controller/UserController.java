package com.fjut.oj.controller;

import com.fjut.oj.pojo.User;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.service.UserRadarService;
import com.fjut.oj.service.UserService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserRadarService userRadarService;

    // 登录，跳转到登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    // 获取用户名和密码判断是否匹配
    @PostMapping(value = "/dologin",produces="application/json")
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username + " " + password);
        User user = userService.getUserByUsername(username);
        Integer count = userService.getUserByUsernameAndPassword(username, password);
        resp.setHeader("Access-Control-Allow-Origin","*");
        if (user == null){
            // 用户名不存在
            System.out.println("用户名不存在");
            return JsonMsg.fail().addInfo("用户不存在");
        } else if (count == 0) {
            // 用户名和密码不匹配
            System.out.println("用户名和密码不匹配");
            return JsonMsg.fail().addInfo("用户名或密码不正确");
        } else{
            // 用户名和密码匹配
            return JsonMsg.success().addInfo(user);
        }
    }

    /**
     * 注册一个用户
     */
    @RequestMapping("/insertUser")
    @ResponseBody
    public JsonMsg insertUser(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin","*");
        String temp;
        User tmp = userService.getUserByUsername(req.getParameter("username"));
        if (tmp != null){
            return JsonMsg.fail().addInfo("用户名已经存在！");
        }
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setNick(req.getParameter("nick") == null ? " " : req.getParameter("nick"));
        user.setGender(Integer.parseInt(req.getParameter("gender") == null ? "0" : req.getParameter("gender")));
        user.setSchool(req.getParameter("school") == null ? " " : req.getParameter("school"));
        user.setEmail(req.getParameter("Email") == null ? " " : req.getParameter("Email"));
        user.setMotto(req.getParameter("motto") == null ? " " : req.getParameter("motto"));

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        user.setRegistertime(dateString);

        user.setType(Integer.parseInt(req.getParameter("type") == null ? "0" : req.getParameter("type")));
        user.setMark(req.getParameter("Mark") == null ? " " : req.getParameter("Mark"));
        user.setRating(-100000);
        user.setRatingnum(0);
        user.setAcb(0);
        user.setName(req.getParameter("name") == null ? " " : req.getParameter("name"));
        user.setFaculty(req.getParameter("faculty") == null ? " " : req.getParameter("faculty"));
        user.setMajor(req.getParameter("major") == null ? " " : req.getParameter("major"));
        user.setCla(req.getParameter("cla") == null ? " " : req.getParameter("cla"));
        user.setNo(req.getParameter("no") == null ? " " : req.getParameter("no"));
        user.setPhone(req.getParameter("phone") == null ? " " : req.getParameter("phone"));
        user.setAcnum(0);
        user.setInTeamStatus(Integer.parseInt(req.getParameter("inTeamStatus") == null ? "0" : req.getParameter("inTeamStatus")) );
        user.setInTeamLv(Integer.parseInt(req.getParameter("inTeamLv") == null ? "0" : req.getParameter("inTeamLv") ));
        user.setRank(Integer.parseInt(req.getParameter("rank") == null ? "2223" : req.getParameter("rank")));
        // Date graduationTime = new Date();
        user.setGraduationTime(req.getParameter("graduationTime") == null ? "2022-07-01 00:00:00" : req.getParameter("graduationTime"));

        boolean flag = userService.insertUser(user);
        if (flag){
            return JsonMsg.success().addInfo(user);
        }
        return JsonMsg.fail().addInfo("添加用户信息失败！");
    }

    /**
     * 修改用户信息
     *
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public JsonMsg updateUser(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin","*");
        User tmp = userService.getUserByUsername(req.getParameter("username"));
        if (tmp == null){
            return JsonMsg.fail().addInfo("用户名不存在！");
        }
        tmp.setPassword(req.getParameter("password") == null ? tmp.getPassword() : req.getParameter("password"));
        tmp.setNick(req.getParameter("nick") == null ? tmp.getNick() : req.getParameter("nick"));
        tmp.setGender(Integer.parseInt(req.getParameter("gender") == null ? tmp.getGender().toString() : req.getParameter("gender")));
        tmp.setSchool(req.getParameter("school") == null ? tmp.getSchool() : req.getParameter("school"));
        tmp.setEmail(req.getParameter("Email") == null ? tmp.getEmail() : req.getParameter("Email"));
        tmp.setMotto(req.getParameter("motto") == null ? tmp.getMotto() : req.getParameter("motto"));
        tmp.setType(Integer.parseInt(req.getParameter("type") == null ? tmp.getType().toString() : req.getParameter("type")));
        tmp.setMark(req.getParameter("Mark") == null ? tmp.getMark() : req.getParameter("Mark"));

        tmp.setRating(Integer.parseInt(req.getParameter("rating") == null ? tmp.getRating().toString() : req.getParameter("rating")));
        tmp.setRatingnum(Integer.parseInt(req.getParameter("ratingnum") == null ? tmp.getRatingnum().toString() : req.getParameter("ratingnum")));
        tmp.setAcb(Integer.parseInt(req.getParameter("acb") == null ? tmp.getAcb().toString() : req.getParameter("acb")));

        tmp.setName(req.getParameter("name") == null ? tmp.getName() : req.getParameter("name"));
        tmp.setFaculty(req.getParameter("faculty") == null ? tmp.getFaculty() : req.getParameter("faculty"));
        tmp.setMajor(req.getParameter("major") == null ? tmp.getMajor() : req.getParameter("major"));
        tmp.setCla(req.getParameter("cla") == null ? tmp.getCla() : req.getParameter("cla"));
        tmp.setNo(req.getParameter("no") == null ? tmp.getNo() : req.getParameter("no"));
        tmp.setPhone(req.getParameter("phone") == null ? tmp.getPhone() : req.getParameter("phone"));
        tmp.setInTeamStatus(Integer.parseInt(req.getParameter("inTeamStatus") == null ? tmp.getInTeamStatus().toString() : req.getParameter("inTeamStatus")) );
        tmp.setInTeamLv(Integer.parseInt(req.getParameter("inTeamLv") == null ? tmp.getInTeamLv().toString() : req.getParameter("inTeamLv") ));
        tmp.setRank(Integer.parseInt(req.getParameter("rank") == null ? tmp.getRank().toString(): req.getParameter("rank")));
        tmp.setGraduationTime(req.getParameter("graduationTime") == null ? tmp.getGraduationTime(): req.getParameter("graduationTime"));

        System.out.println(tmp.toString());
        Integer num = userService.updateUserByUsername(tmp);
        if (num == 1)
        {
            return JsonMsg.success().addInfo("修改用户信息成功！");
        }
        return JsonMsg.fail().addInfo("修改用户信息失败！");
    }

        /**
         * 获取所有的用户信息
         */
    @RequestMapping("/GAllUsers")
    @ResponseBody
    public JsonMsg queryAllUsers(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        List<User> list = userService.queryAll();
        return JsonMsg.success().addInfo(list);
    }

    /**
     * 获取用户的雷达图
     */
    @RequestMapping("/GUserRadar")
    @ResponseBody
    public JsonMsg getUserRadar(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String username = req.getParameter("username");
        String userRadar = "";
        userRadar = userRadarService.getUserRadar(username);
        System.out.println("userRadar" + userRadar);
        return JsonMsg.success().addInfo(userRadar);
    }

    /**
     *  获取一个用户提交所有题目的次数
     */
    @RequestMapping("/GSubmitCount")
    @ResponseBody
    public JsonMsg querySubmitCountByUsername(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String username = req.getParameter("username");
        Integer num = statusService.querySubmitCountByUsername(username);
        if (num != null){
            return JsonMsg.success().addInfo(num);
        }
        return JsonMsg.fail().addInfo("未查询到该用户的提交信息！");
    }

    /**
     * 获取一个用户个人信息界面的信息
     */
    @RequestMapping("/GUserInfo")
    @ResponseBody
    public JsonMsg queryUserInfoByUsername(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String username = req.getParameter("username");
        User user = userService.getUserByUsername(username);

        if (user != null){
            return JsonMsg.success().addInfo(user);
        }
        return JsonMsg.fail().addInfo("未查询到该用户的信息！");
    }

    /**
     * 获取一个用户贴过题目标签的数量
     */
    @RequestMapping("/GPutTagNum")
    @ResponseBody
    public JsonMsg queryPutTagNumByUsername(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String username = req.getParameter("username");
        Integer num = userService.queryPutTagNumByUsername(username);

        if (num != null){
            return JsonMsg.success().addInfo(num);
        }
        return JsonMsg.fail().addInfo("未查找到用户贴标签的信息！");
    }

    /**
     * 获取一个用户已经 AC 和未解决 题目的数量
     */
    @RequestMapping("/GStatusProblems")
    @ResponseBody
    public JsonMsg queryStatusProblemsByUsername(HttpServletRequest req, HttpServletResponse resp){
        Integer status = Integer.parseInt(req.getParameter("status") == null ? "0" : req.getParameter("status"));
        String  username = req.getParameter("username");
        List<Integer> list = userService.queryStatusProblemsByUsername(status, username);
        if (list != null){
            return JsonMsg.success().addInfo(list);
        }
        return JsonMsg.fail().addInfo("未查找到用户相关题目的信息！");
    }

    /**
     * 查询一个用户待贴标签的题目
     */
    @RequestMapping("/GNotPutTagProblems")
    @ResponseBody
    public JsonMsg queryCanViewCodeProblemsByUsername(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String username = req.getParameter("username");
        List<Integer> list = userService.queryNotPutTagProblemsByUsername(username);
        return JsonMsg.success().addInfo(list);
    }

    /**
     * 查询一个用户所有的权限
     */
    @RequestMapping("/GUserPermission")
    @ResponseBody
    public JsonMsg queryUserPermission(HttpServletRequest req, HttpServletResponse resp){
        resp.setHeader("Access-Control-Allow-Origin","*");
        String username = req.getParameter("username");

        List<Integer> list = userService.queryUserPermission(username);
        return JsonMsg.success().addInfo(list);
    }
}
