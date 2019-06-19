package com.fjut.oj.mapper;

import com.fjut.oj.pojo.t_message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {

    Integer insertMessage(@Param("message") t_message message);

    Integer deleteMessageByMid(@Param("mid")int mid);

    Integer deleteAllMessageByUser(@Param("username") String username);

    Integer updateMessageStatuByMid(@Param("mid") int mid, @Param("status") int status);

    Integer updateAllMessageReadByUser(@Param("username") String username);

    Integer queryMessageCountByUser(@Param("username") String username);

    Integer queryUnReadMessageCountByUser(@Param("username") String username);

    List<t_message> queryUnReadMessageByUser(@Param("username") String username, @Param("startIndex") int startIndex);

    List<t_message> queryAllMessageByUser(@Param("username") String username, @Param("startIndex") int startIndex);

}
