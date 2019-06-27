package com.fjut.oj.controller;

import com.fjut.oj.pojo.ChallengeBlockForUser;
import com.fjut.oj.pojo.ChallengeConditionForBlock;
import com.fjut.oj.pojo.t_challenge_condition;
import com.fjut.oj.service.ChallengeService;
import com.fjut.oj.util.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author: wyx
 * @Despriction:
 * @Date:Created in 10:43 2019/6/25
 * @Modify By:
 */
@Controller
@CrossOrigin
@RequestMapping("/challenge")
@ResponseBody
public class ChallengeController {
    @Autowired
    ChallengeService challengeService;

    @RequestMapping("/getAllChallengeBlocks")
    public JsonInfo getAllChallengeBlocks(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        List<ChallengeBlockForUser> res = new ArrayList<>();
        String username = request.getParameter("username");
        List<ChallengeBlockForUser> allBlocks = challengeService.queryAllChallengeBlocks();
        if (null != username && !("").equals(username)) {
            // FIXME:出BUG 了还没修！！！
            Map<Integer, ChallengeBlockForUser> map = new HashMap<>();
            List<Integer> showedIds = challengeService.queryShowedChallengeBlocksByUsername(username);
            for (ChallengeBlockForUser challengeBlock : allBlocks) {
                challengeBlock.setLocked(true);
                challengeBlock.setGetScore(0);
                map.put(challengeBlock.getId(), challengeBlock);

            }
            List<Integer> openBlocks = challengeService.queryChallengeOpenBlocksByUsername(username);
            for (Integer openBlockId : openBlocks) {
                ChallengeBlockForUser temp = map.get(openBlockId);
                temp.setLocked(false);
                map.put(temp.getId(), temp);
            }
            List<ChallengeBlockForUser> challengeBlockScored = challengeService.queryChallengeBlocksScoredByUsername(username);
            for (ChallengeBlockForUser challengeBlock : challengeBlockScored) {
                ChallengeBlockForUser temp = map.get(challengeBlock.getId());
                temp.setGetScore(challengeBlock.getGetScore());
                map.put(temp.getId(), temp);
            }
            for (Integer key : map.keySet()) {
                if(showedIds.contains(key)){
                    res.add(map.get(key));
                }

            }
            List<t_challenge_condition> allConditions = challengeService.queryAllChallengeConditions();
            jsonInfo.setSuccess();
            jsonInfo.addInfo(res);
            jsonInfo.addInfo(allConditions);
        } else {
            jsonInfo.setError("参数不正确！");
        }

        return jsonInfo;
    }

    @RequestMapping("/getConditionByBlockId")
    public JsonInfo getConditionByBlockId(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String blockIdStr = request.getParameter("blockId");
        Integer blockId = Integer.parseInt(blockIdStr);
        List<ChallengeConditionForBlock> conditions = challengeService.queryChallengeConditionByBlockId(blockId);
        if (0 < conditions.size()) {
            jsonInfo.setSuccess("有解锁条件");
            jsonInfo.addInfo(conditions);
        } else {
            jsonInfo.setSuccess("没有解锁条件");
        }
        return jsonInfo;
    }

}
