package com.fjut.oj.service.serviceImpl;

import com.fjut.oj.mapper.ProblemMapper;
import com.fjut.oj.pojo.Problem;
import com.fjut.oj.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("problemService")
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Problem> queryAllProblems() {
        List<Problem> list = problemMapper.queryAllProblems();
        return list;
    }

    @Override
    public Problem queryProblemById(Integer pid) {
        Problem problem = problemMapper.queryProblemById(pid);
        return problem;
    }

    @Override
    public List<Problem> queryProblemByTitle(String title) {
        List<Problem> list = problemMapper.queryProblemByTitle(title);
        return list;
    }
}
