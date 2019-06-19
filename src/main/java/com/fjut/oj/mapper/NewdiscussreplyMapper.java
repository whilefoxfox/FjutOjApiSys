package com.fjut.oj.mapper;

import com.fjut.oj.pojo.NewDiscussReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewdiscussreplyMapper {
    
    List<NewDiscussReply> queryDiscussReplyById(@Param("start") Integer start);
    
    Integer insertDiscussReply(@Param("newdiscussreply") NewDiscussReply newdiscussreply);
}
