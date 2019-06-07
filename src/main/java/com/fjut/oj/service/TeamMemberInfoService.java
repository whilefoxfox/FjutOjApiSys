package com.fjut.oj.service;

import com.fjut.oj.pojo.TeamMemberInfo;

import java.util.List;

public interface TeamMemberInfoService {

    public List<TeamMemberInfo> queryAllTeamMemberInfo(Integer start);

    public Integer queryAllCountTeamMemberInfo();

    public TeamMemberInfo queryTeamMemberInfoById(Integer id);

    public Integer insertTeamMemberInfo(TeamMemberInfo teamMemberInfo);

    public Integer replaceTeamMemberInfo(TeamMemberInfo teamMemberInfo);
}
