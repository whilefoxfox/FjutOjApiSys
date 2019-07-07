package com.fjut.oj.controller;

import com.fjut.oj.token.interceptor.CheckUserLogin;
import com.fjut.oj.util.JsonInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: axiang [20190704] 测试swagger2的测试控制器
 */
@RequestMapping("/test")
@ResponseBody
@Controller
@Api(value = "测试接口")
public class TestController {
    @RequestMapping("/gettest")
    @ApiOperation(value = "获取值")
    public JsonInfo get(int id){
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setSuccess("hhh");
        return jsonInfo;
    }


    @CheckUserLogin
    @GetMapping("/getsome")
    public JsonInfo getsome(@RequestParam("id")Integer id, @RequestParam("token")String token){
        JsonInfo jsonInfo = new JsonInfo();
        jsonInfo.setSuccess();
        return jsonInfo;

    }
}
