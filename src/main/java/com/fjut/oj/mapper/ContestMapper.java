package com.fjut.oj.mapper;

import com.fjut.oj.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContestMapper {
    public List<Contest> getAllContest(@Param("pagenum") Integer pagenum);
    public Contest getContestById(@Param("cid")Integer cid);
    public List<Contestuser> getContestUsers(@Param("cid") int cid, @Param("pagenum") int pagenum);
    public Integer getContestUsersNum(@Param("cid") int cid);
    public Integer getAllContestNum();
    public List<ContestProblemInfo> getContestProblem(@Param("cid") int cid);
    public List<Status> getContestStatus(@Param("cid") int cid,@Param("pagenum") int pagenum);
    public List<ContestRank> getContestRank(@Param("cid") int cid);
    public String getContestPassword(@Param("cid") Integer cid);
    public Integer getContestUser(@Param("cid")Integer cid, @Param("username")String username);

    public Integer insertContest(@Param("contest") Contest contest);
    public Integer getMaxContestId();
    public Integer insertContestProblem(@Param("contestProblem")ContestProblem contestProblem);
    public Integer insertContestuser(@Param("contestuser")Contestuser contestuser);
    public Integer getContestStatusNum(@Param("cid")Integer cid);
}
