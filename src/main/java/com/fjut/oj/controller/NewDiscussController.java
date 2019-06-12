package com.fjut.oj.controller;

import com.fjut.oj.pojo.NewDiscuss;
import com.fjut.oj.service.NewDiscussService;
import com.fjut.oj.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/discuss")
public class NewDiscussController {

    @Autowired
    private NewDiscussService newDiscussService;

    @RequestMapping("/GDiscuss")
    @ResponseBody
    public JsonMsg queryDiscussByPage(HttpServletRequest req, HttpServletResponse resp) {
        String pagenumStr = req.getParameter("pagenum") == null ? "1" : req.getParameter("pagenum");
        Integer pagenum = Integer.parseInt(pagenumStr);
        Integer start = (pagenum - 1) * 50;

        Integer totalNum = newDiscussService.queryDiscussCount();
        Integer totalPage = (totalNum % 50 == 0) ? totalNum / 50 : totalNum / 50 + 1;

        List<NewDiscuss> list = newDiscussService.queryDiscussByPage(start);
        return JsonMsg.success().addInfo(totalPage).addInfo(list);
    }

    @RequestMapping("/insertDiscuss")
    @ResponseBody
    public JsonMsg insertDiscuss(HttpServletRequest req, HttpServletResponse resp) {
        NewDiscuss newDiscuss = new NewDiscuss();
        String title = req.getParameter("title");

        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);

        String author = req.getParameter("author");
        System.out.println(req.getParameter("priority"));
        Double priority = Double.parseDouble(req.getParameter("priority") == null ? "-1" : req.getParameter("priority"));

        newDiscuss.setTitle(title);
        newDiscuss.setTime(dateString);
        newDiscuss.setAuthor(author);
        newDiscuss.setPriority(priority);

        Integer num = newDiscussService.insertDiscuss(newDiscuss);
        if (num == 0) {
            return JsonMsg.fail().addInfo("新建讨论失败");
        }
        return JsonMsg.success().addInfo("新建讨论成功");
    }

    @RequestMapping("/UPriority")
    @ResponseBody
    public JsonMsg updatePriority(HttpServletRequest req, HttpServletResponse resp) {
        String idStr = req.getParameter("id");
        String priorityStr = req.getParameter("priority");
        if (idStr == null || priorityStr == null){
            return JsonMsg.fail().addInfo("未传入id 或者 priority");
        }
        Integer id = Integer.parseInt(idStr);
        Double priority = Double.parseDouble(priorityStr);

        Integer num = newDiscussService.updateDisscussPirority(id,priority);
        if (num == 0){
            return JsonMsg.fail().addInfo("修改失败");
        }
        return JsonMsg.success().addInfo("修改成功");
    }
}
