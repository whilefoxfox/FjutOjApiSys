package com.fjut.oj.controller;

import com.fjut.oj.service.PermissionService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/GUserPermission", produces="application/json")
    @ResponseBody
    public JsonMsg dologin(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username") == null ? "" : req.getParameter("username");
        resp.setHeader("Access-Control-Allow-Origin","*");

        //List<String> list = permissionService.getUserPermission("admin");
        if ("cjt152".equals(username) || "admin".equals(username)) {
            return JsonMsg.success().addInfo(true);
        }
        return JsonMsg.fail().addInfo(false);
    }
}