package com.fjut.oj.controller;

import com.fjut.oj.pojo.t_message;
import com.fjut.oj.service.MessageService;
import com.fjut.oj.util.JsonInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    private static Logger logger = Logger.getLogger(MessageController.class);

    @RequestMapping("/delMessageByMid")
    @ResponseBody
    public JsonInfo delMessageByMid(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String midStr = request.getParameter("mid");
        Integer mid = Integer.parseInt(midStr);
        int res = messageService.deleteMessageByMid(mid);
        if (1 == res) {
            jsonInfo.setSuccess();
        } else {
            jsonInfo.setFail();
        }
        return jsonInfo;
    }

//    /**
//     * 根据用户名删除系统消息，功能有误暂时不上线
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping("/delAllMessageByUser")
//    @ResponseBody
//    public JsonInfo delAllMessageByUser(HttpServletRequest request, HttpServletResponse response) {
//        JsonInfo jsonInfo = new JsonInfo();
//        String username = request.getParameter("username");
//        System.out.println("****"+username+"****");
//        if (null != username) {
//            Integer res = messageService.deleteAllMessageByUser("username");
//            System.out.println("res: " + res);
//            if (0 < res) {
//                jsonInfo.setSuccess();
//                jsonInfo.addInfo(res);
//            } else {
//                jsonInfo.setFail();
//            }
//        } else {
//
//            jsonInfo.setFail();
//        }
//        return jsonInfo;
//    }

    @RequestMapping("/setReadedByMid")
    @ResponseBody
    public JsonInfo setReadedByMid(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String midStr = request.getParameter("mid");
        Integer mid = Integer.parseInt(midStr);
        Integer res = messageService.updateMessageStatuByMid(mid, 1);
        if (1 == res) {
            jsonInfo.setSuccess();
        } else {
            jsonInfo.setFail();
        }
        return jsonInfo;
    }

    @RequestMapping("/setAllMessageReadByUser")
    @ResponseBody
    public JsonInfo setAllMessageReadByUser(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        if ("" != username) {
            int res = messageService.updateAllMessageReadByUser(username);
            if (0 != res) {
                jsonInfo.setSuccess();
                jsonInfo.addInfo(res);
            } else {
                jsonInfo.setFail();
            }

        } else {
            jsonInfo.setFail();
        }
        return jsonInfo;
    }


    @RequestMapping("/getUserMessage")
    @ResponseBody
    public JsonInfo getUserMessage(HttpServletRequest request, HttpServletResponse response) {

        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        String pageNumStr = request.getParameter("pagenum");
        Integer pageNum = Integer.parseInt(pageNumStr);
        Integer startIndex = null;
        if (null != pageNum) {
            startIndex = (pageNum - 1) * 10;
        }
        List<t_message> messages = messageService.queryAllMessageByUser(username, startIndex);
        int countMessage = messageService.queryAllMessageCountByUser(username);
        if (0 != messages.size()) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(messages);
            jsonInfo.addInfo(countMessage);
        } else {
            jsonInfo.setFail();
        }
        return jsonInfo;
    }

    @RequestMapping("/getUnReadMessageCountByUser")
    @ResponseBody
    public JsonInfo getUnReadMessageCountByUser(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        if (null != username) {
            Integer res = messageService.queryUnReadMessageCountByUser(username);
            if (0 == res) {
                jsonInfo.setFail();
            } else {
                jsonInfo.setSuccess();
            }
            jsonInfo.addInfo(res);
        }
        return jsonInfo;
    }

    @RequestMapping("/getUnReadMessageByUser")
    @ResponseBody
    public JsonInfo getUnReadMessageByUser(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        String pageNumStr = request.getParameter("pagenum");
//        logger.debug(pageNumStr);
//        System.out.println("username: " + username + " pageNumStr: " +pageNumStr);
        Integer pageNum = Integer.parseInt(pageNumStr);
        Integer startIndex = null;
        if (null != pageNum) {
            startIndex = (pageNum - 1) * 10;
        }
//        System.out.println("startIndex: " + startIndex);
        List<t_message> messages = messageService.queryUnReadMessageByUser(username, startIndex);
        Integer unReadCount = messageService.queryUnReadMessageCountByUser(username);
        if (0 != messages.size()) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(messages);
            jsonInfo.addInfo(unReadCount);
        } else {
            jsonInfo.setFail();
        }
        return jsonInfo;

    }

}
