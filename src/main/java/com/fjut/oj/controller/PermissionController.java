package com.fjut.oj.controller;

import com.fjut.oj.pojo.UserPer;
import com.fjut.oj.service.UserPermissionService;
import com.fjut.oj.util.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author axiang [20190708]
 */
@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private UserPermissionService permissionService;


    /**
     * 查询一个用户所有的权限
     */
    @GetMapping("/getUserPermission")
    public JsonInfo queryUserPermission(HttpServletRequest req, HttpServletResponse resp) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = req.getParameter("username");
        List<UserPer> list = permissionService.queryUserPermission(username);
        jsonInfo.setSuccess();
        jsonInfo.addInfo(list);
        return jsonInfo;
    }
}