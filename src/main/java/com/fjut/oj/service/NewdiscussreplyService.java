package com.fjut.oj.service;

import com.fjut.oj.pojo.NewDiscussReply;

import java.util.List;

public interface NewdiscussreplyService {

    List<NewDiscussReply> queryDiscussReplyById(Integer start, Integer id);

    Integer insertDiscussReply(NewDiscussReply newdiscussreply);

    Integer quertCountReplies(Integer discussid);
}
