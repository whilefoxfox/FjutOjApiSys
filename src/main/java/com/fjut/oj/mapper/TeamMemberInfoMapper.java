package com.fjut.oj.mapper;

import com.fjut.oj.pojo.TeamMemberInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamMemberInfoMapper {

    public List<TeamMemberInfo> queryAllTeamMemberInfo(@Param("start") Integer start);

    public Integer queryAllCountTeamMemberInfo();

    public TeamMemberInfo queryTeamMemberInfoById(@Param("id") Integer id);

    public Integer insertTeamMemberInfo(@Param("teamMemberInfo") TeamMemberInfo teamMemberInfo);

    public Integer replaceTeamMemberInfo(@Param("teamMemberInfo") TeamMemberInfo teamMemberInfo);
}
