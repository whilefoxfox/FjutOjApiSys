package com.fjut.oj.controller;

import com.fjut.oj.util.JsonInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
