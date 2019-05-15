package com.fjut.oj.controller;

import com.fjut.oj.service.PermissionService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping(value = "/Gpermission", produces="application/json")
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        resp.setHeader("Access-Control-Allow-Origin","*");
        List<String> list = permissionService.getUserPermission("admin");
        return JsonMsg.success().addInfo(list);
    }
}