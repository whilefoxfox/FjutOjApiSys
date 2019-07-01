package com.fjut.oj.controller;

import com.fjut.oj.pojo.*;
import com.fjut.oj.util.ChallengeBlockType;
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

    @RequestMapping("/getAllChallengeBlocksByUsername")
    public JsonInfo getAllChallengeBlocks(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        List<ChallengeBlockForUser> res = new ArrayList<>();
        String username = request.getParameter("username");
        List<ChallengeBlockForUser> allBlocks = challengeService.queryAllChallengeBlocks();
        if (null != username && !("").equals(username)) {
            Map<Integer, ChallengeBlockForUser> map = new TreeMap<>();
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
                if (showedIds.contains(key)) {
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

    @RequestMapping("/getBlockDetail")
    public JsonInfo getBlockDetail(HttpServletRequest request, HttpServletResponse response) {
        JsonInfo jsonInfo = new JsonInfo();
        String blockIdStr = request.getParameter("blockId");
        String username = request.getParameter("username");
        Integer blockId = Integer.parseInt(blockIdStr);
        t_challenge_block block = challengeService.queryChallengeBlockByBlockId(blockId);
        // add by axiang [20190628] 获取该模块的全部得到分值
        List<ChallengeBlockForUser> getScores = challengeService.queryChallengeBlocksScoredByUsername(username);
        Integer getScore = 0;
        for (ChallengeBlockForUser get : getScores) {
            if (get.getId().equals(blockId)) {
                getScore = get.getGetScore();
            }
        }
        Integer totalScore = challengeService.queryChallengeBlockTotalScoreByBlockId(blockId);
        ChallengeBlockDetail challengeBlockDetail = new ChallengeBlockDetail();
        if (null != block) {
            challengeBlockDetail.setId(block.getId());
            challengeBlockDetail.setName(block.getName());
            challengeBlockDetail.setType(ChallengeBlockType.getNameByID(block.getGro()));
            challengeBlockDetail.setDes(block.getText());
            challengeBlockDetail.setTotalScore(totalScore);
            jsonInfo.setSuccess();
            jsonInfo.addInfo(challengeBlockDetail);
            jsonInfo.addInfo(getScore);
        } else {
            jsonInfo.setFail("未找到该挑战模块");
        }
        return jsonInfo;
    }

    @RequestMapping("/getBlockProblems")
    public JsonInfo getBlockProblems(HttpServletRequest request) {
        long ms = System.currentTimeMillis();
        JsonInfo jsonInfo = new JsonInfo();
        String username = request.getParameter("username");
        String blockIdStr = request.getParameter("blockId");
        String pagenumStr = request.getParameter("pageNum");
        Integer blockId = Integer.parseInt(blockIdStr);
        Integer pageNum = Integer.parseInt(pagenumStr);
        Integer startIndex = (pageNum - 1) * 15;
        long ms1= System.currentTimeMillis();
        List<ChallengeProblemForBlock> challengeProblems = challengeService.queryChallengeBlockProblemByBlockId(blockId, startIndex);
        long me1 = System.currentTimeMillis();
        System.out.println("get problem: "+(me1-ms1)+" ms");
        Integer count = challengeService.queryChallengeBlockProblemCountByBlockId(blockId);
        if (null == username) {
            jsonInfo.setFail("参数错误！");
            return jsonInfo;
        }
        if (0 < count) {
            long ms2= System.currentTimeMillis();
            List<Status> statuses = challengeService.queryAllBlockSolvedProblemByUsername(username);
            long me2 = System.currentTimeMillis();
            System.out.println("get solved status: "+(me2-ms2)+" ms");
            Map<Integer, Integer> statusMap = new TreeMap<>();
            for (Status status : statuses) {
                // add by axiang [20190701] 提交状态有多个并且包含AC时，只保留AC的一个或者其他的最新状态
                if (null == statusMap.get(status.getPid())) {
                    statusMap.put(status.getPid(), status.getResult());
                } else if (1 != statusMap.get(status.getPid())) {
                    statusMap.put(status.getPid(), status.getResult());
                }
            }
            for (ChallengeProblemForBlock problem : challengeProblems) {
                if (null == statusMap.get(problem.getTrueProblemId())) {
                    problem.setSolved(0);
                    // 未设置 即表示未做过该题
                } else if (1 == statusMap.get(problem.getTrueProblemId())) {
                    problem.setSolved(1);
                } else {
                    problem.setSolved(2);
                }
            }
            jsonInfo.setSuccess();
            jsonInfo.addInfo(challengeProblems);
            jsonInfo.addInfo(count);
        } else {
            jsonInfo.setFail("模块内没有题目");
        }
        long me = System.currentTimeMillis();
        System.out.println("method get problem use time: "+(me-ms)+" ms");
        return jsonInfo;
    }

}
