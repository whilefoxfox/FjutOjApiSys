package com.fjut.oj.controller;

import com.fjut.oj.pojo.Ceinfo;
import com.fjut.oj.service.CeinfoService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin
@RequestMapping("/ceinfo")
public class CeinfoController {

    @Autowired
    private CeinfoService ceinfoService;

    @RequestMapping("/GCeinfo")
    @ResponseBody
    public JsonMsg queryCeinfo(HttpServletRequest req, HttpServletResponse resp){
        String ridStr = req.getParameter("rid");
        if (ridStr == null || ridStr == ""){
            return JsonMsg.fail().addInfo("未填入rid");
        }
        Integer rid = Integer.parseInt(ridStr);
        Ceinfo ceinfo = ceinfoService.queryCeinfo(rid);

        return JsonMsg.success().addInfo(ceinfo);
    }
}
