package com.fjut.oj.controller;

import com.fjut.oj.pojo.t_problem_tag;
import com.fjut.oj.service.ProblemTagService;
import com.fjut.oj.util.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cjt
 */
@Controller
@CrossOrigin
@ResponseBody
@RequestMapping("/problemTag")
public class ProblemTagController {

    @Autowired
    private ProblemTagService problemTagService;

    @GetMapping("/getAllProblemTag")
    public JsonInfo queryAllProblemTag() {
        JsonInfo jsonInfo = new JsonInfo();
        List<t_problem_tag> list = problemTagService.queryAllProblemTag();
        if (0 < list.size()) {
            jsonInfo.setSuccess();
            jsonInfo.addInfo(list);
        } else {
            jsonInfo.setFail("未找到标签");
        }
        return jsonInfo;
    }
}
