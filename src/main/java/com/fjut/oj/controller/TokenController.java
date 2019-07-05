package com.fjut.oj.controller;

import com.fjut.oj.pojo.TokenModel;
import com.fjut.oj.pojo.User;
import com.fjut.oj.service.UserService;
import com.fjut.oj.token.manager.TokenManager;
import com.fjut.oj.util.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: wyx
 * @Despriction:
 * @Date:Created in 10:03 2019/7/5
 * @Modify By:
 */
@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/token")
public class TokenController {
    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JsonInfo login(@RequestParam("username") String username,@RequestParam("password") String password){
        JsonInfo jsonInfo = new JsonInfo();
//        System.out.println(username);
//        System.out.println(password);
        if(null == username || null == password)
        {
            jsonInfo.setFail("用户名或者密码为空！");
            return jsonInfo;
        }
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
            TokenModel tokenModel = tokenManager.createToken(username);
            jsonInfo.addInfo(tokenModel);
        }
        return jsonInfo;

    }
}
