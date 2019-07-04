package com.fjut.oj.judge.entity.OJ.JudgeSystem;

import com.fjut.oj.judge.entity.OJ.CodeLanguage;
import com.fjut.oj.judge.entity.OJ.OTHOJ;
import com.fjut.oj.judge.entity.RES;
import com.fjut.oj.judge.util.HTML.problemHTML;
import com.fjut.oj.judge.util.Pair;
import com.fjut.oj.judge.util.Vjudge.VjSubmitter;

import java.util.List;

public class JudgeSystem extends OTHOJ {
    @Override
    public String getRid(String user, VjSubmitter s) {
        return null;
    }

    @Override
    public problemHTML getProblemHTML(String pid) {
        return null;
    }

    @Override
    public String getTitle(String pid) {
        return null;
    }

    @Override
    public String submit(VjSubmitter s) {
        return null;
    }

    @Override
    public RES getResult(VjSubmitter s) {
        return null;
    }

    @Override
    public String getProblemURL(String pid) {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String get64IO(String pid) {
        return null;
    }

    @Override
    public List<Pair<Integer, CodeLanguage>> getLanguageList(String pid) {
        return null;
    }
}
