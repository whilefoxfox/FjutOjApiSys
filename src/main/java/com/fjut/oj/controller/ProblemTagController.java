package com.fjut.oj.controller;

import com.fjut.oj.pojo.Problem_tag;
import com.fjut.oj.service.ProblemTagService;
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
 * @author cjt
 * TODO: 把 JsonMsg 替换为 JsonInfo
 */
@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/problemTag")
public class ProblemTagController {

    @Autowired
    private ProblemTagService problemTagService;

    @GetMapping("/getAllProblemTag")
    public List<Problem_tag> queryAllProblemTag(){
        List<Problem_tag> list = problemTagService.queryAllProblemTag();
        return list;
    }
}
