package com.fjut.oj.controller;

import com.fjut.oj.pojo.Mall;
import com.fjut.oj.service.MallService;
import com.fjut.oj.util.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: axiang [2019/7/17]
 */
@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/mall")
public class MallController {
    @Autowired
    MallService mallService;

    @GetMapping("/getMall")
    public JsonInfo queryMallGoods(){
        JsonInfo jsonInfo = new JsonInfo();
        List<Mall> malls = mallService.queryAllMallGoods();
        if(0 < malls.size())
        {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(malls);
        }
        else
        {
            jsonInfo.setFail("未找到商品");
        }
        return jsonInfo;

    }
}
