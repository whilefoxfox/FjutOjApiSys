package com.fjut.oj.controller;

import com.fjut.oj.pojo.User;
import com.fjut.oj.service.StatusService;
import com.fjut.oj.service.UserService;
import com.fjut.oj.service.UserRadarService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        resp.setHeader("Access-Control-Allow-Origin","*");
        if (user == null){
            // 用户名不存在
            System.out.println("用户名不存在");
            return JsonMsg.fail().addInfo("用户不存在");
        } else if (password.equals(user.getPassword()) == false) {
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

        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));

        boolean flag = userService.insertUser(user);
        if (flag){
            return JsonMsg.success().addInfo(user);
        }
        return JsonMsg.fail().addInfo("添加用户信息失败！");
    }

    /**
     * 获取所有的用户信息
     */
    @RequestMapping("/GAllUsers")
    @ResponseBody
    public JsonMsg queryAllUsers(){
        List<User> list = userService.queryAll();
        if (list != null){
            return JsonMsg.success().addInfo(list);
        }
        return JsonMsg.fail().addInfo("查找用户信息失败！");
    }

    /**
     * 获取用户的雷达图
     */
    @RequestMapping("/GUserRadar")
    @ResponseBody
    public JsonMsg getUserRadar(HttpServletRequest request,HttpServletResponse response){

        String username = request.getParameter("username");
        username = "cjt152";
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
    public JsonMsg querySubmitCountByUsername(HttpServletRequest request,HttpServletResponse response){

        String username = request.getParameter("username");
        username = "cjt152";
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
    public JsonMsg queryUserInfoByUsername(HttpServletRequest request,HttpServletResponse response){

        String username = request.getParameter("username");
        username = "cjt152";

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
    public JsonMsg queryPutTagNumByUsername(HttpServletRequest request,HttpServletResponse response){

        String username = request.getParameter("username");
        username = "cjt152";

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
    public JsonMsg queryStatusProblemsByUsername(HttpServletRequest request,HttpServletResponse response){
        //Integer status = Integer.parseInt(request.getParameter("status"));
        //String  username = request.getParameter("username");

        Integer status = 0;
        String username = "cjt152";

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
    public JsonMsg queryCanViewCodeProblemsByUsername(HttpServletRequest request,HttpServletResponse response){

        String username = "cjt152";
        List<Integer> list = userService.queryNotPutTagProblemsByUsername(username);
        return JsonMsg.success().addInfo(list);
    }

    /**
     * 查询一个用户所有的权限
     */
    @RequestMapping("/GUserPermission")
    @ResponseBody
    public JsonMsg queryUserPermission(HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        username = "cjt152";

        List<Integer> list = userService.queryUserPermission(username);
        return JsonMsg.success().addInfo(list);
    }
}
