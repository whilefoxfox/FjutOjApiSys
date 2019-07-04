package com.fjut.oj.controller;

import com.fjut.oj.pojo.User;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.service.UserRadarService;
import com.fjut.oj.service.UserService;
import com.fjut.oj.util.JsonInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO: 设置登录成功后返回token，保存token信息来做登录认证
 */
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private UserRadarService userRadarService;

    /**
     * 判断用户名和密码是否正确
     *
     * @param req
     * @param resp
     * @return
     */
    @PostMapping(value = "/dologin")
    @ResponseBody
    public JsonInfo dologin(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.getUserByUsername(username);
        Integer count = userService.getUserByUsernameAndPassword(username, password);
        if (null == user) {
            // 用户名不存在
            jsonInfo.setFail("用户名不存在");

        } else if (count == 0) {
            // 用户名和密码不匹配
            jsonInfo.setFail("用户名或密码不匹配");
        } else {
            // 用户名和密码匹配
            jsonInfo.setSuccess("用户名和密码正确");
            jsonInfo.addInfo(user);
        }
        return jsonInfo;
    }

    /**
     * 注册一个用户
     */
    @RequestMapping("/insertUser")
    @ResponseBody

    public JsonInfo insertUser(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        User tmp = userService.getUserByUsername(req.getParameter("username"));
        if (tmp != null) {
            jsonInfo.setFail("用户名已经存在");
            return jsonInfo;
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
        user.setInTeamStatus(Integer.parseInt(req.getParameter("inTeamStatus") == null ? "0" : req.getParameter("inTeamStatus")));
        user.setInTeamLv(Integer.parseInt(req.getParameter("inTeamLv") == null ? "0" : req.getParameter("inTeamLv")));
        user.setRank(Integer.parseInt(req.getParameter("rank") == null ? "2223" : req.getParameter("rank")));
        // Date graduationTime = new Date();
        user.setGraduationTime(req.getParameter("graduationTime") == null ? "2022-07-01 00:00:00" : req.getParameter("graduationTime"));

        boolean flag = userService.insertUser(user);
        if (flag) {
            jsonInfo.setSuccess("添加用户成功！");
        } else {
            jsonInfo.setFail("添加用户失败！");
        }
        return jsonInfo;
    }

    /**
     * 修改用户信息
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public JsonInfo updateUser(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        User tmp = userService.getUserByUsername(req.getParameter("username"));
        if (tmp == null) {
            jsonInfo.setFail("用户名不存在！");
            return jsonInfo;
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
        tmp.setInTeamStatus(Integer.parseInt(req.getParameter("inTeamStatus") == null ? tmp.getInTeamStatus().toString() : req.getParameter("inTeamStatus")));
        tmp.setInTeamLv(Integer.parseInt(req.getParameter("inTeamLv") == null ? tmp.getInTeamLv().toString() : req.getParameter("inTeamLv")));
        tmp.setRank(Integer.parseInt(req.getParameter("rank") == null ? tmp.getRank().toString() : req.getParameter("rank")));
        tmp.setGraduationTime(req.getParameter("graduationTime") == null ? tmp.getGraduationTime() : req.getParameter("graduationTime"));

        Integer num = userService.updateUserByUsername(tmp);
        if (1 == num) {
            jsonInfo.setSuccess("修改用户信息成功！");

        } else {
            jsonInfo.setFail("修改用户信息失败！");
        }
        return jsonInfo;
    }

    /**
     * 获取所有的用户信息
     * FIXME: 部署时需要去除
     */
    @RequestMapping("/GAllUsers")
    @ResponseBody
    public JsonInfo queryAllUsers(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        List<User> list = userService.queryAll();
        jsonInfo.addInfo(list);
        return jsonInfo;
    }

    /**
     * 获取用户的雷达图
     */
    @RequestMapping("/GUserRadar")
    @ResponseBody
    public JsonInfo getUserRadar(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        String userRadar = "";
        userRadar = userRadarService.getUserRadar(username);
        jsonInfo.addInfo(userRadar);
        return jsonInfo;
    }

    /**
     * 获取一个用户提交所有题目的次数
     */
    @RequestMapping("/GSubmitCount")
    @ResponseBody
    public JsonInfo querySubmitCountByUsername(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        Integer num = statusService.querySubmitCountByUsername(username);
        if (null != num) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(num);
        } else {
            jsonInfo.setFail("未查询到该用户的提交信息！");
        }
        return jsonInfo;
    }

    /**
     * 获取一个用户个人信息界面的信息
     */
    @RequestMapping("/GUserInfo")
    @ResponseBody
    public JsonInfo queryUserInfoByUsername(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        User user = userService.getUserByUsername(username);

        if (null != user) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(user);
        } else {
            jsonInfo.setFail("未查询到该用户的信息！");
        }
        return jsonInfo;
    }

    /**
     * 获取一个用户贴过题目标签的数量
     */
    @RequestMapping("/GPutTagNum")
    @ResponseBody
    public JsonInfo queryPutTagNumByUsername(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        Integer num = userService.queryPutTagNumByUsername(username);
        if (num != 0) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(num);
        }
        else{
            jsonInfo.setFail("未找到用户贴标签的信息");
        }
        return jsonInfo;
    }

    /**
     * 获取一个用户已经 AC 和未解决 题目的数量
     */
    @RequestMapping("/GStatusProblems")
    @ResponseBody
    public JsonInfo queryStatusProblemsByUsername(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        Integer status = Integer.parseInt(req.getParameter("status") == null ? "0" : req.getParameter("status"));
        String username = req.getParameter("username");
        List<Integer> list = userService.queryStatusProblemsByUsername(status, username);
        if (list != null) {
            jsonInfo.addInfo(list);
            jsonInfo.setSuccess();
        }else{
            jsonInfo.setFail("未查询到用户相关的题目信息");
        }
        return jsonInfo;
    }

    /**
     * 查询一个用户待贴标签的题目
     */
    @RequestMapping("/GNotPutTagProblems")
    @ResponseBody
    public JsonInfo queryCanViewCodeProblemsByUsername(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        List<Integer> list = userService.queryNotPutTagProblemsByUsername(username);
        jsonInfo.addInfo(list);
        jsonInfo.setSuccess();
        return jsonInfo;
    }

    /**
     * 查询一个用户所有的权限
     */
    @RequestMapping("/GUserPermission")
    @ResponseBody
    public JsonInfo queryUserPermission(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        List<Integer> list = userService.queryUserPermission(username);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(list);
        return jsonInfo;
    }

    @RequestMapping(value = "/awardinfo", method = RequestMethod.POST)
    @ResponseBody
    public JsonInfo getAwardinfo(HttpServletResponse response, HttpServletRequest request) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        List<String> list = userService.queryAwardInfo(username);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(list);
        return jsonInfo;
    }

    @RequestMapping(value = "/GRatingGraph")
    @ResponseBody
    public JsonInfo getRatingGraph(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        Map<String, Integer> list = (Map<String, Integer>) userService.getRatingGraph(username);
        if (null != list) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(list);
        }
        else{
            jsonInfo.setFail("未查询到该用户的信息");
        }
        return jsonInfo;
    }

    @RequestMapping(value = "/GAcGraph")
    @ResponseBody
    public JsonInfo getAcGraph(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo =new JsonInfo();
        String username = request.getParameter("username");
        List<Object> list = (List<Object>) userService.getAcGraph(username);
        if (null != list) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(list);
        }
        else{
            jsonInfo.setFail("未查询到该用户的信息");
        }
        return jsonInfo;
    }
}
