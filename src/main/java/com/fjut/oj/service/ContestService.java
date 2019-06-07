package com.fjut.oj.service;

import com.fjut.oj.pojo.*;

import java.util.List;

public interface ContestService {

    public List<Contest> getAllContest(Integer pagenum);
    public Contest getContestById(Integer cid);
    public List<Contestuser> getContestUsers(int cid, int pagenum);
    public Integer getContestUsersNum(int cid);
    public Integer getAllContestNum();
    public List<ContestProblemInfo> getContestProblem(Integer cid);
    public List<Status> getContestStatus(Integer cid,Integer pagenum);
    public List<ContestRank> getContestRank(Integer cid);
    public String getContestPassword(Integer cid);
    public Integer getContestUser(Integer cid,String username);

    public Integer insertContest(Contest contest);
    public Integer getMaxContestId();
    public Integer insertContestProblem(ContestProblem contestProblem);
    public Integer insertContestuser(Contestuser contestuser);
    public Integer getContestStatusNum(Integer cid);
}
